package io.github.jtsato.bookstore.entrypoint.rest.file.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.usecase.RegisterFileUseCase;
import io.github.jtsato.bookstore.core.file.usecase.parameter.RegisterFileParameters;
import io.github.jtsato.bookstore.entrypoint.rest.file.api.RegisterFileApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.request.RegisterFileRequest;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.response.RegisterFileResponse;
import io.github.jtsato.bookstore.entrypoint.rest.file.mapper.RegisterFilePresenter;
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
@RequestMapping("/files")
public class RegisterFileController implements RegisterFileApiMethod {

    private static final Logger log = LoggerFactory.getLogger(RegisterFileController.class);

    private final RegisterFileUseCase registerFileUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RegisterFileResponse execute(@RequestBody @DefaultValue final RegisterFileRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> RegisterFileController with {}", jsonRequest);

        final RegisterFileParameters parameters = new RegisterFileParameters(request.getSize(),
                                                                             request.getContentType(),
                                                                             request.getExtension(),
                                                                             request.getName(),
                                                                             request.getContent(),
                                                                             request.getUrl(),
                                                                             request.getCreationDate(),
                                                                             request.getLastModifiedDate());

        final File file = registerFileUseCase.execute(parameters);
        return RegisterFilePresenter.of(file);
    }
}
