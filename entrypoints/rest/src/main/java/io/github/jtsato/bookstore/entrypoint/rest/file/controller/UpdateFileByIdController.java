package io.github.jtsato.bookstore.entrypoint.rest.file.controller;

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

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.usecase.UpdateFileByIdUseCase;
import io.github.jtsato.bookstore.core.file.usecase.parameter.UpdateFileByIdParameters;
import io.github.jtsato.bookstore.entrypoint.rest.file.api.UpdateFileByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.request.UpdateFileByIdRequest;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.response.UpdateFileByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.file.mapper.UpdateFileByIdPresenter;
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
public class UpdateFileByIdController implements UpdateFileByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateFileByIdController.class);

    private final UpdateFileByIdUseCase updateFileByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UpdateFileByIdResponse execute(@PathVariable final Long id, @RequestBody @DefaultValue final UpdateFileByIdRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateFileByIdController with {}", jsonRequest);

        final UpdateFileByIdParameters parameters = new UpdateFileByIdParameters(id,
                                                                                 request.getSize(),
                                                                                 request.getContentType(),
                                                                                 request.getExtension(),
                                                                                 request.getName(),
                                                                                 request.getContent(),
                                                                                 request.getUrl(),
                                                                                 request.getCreationDate(),
                                                                                 request.getLastModifiedDate());
        final File file = updateFileByIdUseCase.execute(parameters);
        return UpdateFileByIdPresenter.of(file);
    }
}
