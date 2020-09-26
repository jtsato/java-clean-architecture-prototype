package io.github.jtsato.bookstore.dataprovider.bookdocument.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.SearchBookDocumentsParameters;
import io.github.jtsato.bookstore.dataprovider.book.repository.SearchBooksPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.QBookDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchBookDocumentsPredicateBuilder extends AbstractPredicateBuilderImpl<QBookDocumentEntity, SearchBookDocumentsParameters> {

    public SearchBookDocumentsPredicateBuilder(final QBookDocumentEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchBookDocumentsParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getXxKey() != null) {
            booleanExpressions.add(entityPath.xxKey.eq(query.getXxKey()));
        }

        if (query.getSearchBooksParameters() != null) {
            final SearchBooksPredicateBuilder searchBookPredicateBuilder = new SearchBooksPredicateBuilder(entityPath.book);
            booleanExpressions.addAll(searchBookPredicateBuilder.buildBooleanExpressions(query.getSearchBooksParameters()));
        }

        if (query.getStartSize() != null) {
            booleanExpressions.add(entityPath.size.goe(query.getStartSize()));
        }

        if (query.getEndSize() != null) {
            booleanExpressions.add(entityPath.size.loe(query.getEndSize()));
        }

        if (StringUtils.isNotBlank(query.getContentType())) {
            booleanExpressions.add(entityPath.contentType.like(addLikeOperator(query.getContentType())));
        }

        if (StringUtils.isNotBlank(query.getExtension())) {
            booleanExpressions.add(entityPath.extension.like(addLikeOperator(query.getExtension())));
        }

        if (StringUtils.isNotBlank(query.getName())) {
            booleanExpressions.add(entityPath.name.like(addLikeOperator(query.getName())));
        }

        if (StringUtils.isNotBlank(query.getContent())) {
            booleanExpressions.add(entityPath.content.like(addLikeOperator(query.getContent())));
        }

        if (StringUtils.isNotBlank(query.getStartCreationDate())) {
            final LocalDate startCreationDate = LocalDate.parse(query.getStartCreationDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.creationDate.goe(startCreationDate));
        }

        if (StringUtils.isNotBlank(query.getEndCreationDate())) {
            final LocalDate endCreationDate = LocalDate.parse(query.getEndCreationDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.creationDate.loe(endCreationDate));
        }

        if (StringUtils.isNotBlank(query.getStartLastModifiedDate())) {
            final LocalDate startLastModifiedDate = LocalDate.parse(query.getStartLastModifiedDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.lastModifiedDate.goe(startLastModifiedDate));
        }

        if (StringUtils.isNotBlank(query.getEndLastModifiedDate())) {
            final LocalDate endLastModifiedDate = LocalDate.parse(query.getEndLastModifiedDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.lastModifiedDate.loe(endLastModifiedDate));
        }

        return booleanExpressions;
    }
}
