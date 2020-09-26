package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.controller;

import java.math.BigDecimal;

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

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.SearchBookDocumentsParameters;
import io.github.jtsato.bookstore.core.book.usecase.parameter.SearchBooksParameters;
import io.github.jtsato.bookstore.core.author.usecase.parameter.SearchAuthorsParameters;
import io.github.jtsato.bookstore.core.bookdocument.usecase.SearchBookDocumentsUseCase;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.api.SearchBookDocumentsApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request.SearchBookDocumentsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request.SearchBookDocumentsBookRequest;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request.SearchBookDocumentsBookAuthorRequest;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.SearchBookDocumentsWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper.SearchBookDocumentsPresenter;
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
public class SearchBookDocumentsController implements SearchBookDocumentsApiMethod {

    private static final Logger log = LoggerFactory.getLogger(SearchBookDocumentsController.class);

    private final SearchBookDocumentsUseCase searchBookDocumentsUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public SearchBookDocumentsWrapperResponse execute(final Pageable pageable, @DefaultValue final SearchBookDocumentsRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> SearchBookDocumentsController with {}", jsonRequest);

        final SearchBookDocumentsParameters parameters = buildSearchBookDocumentsParameters(request);
        final Page<BookDocument> bookDocuments = searchBookDocumentsUseCase.execute(parameters, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().toString());

        return SearchBookDocumentsPresenter.of(bookDocuments);
    }

    private SearchBookDocumentsParameters buildSearchBookDocumentsParameters(final SearchBookDocumentsRequest searchBookDocumentsRequest) {

        final Long xxKey = searchBookDocumentsRequest.getXxKey();
        final SearchBooksParameters searchBooksParameters = buildSearchBooksParameters(searchBookDocumentsRequest.getBook());
        final ImmutablePair<Long, Long> sizeRange = new ImmutablePair<>(searchBookDocumentsRequest.getStartSize(), searchBookDocumentsRequest.getEndSize());
        final String contentType = searchBookDocumentsRequest.getContentType();
        final String extension = searchBookDocumentsRequest.getExtension();
        final String name = searchBookDocumentsRequest.getName();
        final String content = searchBookDocumentsRequest.getContent();
        final ImmutablePair<String, String> creationDateRange = new ImmutablePair<>(searchBookDocumentsRequest.getStartCreationDate(), searchBookDocumentsRequest.getEndCreationDate());
        final ImmutablePair<String, String> lastModifiedDateRange = new ImmutablePair<>(searchBookDocumentsRequest.getStartLastModifiedDate(), searchBookDocumentsRequest.getEndLastModifiedDate());
        return new SearchBookDocumentsParameters(xxKey, searchBooksParameters, sizeRange, contentType, extension, name, content, creationDateRange, lastModifiedDateRange); 
    }

    private SearchBooksParameters buildSearchBooksParameters(final SearchBookDocumentsBookRequest searchBooksRequest) {

        final Long id = searchBooksRequest.getId();
        final SearchAuthorsParameters searchAuthorsParameters = buildSearchAuthorsParameters(searchBooksRequest.getAuthor());
        final ImmutablePair<Long, Long> externalIdRange = new ImmutablePair<>(searchBooksRequest.getStartExternalId(), searchBooksRequest.getEndExternalId());
        final String title = searchBooksRequest.getTitle();
        final String isbn = searchBooksRequest.getIsbn();
        final Boolean available = searchBooksRequest.getAvailable();
        final ImmutablePair<String, String> createdDateTimeRange = new ImmutablePair<>(searchBooksRequest.getStartCreatedDateTime(), searchBooksRequest.getEndCreatedDateTime());
        final ImmutablePair<String, String> lastModifiedDateTimeRange = new ImmutablePair<>(searchBooksRequest.getStartLastModifiedDateTime(), searchBooksRequest.getEndLastModifiedDateTime());
        final ImmutablePair<BigDecimal, BigDecimal> priceRange = new ImmutablePair<>(searchBooksRequest.getStartPrice(), searchBooksRequest.getEndPrice());
        return new SearchBooksParameters(id, searchAuthorsParameters, externalIdRange, title, isbn, available, createdDateTimeRange, lastModifiedDateTimeRange, priceRange); 
    }

    private SearchAuthorsParameters buildSearchAuthorsParameters(final SearchBookDocumentsBookAuthorRequest searchAuthorsRequest) {

        final Long id = searchAuthorsRequest.getId();
        final String name = searchAuthorsRequest.getName();
        final String gender = searchAuthorsRequest.getGender();
        final ImmutablePair<String, String> birthdateRange = new ImmutablePair<>(searchAuthorsRequest.getStartBirthdate(), searchAuthorsRequest.getEndBirthdate());
        return new SearchAuthorsParameters(id, name, gender, birthdateRange); 
    }
}
