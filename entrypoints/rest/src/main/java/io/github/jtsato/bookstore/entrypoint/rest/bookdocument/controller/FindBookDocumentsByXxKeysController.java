package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.usecase.FindBookDocumentsByXxKeysUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.api.FindBookDocumentsByXxKeysApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request.FindBookDocumentsByXxKeysRequest;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.FindBookDocumentsByXxKeysWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper.FindBookDocumentsByXxKeysPresenter;
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
@RequestMapping("/book-documents")
public class FindBookDocumentsByXxKeysController implements FindBookDocumentsByXxKeysApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindBookDocumentsByXxKeysController.class);

    private final FindBookDocumentsByXxKeysUseCase findBookDocumentsByXxKeysUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByXxKeys")
    public FindBookDocumentsByXxKeysWrapperResponse execute(@RequestBody @DefaultValue final FindBookDocumentsByXxKeysRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindBookDocumentsByXxKeysController with {}", jsonRequest);

        final Page<BookDocument> bookDocuments = findBookDocumentsByXxKeysUseCase.execute(request.getXxKeys());

        return FindBookDocumentsByXxKeysPresenter.of(bookDocuments);
    }
}

