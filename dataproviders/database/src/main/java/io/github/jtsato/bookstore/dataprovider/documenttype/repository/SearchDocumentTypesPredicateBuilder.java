package io.github.jtsato.bookstore.dataprovider.documenttype.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.SearchDocumentTypesParameters;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.QDocumentTypeEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchDocumentTypesPredicateBuilder extends AbstractPredicateBuilderImpl<QDocumentTypeEntity, SearchDocumentTypesParameters> {

    public SearchDocumentTypesPredicateBuilder(final QDocumentTypeEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchDocumentTypesParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (StringUtils.isNotBlank(query.getCountry())) {
            booleanExpressions.add(entityPath.country.like(addLikeOperator(query.getCountry())));
        }

        if (StringUtils.isNotBlank(query.getDescription())) {
            booleanExpressions.add(entityPath.description.like(addLikeOperator(query.getDescription())));
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

        return booleanExpressions;
    }
}
