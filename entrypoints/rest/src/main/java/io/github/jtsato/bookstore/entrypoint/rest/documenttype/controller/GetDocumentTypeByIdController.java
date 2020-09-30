package io.github.jtsato.bookstore.entrypoint.rest.documenttype.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.usecase.GetDocumentTypeByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.api.GetDocumentTypeByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.GetDocumentTypeByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.mapper.GetDocumentTypeByIdPresenter;
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
public class GetDocumentTypeByIdController implements GetDocumentTypeByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetDocumentTypeByIdController.class);

    private final GetDocumentTypeByIdUseCase getDocumentTypeByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GetDocumentTypeByIdResponse execute(@PathVariable final Long id) {

        log.info("Starting Controller -> GetDocumentTypeByIdController with {}", id);

        final DocumentType documentType = getDocumentTypeByIdUseCase.execute(id);
        return GetDocumentTypeByIdPresenter.of(documentType);
    }
}
