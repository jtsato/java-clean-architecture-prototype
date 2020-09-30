package io.github.jtsato.bookstore.entrypoint.rest.address.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.address.usecase.UpdateAddressByIdUseCase;
import io.github.jtsato.bookstore.core.address.usecase.parameter.UpdateAddressByIdParameters;
import io.github.jtsato.bookstore.entrypoint.rest.address.api.UpdateAddressByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.request.UpdateAddressByIdRequest;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.UpdateAddressByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.address.mapper.UpdateAddressByIdPresenter;
import io.github.jtsato.bookstore.entrypoint.rest.common.JsonConverter;
import io.github.jtsato.bookstore.entrypoint.rest.common.metric.LogExecutionTime;
import lombok.RequiredArgsConstructor;

/*
 * A EntryPoint follows these steps:
 *
 * - Maps HTTP requests to Java objects
 * - Performs authorization checks
 * - Maps input to the input model of the use case
 * - Calls the use case
 * - Maps the output of the use case back to HTTP Returns an HTTP response
 */

/**
 * @author Jorge Takeshi Sato
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class UpdateAddressByIdController implements UpdateAddressByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateAddressByIdController.class);

    private final UpdateAddressByIdUseCase updateAddressByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UpdateAddressByIdResponse execute(@PathVariable final Long id, @RequestBody @DefaultValue final UpdateAddressByIdRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateAddressByIdController with {}", jsonRequest);

        final UpdateAddressByIdParameters parameters = new UpdateAddressByIdParameters(id,
                                                                                       request.getLeadId(),
                                                                                       request.getZipCode(),
                                                                                       request.getCity(),
                                                                                       request.getState(),
                                                                                       request.getCountry(),
                                                                                       request.getDescription(),
                                                                                       request.getComplement(),
                                                                                       request.getNumber(),
                                                                                       request.getType(),
                                                                                       request.getCreatedDateTime(),
                                                                                       request.getLastModifiedDateTime());
        final Address address = updateAddressByIdUseCase.execute(parameters);
        return UpdateAddressByIdPresenter.of(address);
    }
}
