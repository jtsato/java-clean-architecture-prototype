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
import io.github.jtsato.bookstore.core.file.usecase.FindFilesByIdsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.file.api.FindFilesByIdsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.request.FindFilesByIdsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.response.FindFilesByIdsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.file.mapper.FindFilesByIdsPresenter;
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
public class FindFilesByIdsController implements FindFilesByIdsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(FindFilesByIdsController.class);

    private final FindFilesByIdsUseCase findFilesByIdsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findByIds")
    public FindFilesByIdsWrapperResponse execute(@RequestBody @DefaultValue final FindFilesByIdsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> FindFilesByIdsController with {}", jsonRequest);

        final Page<File> files = findFilesByIdsUseCase.execute(request.getIds());

        return FindFilesByIdsPresenter.of(files);
    }
}

