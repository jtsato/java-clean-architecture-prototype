package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.usecase.UpdateBookDocumentByXxKeyUseCase;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.UpdateBookDocumentByXxKeyParameters;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.api.UpdateBookDocumentByXxKeyApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request.UpdateBookDocumentByXxKeyRequest;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.UpdateBookDocumentByXxKeyResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper.UpdateBookDocumentByXxKeyPresenter;
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
public class UpdateBookDocumentByXxKeyController implements UpdateBookDocumentByXxKeyApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateBookDocumentByXxKeyController.class);

    private final UpdateBookDocumentByXxKeyUseCase updateBookDocumentByXxKeyUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{xxKey}")
    public UpdateBookDocumentByXxKeyResponse execute(@PathVariable final Long xxKey, @RequestBody @DefaultValue final UpdateBookDocumentByXxKeyRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateBookDocumentByXxKeyController with {}", jsonRequest);

        final UpdateBookDocumentByXxKeyParameters parameters = new UpdateBookDocumentByXxKeyParameters(xxKey,
                                                                                                       request.getBookId(),
                                                                                                       request.getSize(),
                                                                                                       request.getContentType(),
                                                                                                       request.getExtension(),
                                                                                                       request.getName(),
                                                                                                       request.getContent(),
                                                                                                       request.getCreationDate(),
                                                                                                       request.getLastModifiedDate());
        final BookDocument bookDocument = updateBookDocumentByXxKeyUseCase.execute(parameters);
        return UpdateBookDocumentByXxKeyPresenter.of(bookDocument);
    }
}
