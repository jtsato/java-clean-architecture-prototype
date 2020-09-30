package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.jobinformation.usecase.RemoveJobInformationByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.api.RemoveJobInformationByIdApiMethod;
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
public class RemoveJobInformationByIdController implements RemoveJobInformationByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RemoveJobInformationByIdController.class);

    private final RemoveJobInformationByIdUseCase removeJobInformationByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void execute(@PathVariable final Long id) {

        log.info("Starting Controller -> RemoveJobInformationByIdController with {}", id);

        removeJobInformationByIdUseCase.execute(id);
    }
}
