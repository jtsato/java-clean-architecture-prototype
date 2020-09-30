package io.github.jtsato.bookstore.entrypoint.rest.documenttype.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.usecase.FindDocumentTypesByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.api.FindDocumentTypesByIdsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.request.FindDocumentTypesByIdsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.FindDocumentTypesByIdsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.mapper.FindDocumentTypesByIdsPresenter;
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
@RequestMapping("/document-types")
public class FindDocumentTypesByIdsController implements FindDocumentTypesByIdsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindDocumentTypesByIdsController.class);

    private final FindDocumentTypesByIdsUseCase findDocumentTypesByIdsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByIds")
    public FindDocumentTypesByIdsWrapperResponse execute(@RequestBody @DefaultValue final FindDocumentTypesByIdsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindDocumentTypesByIdsController with {}", jsonRequest);

        final Page<DocumentType> documentTypes = findDocumentTypesByIdsUseCase.execute(request.getIds());

        return FindDocumentTypesByIdsPresenter.of(documentTypes);
    }
}

