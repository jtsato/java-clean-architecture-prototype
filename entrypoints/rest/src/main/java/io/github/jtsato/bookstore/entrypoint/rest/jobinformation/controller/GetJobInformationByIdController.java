package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.usecase.GetJobInformationByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.api.GetJobInformationByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.GetJobInformationByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.mapper.GetJobInformationByIdPresenter;
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
public class GetJobInformationByIdController implements GetJobInformationByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetJobInformationByIdController.class);

    private final GetJobInformationByIdUseCase getJobInformationByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GetJobInformationByIdResponse execute(@PathVariable final Long id) {

        log.info("Starting Controller -> GetJobInformationByIdController with {}", id);

        final JobInformation jobInformation = getJobInformationByIdUseCase.execute(id);
        return GetJobInformationByIdPresenter.of(jobInformation);
    }
}
