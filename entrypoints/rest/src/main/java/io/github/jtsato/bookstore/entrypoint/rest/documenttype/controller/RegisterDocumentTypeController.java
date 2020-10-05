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
import io.github.jtsato.bookstore.core.documenttype.usecase.RegisterDocumentTypeUseCase;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.RegisterDocumentTypeParameters;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.api.RegisterDocumentTypeApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.request.RegisterDocumentTypeRequest;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.RegisterDocumentTypeResponse;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.mapper.RegisterDocumentTypePresenter;
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
public class RegisterDocumentTypeController implements RegisterDocumentTypeApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterDocumentTypeController.class);

    private final RegisterDocumentTypeUseCase registerDocumentTypeUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterDocumentTypeResponse execute(@RequestBody @DefaultValue final RegisterDocumentTypeRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterDocumentTypeController with {}", jsonRequest);

        final RegisterDocumentTypeParameters parameters = new RegisterDocumentTypeParameters(request.getCountry(),
                                                                                             request.getDescription());

        final DocumentType documentType = registerDocumentTypeUseCase.execute(parameters);
        return RegisterDocumentTypePresenter.of(documentType);
    }
}
