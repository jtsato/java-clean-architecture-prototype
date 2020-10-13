package io.github.jtsato.bookstore.dataprovider.jobinformation.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.jobinformation.domain.ReceiptType;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.SearchJobInformationsParameters;
import io.github.jtsato.bookstore.dataprovider.lead.repository.SearchLeadsPredicateBuilder;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
import io.github.jtsato.bookstore.dataprovider.jobinformation.domain.QJobInformationEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchJobInformationsPredicateBuilder extends AbstractPredicateBuilderImpl<QJobInformationEntity, SearchJobInformationsParameters> {

    public SearchJobInformationsPredicateBuilder(final QJobInformationEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchJobInformationsParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (query.getSearchLeadsParameters() != null) {
            final SearchLeadsPredicateBuilder searchLeadPredicateBuilder = new SearchLeadsPredicateBuilder(entityPath.lead);
            booleanExpressions.addAll(searchLeadPredicateBuilder.buildBooleanExpressions(query.getSearchLeadsParameters()));
        }

        if (query.getStartAttach() != null) {
            booleanExpressions.add(entityPath.attach.goe(query.getStartAttach()));
        }

        if (query.getEndAttach() != null) {
            booleanExpressions.add(entityPath.attach.loe(query.getEndAttach()));
        }

        if (StringUtils.isNotBlank(query.getProfession())) {
            booleanExpressions.add(entityPath.profession.like(addLikeOperator(query.getProfession())));
        }

        if (StringUtils.isNotBlank(query.getReferenceMonth())) {
            booleanExpressions.add(entityPath.referenceMonth.like(addLikeOperator(query.getReferenceMonth())));
        }

        if (StringUtils.isNotBlank(query.getReceiptType())) {
            final ReceiptType receiptType = EnumeratorUtils.valueOf(query.getReceiptType(), ReceiptType.class);
            booleanExpressions.add(entityPath.receiptType.eq(receiptType.name()));
        }

        if (StringUtils.isNotBlank(query.getStartStartDate())) {
            final LocalDate startStartDate = LocalDate.parse(query.getStartStartDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.startDate.goe(startStartDate));
        }

        if (StringUtils.isNotBlank(query.getEndStartDate())) {
            final LocalDate endStartDate = LocalDate.parse(query.getEndStartDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.startDate.loe(endStartDate));
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

        if (query.getStartMonthlyIncome() != null) {
            booleanExpressions.add(entityPath.monthlyIncome.goe(query.getStartMonthlyIncome()));
        }

        if (query.getEndMonthlyIncome() != null) {
            booleanExpressions.add(entityPath.monthlyIncome.loe(query.getEndMonthlyIncome()));
        }

        return booleanExpressions;
    }
}
