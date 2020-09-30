package io.github.jtsato.bookstore.entrypoint.rest.file.controller;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.usecase.parameter.SearchFilesParameters;
import io.github.jtsato.bookstore.core.file.usecase.SearchFilesUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.file.api.SearchFilesApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.request.SearchFilesRequest;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.response.SearchFilesWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.file.mapper.SearchFilesPresenter;
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
public class SearchFilesController implements SearchFilesApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchFilesController.class);

    private final SearchFilesUseCase searchFilesUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchFilesWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchFilesRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchFilesController with {}", jsonRequest);

        final SearchFilesParameters parameters = buildSearchFilesParameters(request);
        final Page<File> files = searchFilesUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchFilesPresenter.of(files);
    }

    private SearchFilesParameters buildSearchFilesParameters(final SearchFilesRequest searchFilesRequest) {

        final Long id = searchFilesRequest.getId();
        final ImmutablePair<Long, Long> sizeRange = new ImmutablePair<>(searchFilesRequest.getStartSize(), searchFilesRequest.getEndSize());
        final String contentType = searchFilesRequest.getContentType();
        final String extension = searchFilesRequest.getExtension();
        final String name = searchFilesRequest.getName();
        final String content = searchFilesRequest.getContent();
        final String url = searchFilesRequest.getUrl();
        final ImmutablePair<String, String> creationDateRange = new ImmutablePair<>(searchFilesRequest.getStartCreationDate(), searchFilesRequest.getEndCreationDate());
        final ImmutablePair<String, String> lastModifiedDateRange = new ImmutablePair<>(searchFilesRequest.getStartLastModifiedDate(), searchFilesRequest.getEndLastModifiedDate());
        return new SearchFilesParameters(id, sizeRange, contentType, extension, name, content, url, creationDateRange, lastModifiedDateRange); 
    }
}
