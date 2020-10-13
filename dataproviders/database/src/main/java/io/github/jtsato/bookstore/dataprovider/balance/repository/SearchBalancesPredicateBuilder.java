package io.github.jtsato.bookstore.dataprovider.balance.repository;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.balance.domain.Currency;
import io.github.jtsato.bookstore.core.balance.domain.ResourceOrigin;
import io.github.jtsato.bookstore.core.balance.usecase.parameter.SearchBalancesParameters;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
import io.github.jtsato.bookstore.dataprovider.balance.domain.QBalanceEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchBalancesPredicateBuilder extends AbstractPredicateBuilderImpl<QBalanceEntity, SearchBalancesParameters> {

    public SearchBalancesPredicateBuilder(final QBalanceEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchBalancesParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (StringUtils.isNotBlank(query.getCustomerNumber())) {
            booleanExpressions.add(entityPath.customerNumber.like(addLikeOperator(query.getCustomerNumber())));
        }

        if (StringUtils.isNotBlank(query.getCurrency())) {
            final Currency currency = EnumeratorUtils.valueOf(query.getCurrency(), Currency.class);
            booleanExpressions.add(entityPath.currency.eq(currency.name()));
        }

        if (StringUtils.isNotBlank(query.getResourceOrigin())) {
            final ResourceOrigin resourceOrigin = EnumeratorUtils.valueOf(query.getResourceOrigin(), ResourceOrigin.class);
            booleanExpressions.add(entityPath.resourceOrigin.eq(resourceOrigin.name()));
        }

        if (query.getStartDebitBalance() != null) {
            booleanExpressions.add(entityPath.debitBalance.goe(query.getStartDebitBalance()));
        }

        if (query.getEndDebitBalance() != null) {
            booleanExpressions.add(entityPath.debitBalance.loe(query.getEndDebitBalance()));
        }

        if (query.getStartContractedPrincipal() != null) {
            booleanExpressions.add(entityPath.contractedPrincipal.goe(query.getStartContractedPrincipal()));
        }

        if (query.getEndContractedPrincipal() != null) {
            booleanExpressions.add(entityPath.contractedPrincipal.loe(query.getEndContractedPrincipal()));
        }

        if (query.getStartContractedInterest() != null) {
            booleanExpressions.add(entityPath.contractedInterest.goe(query.getStartContractedInterest()));
        }

        if (query.getEndContractedInterest() != null) {
            booleanExpressions.add(entityPath.contractedInterest.loe(query.getEndContractedInterest()));
        }

        if (query.getStartContractedTotal() != null) {
            booleanExpressions.add(entityPath.contractedTotal.goe(query.getStartContractedTotal()));
        }

        if (query.getEndContractedTotal() != null) {
            booleanExpressions.add(entityPath.contractedTotal.loe(query.getEndContractedTotal()));
        }

        if (query.getStartPaidPrincipal() != null) {
            booleanExpressions.add(entityPath.paidPrincipal.goe(query.getStartPaidPrincipal()));
        }

        if (query.getEndPaidPrincipal() != null) {
            booleanExpressions.add(entityPath.paidPrincipal.loe(query.getEndPaidPrincipal()));
        }

        if (query.getStartPaidInterest() != null) {
            booleanExpressions.add(entityPath.paidInterest.goe(query.getStartPaidInterest()));
        }

        if (query.getEndPaidInterest() != null) {
            booleanExpressions.add(entityPath.paidInterest.loe(query.getEndPaidInterest()));
        }

        if (query.getStartPaidTotal() != null) {
            booleanExpressions.add(entityPath.paidTotal.goe(query.getStartPaidTotal()));
        }

        if (query.getEndPaidTotal() != null) {
            booleanExpressions.add(entityPath.paidTotal.loe(query.getEndPaidTotal()));
        }

        return booleanExpressions;
    }
}
