package io.github.jtsato.bookstore.dataprovider.customer.repository;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.customer.usecase.parameter.SearchCustomersParameters;
import io.github.jtsato.bookstore.dataprovider.customer.domain.QCustomerEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchCustomersPredicateBuilder extends AbstractPredicateBuilderImpl<QCustomerEntity, SearchCustomersParameters> {

    public SearchCustomersPredicateBuilder(final QCustomerEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchCustomersParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (StringUtils.isNotBlank(query.getName())) {
            booleanExpressions.add(entityPath.name.like(addLikeOperator(query.getName())));
        }

        if (StringUtils.isNotBlank(query.getAddress())) {
            booleanExpressions.add(entityPath.address.like(addLikeOperator(query.getAddress())));
        }

        return booleanExpressions;
    }
}
