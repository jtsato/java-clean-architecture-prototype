package io.github.jtsato.bookstore.entrypoint.rest.documenttype.controller;

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

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.SearchDocumentTypesParameters;
import io.github.jtsato.bookstore.core.documenttype.usecase.SearchDocumentTypesUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.api.SearchDocumentTypesApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.request.SearchDocumentTypesRequest;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.SearchDocumentTypesWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.mapper.SearchDocumentTypesPresenter;
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
public class SearchDocumentTypesController implements SearchDocumentTypesApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchDocumentTypesController.class);

    private final SearchDocumentTypesUseCase searchDocumentTypesUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchDocumentTypesWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchDocumentTypesRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchDocumentTypesController with {}", jsonRequest);

        final SearchDocumentTypesParameters parameters = buildSearchDocumentTypesParameters(request);
        final Page<DocumentType> documentTypes = searchDocumentTypesUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchDocumentTypesPresenter.of(documentTypes);
    }

    private SearchDocumentTypesParameters buildSearchDocumentTypesParameters(final SearchDocumentTypesRequest searchDocumentTypesRequest) {

        final Long id = searchDocumentTypesRequest.getId();
        final String country = searchDocumentTypesRequest.getCountry();
        final String description = searchDocumentTypesRequest.getDescription();
        final ImmutablePair<String, String> createdDateTimeRange = new ImmutablePair<>(searchDocumentTypesRequest.getStartCreatedDateTime(), searchDocumentTypesRequest.getEndCreatedDateTime());
        final ImmutablePair<String, String> lastModifiedDateTimeRange = new ImmutablePair<>(searchDocumentTypesRequest.getStartLastModifiedDateTime(), searchDocumentTypesRequest.getEndLastModifiedDateTime());
        return new SearchDocumentTypesParameters(id, country, description, createdDateTimeRange, lastModifiedDateTimeRange); 
    }
}
