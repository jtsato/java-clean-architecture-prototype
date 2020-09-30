package io.github.jtsato.bookstore.entrypoint.rest.document.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.usecase.GetDocumentByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.document.api.GetDocumentByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.GetDocumentByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.mapper.GetDocumentByIdPresenter;
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
@RequestMapping("/documents")
public class GetDocumentByIdController implements GetDocumentByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetDocumentByIdController.class);

    private final GetDocumentByIdUseCase getDocumentByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GetDocumentByIdResponse execute(@PathVariable final Long id) {

        log.info("Starting Controller -> GetDocumentByIdController with {}", id);

        final Document document = getDocumentByIdUseCase.execute(id);
        return GetDocumentByIdPresenter.of(document);
    }
}
