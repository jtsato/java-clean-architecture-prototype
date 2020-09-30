package io.github.jtsato.bookstore.entrypoint.rest.file.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.usecase.GetFileByIdUseCase;
import io.github.jtsato.bookstore.entrypoint.rest.file.api.GetFileByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.response.GetFileByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.file.mapper.GetFileByIdPresenter;
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
public class GetFileByIdController implements GetFileByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetFileByIdController.class);

    private final GetFileByIdUseCase getFileByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GetFileByIdResponse execute(@PathVariable final Long id) {

        log.info("Starting Controller -> GetFileByIdController with {}", id);

        final File file = getFileByIdUseCase.execute(id);
        return GetFileByIdPresenter.of(file);
    }
}
