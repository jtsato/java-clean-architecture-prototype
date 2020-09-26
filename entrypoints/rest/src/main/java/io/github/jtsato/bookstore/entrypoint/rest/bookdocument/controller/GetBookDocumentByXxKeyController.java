package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.usecase.GetBookDocumentByXxKeyUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.api.GetBookDocumentByXxKeyApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.GetBookDocumentByXxKeyResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper.GetBookDocumentByXxKeyPresenter;
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
public class GetBookDocumentByXxKeyController implements GetBookDocumentByXxKeyApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetBookDocumentByXxKeyController.class);

    private final GetBookDocumentByXxKeyUseCase getBookDocumentByXxKeyUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{xxKey}")
    public GetBookDocumentByXxKeyResponse execute(@PathVariable final Long xxKey) {

        log.info("Starting Controller -> GetBookDocumentByXxKeyController with {}", xxKey);

        final BookDocument bookDocument = getBookDocumentByXxKeyUseCase.execute(xxKey);
        return GetBookDocumentByXxKeyPresenter.of(bookDocument);
    }
}
