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
import io.github.jtsato.bookstore.core.document.usecase.RegisterDocumentUseCase;
import io.github.jtsato.bookstore.core.document.usecase.parameter.RegisterDocumentParameters;
import io.github.jtsato.bookstore.entrypoint.rest.document.api.RegisterDocumentApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.request.RegisterDocumentRequest;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.RegisterDocumentResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.mapper.RegisterDocumentPresenter;
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
public class RegisterDocumentController implements RegisterDocumentApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterDocumentController.class);

    private final RegisterDocumentUseCase registerDocumentUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterDocumentResponse execute(@RequestBody @DefaultValue final RegisterDocumentRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterDocumentController with {}", jsonRequest);

        final RegisterDocumentParameters parameters = new RegisterDocumentParameters(request.getLeadId(),
                                                                                     request.getTypeId(),
                                                                                     request.getFrontPhoto(),
                                                                                     request.getBackPhoto(),
                                                                                     request.getNumber(),
                                                                                     request.getIssuer(),
                                                                                     request.getState(),
                                                                                     request.getIssueDate(),
                                                                                     request.getCreatedDateTime(),
                                                                                     request.getLastModifiedDateTime());

        final Document document = registerDocumentUseCase.execute(parameters);
        return RegisterDocumentPresenter.of(document);
    }
}
