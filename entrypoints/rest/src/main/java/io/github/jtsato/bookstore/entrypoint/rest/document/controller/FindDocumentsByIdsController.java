package io.github.jtsato.bookstore.entrypoint.rest.document.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.usecase.FindDocumentsByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.document.api.FindDocumentsByIdsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.request.FindDocumentsByIdsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.FindDocumentsByIdsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.mapper.FindDocumentsByIdsPresenter;
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
@RequestMapping("/documents")
public class FindDocumentsByIdsController implements FindDocumentsByIdsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindDocumentsByIdsController.class);

    private final FindDocumentsByIdsUseCase findDocumentsByIdsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByIds")
    public FindDocumentsByIdsWrapperResponse execute(@RequestBody @DefaultValue final FindDocumentsByIdsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindDocumentsByIdsController with {}", jsonRequest);

        final Page<Document> documents = findDocumentsByIdsUseCase.execute(request.getIds());

        return FindDocumentsByIdsPresenter.of(documents);
    }
}

