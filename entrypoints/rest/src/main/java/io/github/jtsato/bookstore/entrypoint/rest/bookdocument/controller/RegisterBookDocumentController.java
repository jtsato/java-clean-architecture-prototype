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
import io.github.jtsato.bookstore.core.bookdocument.usecase.RegisterBookDocumentUseCase;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.RegisterBookDocumentParameters;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.api.RegisterBookDocumentApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request.RegisterBookDocumentRequest;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.RegisterBookDocumentResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper.RegisterBookDocumentPresenter;
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
public class RegisterBookDocumentController implements RegisterBookDocumentApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterBookDocumentController.class);

    private final RegisterBookDocumentUseCase registerBookDocumentUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterBookDocumentResponse execute(@RequestBody @DefaultValue final RegisterBookDocumentRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterBookDocumentController with {}", jsonRequest);

        final RegisterBookDocumentParameters parameters = new RegisterBookDocumentParameters(request.getBookId(),
                                                                                             request.getSize(),
                                                                                             request.getContentType(),
                                                                                             request.getExtension(),
                                                                                             request.getName(),
                                                                                             request.getContent(),
                                                                                             request.getCreationDate(),
                                                                                             request.getLastModifiedDate());

        final BookDocument bookDocument = registerBookDocumentUseCase.execute(parameters);
        return RegisterBookDocumentPresenter.of(bookDocument);
    }
}
