package io.github.jtsato.bookstore.dataprovider.document.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.document.usecase.parameter.SearchDocumentsParameters;
import io.github.jtsato.bookstore.dataprovider.lead.repository.SearchLeadsPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.documenttype.repository.SearchDocumentTypesPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.document.domain.QDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchDocumentsPredicateBuilder extends AbstractPredicateBuilderImpl<QDocumentEntity, SearchDocumentsParameters> {

    public SearchDocumentsPredicateBuilder(final QDocumentEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchDocumentsParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (query.getSearchLeadsParameters() != null) {
            final SearchLeadsPredicateBuilder searchLeadPredicateBuilder = new SearchLeadsPredicateBuilder(entityPath.lead);
            booleanExpressions.addAll(searchLeadPredicateBuilder.buildBooleanExpressions(query.getSearchLeadsParameters()));
        }

        if (query.getSearchDocumentTypesParameters() != null) {
            final SearchDocumentTypesPredicateBuilder searchDocumentTypePredicateBuilder = new SearchDocumentTypesPredicateBuilder(entityPath.type);
            booleanExpressions.addAll(searchDocumentTypePredicateBuilder.buildBooleanExpressions(query.getSearchDocumentTypesParameters()));
        }

        if (query.getStartFrontPhoto() != null) {
            booleanExpressions.add(entityPath.frontPhoto.goe(query.getStartFrontPhoto()));
        }

        if (query.getEndFrontPhoto() != null) {
            booleanExpressions.add(entityPath.frontPhoto.loe(query.getEndFrontPhoto()));
        }

        if (query.getStartBackPhoto() != null) {
            booleanExpressions.add(entityPath.backPhoto.goe(query.getStartBackPhoto()));
        }

        if (query.getEndBackPhoto() != null) {
            booleanExpressions.add(entityPath.backPhoto.loe(query.getEndBackPhoto()));
        }

        if (StringUtils.isNotBlank(query.getNumber())) {
            booleanExpressions.add(entityPath.number.like(addLikeOperator(query.getNumber())));
        }

        if (StringUtils.isNotBlank(query.getIssuer())) {
            booleanExpressions.add(entityPath.issuer.like(addLikeOperator(query.getIssuer())));
        }

        if (StringUtils.isNotBlank(query.getState())) {
            booleanExpressions.add(entityPath.state.like(addLikeOperator(query.getState())));
        }

        if (StringUtils.isNotBlank(query.getStartIssueDate())) {
            final LocalDate startIssueDate = LocalDate.parse(query.getStartIssueDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.issueDate.goe(startIssueDate));
        }

        if (StringUtils.isNotBlank(query.getEndIssueDate())) {
            final LocalDate endIssueDate = LocalDate.parse(query.getEndIssueDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.issueDate.loe(endIssueDate));
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
