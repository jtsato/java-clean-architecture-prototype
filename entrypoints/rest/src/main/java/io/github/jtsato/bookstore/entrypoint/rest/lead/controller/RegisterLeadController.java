package io.github.jtsato.bookstore.entrypoint.rest.lead.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.usecase.RegisterLeadUseCase;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.RegisterLeadParameters;
import io.github.jtsato.bookstore.entrypoint.rest.lead.api.RegisterLeadApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.request.RegisterLeadRequest;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response.RegisterLeadResponse;
import io.github.jtsato.bookstore.entrypoint.rest.lead.mapper.RegisterLeadPresenter;
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
public class RegisterLeadController implements RegisterLeadApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterLeadController.class);

    private final RegisterLeadUseCase registerLeadUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterLeadResponse execute(@RequestBody @DefaultValue final RegisterLeadRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterLeadController with {}", jsonRequest);

        final RegisterLeadParameters parameters = new RegisterLeadParameters(request.getSelfiePhoto(),
                                                                             request.getCpf(),
                                                                             request.getCellphone(),
                                                                             request.getName(),
                                                                             request.getMotherFullName(),
                                                                             request.getGender(),
                                                                             request.getEducation(),
                                                                             request.getMaritalStatus(),
                                                                             request.getStableUnion(),
                                                                             request.getBirthdate());

        final Lead lead = registerLeadUseCase.execute(parameters);
        return RegisterLeadPresenter.of(lead);
    }
}
