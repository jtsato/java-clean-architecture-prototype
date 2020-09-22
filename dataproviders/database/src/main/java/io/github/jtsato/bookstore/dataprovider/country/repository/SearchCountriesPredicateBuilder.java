package io.github.jtsato.bookstore.dataprovider.country.repository;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.country.usecase.parameter.SearchCountriesParameters;
import io.github.jtsato.bookstore.dataprovider.country.domain.QCountryEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchCountriesPredicateBuilder extends AbstractPredicateBuilderImpl<QCountryEntity, SearchCountriesParameters> {

    public SearchCountriesPredicateBuilder(final QCountryEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchCountriesParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (StringUtils.isNotBlank(query.getName())) {
            booleanExpressions.add(entityPath.name.like(addLikeOperator(query.getName())));
        }

        return booleanExpressions;
    }
}
