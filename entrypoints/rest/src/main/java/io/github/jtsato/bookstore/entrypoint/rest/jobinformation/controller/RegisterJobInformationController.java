package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.usecase.RegisterJobInformationUseCase;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.RegisterJobInformationParameters;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.api.RegisterJobInformationApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.request.RegisterJobInformationRequest;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.RegisterJobInformationResponse;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.mapper.RegisterJobInformationPresenter;
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
@RequestMapping("/job-informations")
public class RegisterJobInformationController implements RegisterJobInformationApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterJobInformationController.class);

    private final RegisterJobInformationUseCase registerJobInformationUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterJobInformationResponse execute(@RequestBody @DefaultValue final RegisterJobInformationRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterJobInformationController with {}", jsonRequest);

        final RegisterJobInformationParameters parameters = new RegisterJobInformationParameters(request.getLeadId(),
                                                                                                 request.getAttach(),
                                                                                                 request.getProfession(),
                                                                                                 request.getReferenceMonth(),
                                                                                                 request.getReceiptType(),
                                                                                                 request.getStartDate(),
                                                                                                 request.getMonthlyIncome());

        final JobInformation jobInformation = registerJobInformationUseCase.execute(parameters);
        return RegisterJobInformationPresenter.of(jobInformation);
    }
}
