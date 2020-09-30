package io.github.jtsato.bookstore.entrypoint.rest.document.controller;

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

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.usecase.parameter.SearchDocumentsParameters;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.SearchDocumentTypesParameters;
import io.github.jtsato.bookstore.core.document.usecase.SearchDocumentsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.document.api.SearchDocumentsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.request.SearchDocumentsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.request.SearchDocumentsLeadRequest;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.request.SearchDocumentsTypeRequest;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.SearchDocumentsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.mapper.SearchDocumentsPresenter;
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
public class SearchDocumentsController implements SearchDocumentsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchDocumentsController.class);

    private final SearchDocumentsUseCase searchDocumentsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchDocumentsWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchDocumentsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchDocumentsController with {}", jsonRequest);

        final SearchDocumentsParameters parameters = buildSearchDocumentsParameters(request);
        final Page<Document> documents = searchDocumentsUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchDocumentsPresenter.of(documents);
    }

    private SearchDocumentsParameters buildSearchDocumentsParameters(final SearchDocumentsRequest searchDocumentsRequest) {

        final Long id = searchDocumentsRequest.getId();
        final SearchLeadsParameters searchLeadsParameters = buildSearchLeadsParameters(searchDocumentsRequest.getLead());
        final SearchDocumentTypesParameters searchDocumentTypesParameters = buildSearchDocumentTypesParameters(searchDocumentsRequest.getType());
        final ImmutablePair<Long, Long> frontPhotoRange = new ImmutablePair<>(searchDocumentsRequest.getStartFrontPhoto(), searchDocumentsRequest.getEndFrontPhoto());
        final ImmutablePair<Long, Long> backPhotoRange = new ImmutablePair<>(searchDocumentsRequest.getStartBackPhoto(), searchDocumentsRequest.getEndBackPhoto());
        final String number = searchDocumentsRequest.getNumber();
        final String issuer = searchDocumentsRequest.getIssuer();
        final String state = searchDocumentsRequest.getState();
        final ImmutablePair<String, String> issueDateRange = new ImmutablePair<>(searchDocumentsRequest.getStartIssueDate(), searchDocumentsRequest.getEndIssueDate());
        final ImmutablePair<String, String> createdDateTimeRange = new ImmutablePair<>(searchDocumentsRequest.getStartCreatedDateTime(), searchDocumentsRequest.getEndCreatedDateTime());
        final ImmutablePair<String, String> lastModifiedDateTimeRange = new ImmutablePair<>(searchDocumentsRequest.getStartLastModifiedDateTime(), searchDocumentsRequest.getEndLastModifiedDateTime());
        return new SearchDocumentsParameters(id, searchLeadsParameters, searchDocumentTypesParameters, frontPhotoRange, backPhotoRange, number, issuer, state, issueDateRange, createdDateTimeRange, lastModifiedDateTimeRange); 
    }

    private SearchLeadsParameters buildSearchLeadsParameters(final SearchDocumentsLeadRequest searchLeadsRequest) {

        final Long id = searchLeadsRequest.getId();
        final ImmutablePair<Long, Long> selfiePhotoRange = new ImmutablePair<>(searchLeadsRequest.getStartSelfiePhoto(), searchLeadsRequest.getEndSelfiePhoto());
        final String cpf = searchLeadsRequest.getCpf();
        final String cellphone = searchLeadsRequest.getCellphone();
        final String name = searchLeadsRequest.getName();
        final String motherFullName = searchLeadsRequest.getMotherFullName();
        final String gender = searchLeadsRequest.getGender();
        final String education = searchLeadsRequest.getEducation();
        final String maritalStatus = searchLeadsRequest.getMaritalStatus();
        final Boolean stableUnion = searchLeadsRequest.getStableUnion();
        final ImmutablePair<String, String> birthdateRange = new ImmutablePair<>(searchLeadsRequest.getStartBirthdate(), searchLeadsRequest.getEndBirthdate());
        final ImmutablePair<String, String> createdDateTimeRange = new ImmutablePair<>(searchLeadsRequest.getStartCreatedDateTime(), searchLeadsRequest.getEndCreatedDateTime());
        final ImmutablePair<String, String> lastModifiedDateTimeRange = new ImmutablePair<>(searchLeadsRequest.getStartLastModifiedDateTime(), searchLeadsRequest.getEndLastModifiedDateTime());
        return new SearchLeadsParameters(id, selfiePhotoRange, cpf, cellphone, name, motherFullName, gender, education, maritalStatus, stableUnion, birthdateRange, createdDateTimeRange, lastModifiedDateTimeRange); 
    }

    private SearchDocumentTypesParameters buildSearchDocumentTypesParameters(final SearchDocumentsTypeRequest searchDocumentTypesRequest) {

        final Long id = searchDocumentTypesRequest.getId();
        final String country = searchDocumentTypesRequest.getCountry();
        final String description = searchDocumentTypesRequest.getDescription();
        final ImmutablePair<String, String> createdDateTimeRange = new ImmutablePair<>(searchDocumentTypesRequest.getStartCreatedDateTime(), searchDocumentTypesRequest.getEndCreatedDateTime());
        final ImmutablePair<String, String> lastModifiedDateTimeRange = new ImmutablePair<>(searchDocumentTypesRequest.getStartLastModifiedDateTime(), searchDocumentTypesRequest.getEndLastModifiedDateTime());
        return new SearchDocumentTypesParameters(id, country, description, createdDateTimeRange, lastModifiedDateTimeRange); 
    }
}
