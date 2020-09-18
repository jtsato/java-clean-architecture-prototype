package io.github.jtsato.bookstore.dataprovider.bookdocument.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.bookdocument.usecase.parameter.SearchBookDocumentsParameters;
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

        if (query.getXxx() != null) {
            booleanExpressions.add(entityPath.xxx.eq(query.getXxx()));
        }

        if (query.getStartBookId() != null) {
            booleanExpressions.add(entityPath.bookId.goe(query.getStartBookId()));
        }

        if (query.getEndBookId() != null) {
            booleanExpressions.add(entityPath.bookId.loe(query.getEndBookId()));
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
            final LocalDateTime startCreationDate = LocalDateTime.parse(query.getStartCreationDate(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.creationDate.goe(startCreationDate));
        }

        if (StringUtils.isNotBlank(query.getEndCreationDate())) {
            final LocalDateTime endCreationDate = LocalDateTime.parse(query.getEndCreationDate(), DateTimeFormatter.ISO_DATE_TIME);
            booleanExpressions.add(entityPath.creationDate.loe(endCreationDate));
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
