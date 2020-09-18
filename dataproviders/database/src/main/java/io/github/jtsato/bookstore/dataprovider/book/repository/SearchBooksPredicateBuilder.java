package io.github.jtsato.bookstore.dataprovider.book.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.book.usecase.parameter.SearchBooksParameters;
import io.github.jtsato.bookstore.dataprovider.author.repository.SearchAuthorsPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.book.domain.QBookEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchBooksPredicateBuilder extends AbstractPredicateBuilderImpl<QBookEntity, SearchBooksParameters> {

    public SearchBooksPredicateBuilder(final QBookEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchBooksParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getBKey() != null) {
            booleanExpressions.add(entityPath.bKey.eq(query.getBKey()));
        }

        if (query.getSearchAuthorsParameters() != null) {
            final SearchAuthorsPredicateBuilder searchAuthorPredicateBuilder = new SearchAuthorsPredicateBuilder(entityPath.author);
            booleanExpressions.addAll(searchAuthorPredicateBuilder.buildBooleanExpressions(query.getSearchAuthorsParameters()));
        }

        if (StringUtils.isNotBlank(query.getTitle())) {
            booleanExpressions.add(entityPath.title.like(addLikeOperator(query.getTitle())));
        }

        if (query.getAvailable() != null) {
            booleanExpressions.add(entityPath.available.eq(query.getAvailable()));
        }

        if (StringUtils.isNotBlank(query.getStartCreatedDateTime())) {
            final LocalDateTime startCreatedDateTime = LocalDateTime.parse(query.getStartCreatedDateTime(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.createdDateTime.goe(startCreatedDateTime));
        }

        if (StringUtils.isNotBlank(query.getEndCreatedDateTime())) {
            final LocalDateTime endCreatedDateTime = LocalDateTime.parse(query.getEndCreatedDateTime(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.createdDateTime.loe(endCreatedDateTime));
        }

        if (StringUtils.isNotBlank(query.getStartLastModifiedDateTime())) {
            final LocalDateTime startLastModifiedDateTime = LocalDateTime.parse(query.getStartLastModifiedDateTime(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.lastModifiedDateTime.goe(startLastModifiedDateTime));
        }

        if (StringUtils.isNotBlank(query.getEndLastModifiedDateTime())) {
            final LocalDateTime endLastModifiedDateTime = LocalDateTime.parse(query.getEndLastModifiedDateTime(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.lastModifiedDateTime.loe(endLastModifiedDateTime));
        }

        if (query.getStartPrice() != null) {
            booleanExpressions.add(entityPath.price.goe(query.getStartPrice()));
        }

        if (query.getEndPrice() != null) {
            booleanExpressions.add(entityPath.price.loe(query.getEndPrice()));
        }

        return booleanExpressions;
    }
}
