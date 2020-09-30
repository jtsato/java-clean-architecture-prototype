package io.github.jtsato.bookstore.entrypoint.rest.documenttype.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.documenttype.usecase.RemoveDocumentTypeByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.api.RemoveDocumentTypeByIdApiMethod;
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
@RequestMapping("/document-types")
public class RemoveDocumentTypeByIdController implements RemoveDocumentTypeByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RemoveDocumentTypeByIdController.class);

    private final RemoveDocumentTypeByIdUseCase removeDocumentTypeByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void execute(@PathVariable final Long id) {

        log.info("Starting Controller -> RemoveDocumentTypeByIdController with {}", id);

        removeDocumentTypeByIdUseCase.execute(id);
    }
}
