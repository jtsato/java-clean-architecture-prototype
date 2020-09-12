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

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
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

        if (query.getStartPrice() != null) {
            booleanExpressions.add(entityPath.price.goe(query.getStartPrice()));
        }

        if (query.getEndPrice() != null) {
            booleanExpressions.add(entityPath.price.loe(query.getEndPrice()));
        }

        if (StringUtils.isNotBlank(query.getStartCreatedDate())) {
            final LocalDateTime startCreatedDate = LocalDateTime.parse(query.getStartCreatedDate(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.createdDate.goe(startCreatedDate));
        }

        if (StringUtils.isNotBlank(query.getEndCreatedDate())) {
            final LocalDateTime endCreatedDate = LocalDateTime.parse(query.getEndCreatedDate(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.createdDate.loe(endCreatedDate));
        }

        if (StringUtils.isNotBlank(query.getStartLastModifiedDate())) {
            final LocalDateTime startLastModifiedDate = LocalDateTime.parse(query.getStartLastModifiedDate(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.lastModifiedDate.goe(startLastModifiedDate));
        }

        if (StringUtils.isNotBlank(query.getEndLastModifiedDate())) {
            final LocalDateTime endLastModifiedDate = LocalDateTime.parse(query.getEndLastModifiedDate(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.lastModifiedDate.loe(endLastModifiedDate));
        }

        return booleanExpressions;
    }
}
