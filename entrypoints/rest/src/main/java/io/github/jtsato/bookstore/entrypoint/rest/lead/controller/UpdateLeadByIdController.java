package io.github.jtsato.bookstore.entrypoint.rest.lead.controller;

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

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.usecase.UpdateLeadByIdUseCase;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.UpdateLeadByIdParameters;
import io.github.jtsato.bookstore.entrypoint.rest.lead.api.UpdateLeadByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.request.UpdateLeadByIdRequest;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response.UpdateLeadByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.lead.mapper.UpdateLeadByIdPresenter;
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
@RequestMapping("/leads")
public class UpdateLeadByIdController implements UpdateLeadByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateLeadByIdController.class);

    private final UpdateLeadByIdUseCase updateLeadByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UpdateLeadByIdResponse execute(@PathVariable final Long id, @RequestBody @DefaultValue final UpdateLeadByIdRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateLeadByIdController with {}", jsonRequest);

        final UpdateLeadByIdParameters parameters = new UpdateLeadByIdParameters(id,
                                                                                 request.getSelfiePhoto(),
                                                                                 request.getCpf(),
                                                                                 request.getCellphone(),
                                                                                 request.getName(),
                                                                                 request.getMotherFullName(),
                                                                                 request.getGender(),
                                                                                 request.getEducation(),
                                                                                 request.getMaritalStatus(),
                                                                                 request.getStableUnion(),
                                                                                 request.getBirthdate());
        final Lead lead = updateLeadByIdUseCase.execute(parameters);
        return UpdateLeadByIdPresenter.of(lead);
    }
}
