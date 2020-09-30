package io.github.jtsato.bookstore.dataprovider.address.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.address.domain.PropertyType;
import io.github.jtsato.bookstore.core.address.usecase.parameter.SearchAddressesParameters;
import io.github.jtsato.bookstore.dataprovider.lead.repository.SearchLeadsPredicateBuilder;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
import io.github.jtsato.bookstore.dataprovider.address.domain.QAddressEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchAddressesPredicateBuilder extends AbstractPredicateBuilderImpl<QAddressEntity, SearchAddressesParameters> {

    public SearchAddressesPredicateBuilder(final QAddressEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchAddressesParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (query.getSearchLeadsParameters() != null) {
            final SearchLeadsPredicateBuilder searchLeadPredicateBuilder = new SearchLeadsPredicateBuilder(entityPath.lead);
            booleanExpressions.addAll(searchLeadPredicateBuilder.buildBooleanExpressions(query.getSearchLeadsParameters()));
        }

        if (StringUtils.isNotBlank(query.getZipCode())) {
            booleanExpressions.add(entityPath.zipCode.like(addLikeOperator(query.getZipCode())));
        }

        if (StringUtils.isNotBlank(query.getCity())) {
            booleanExpressions.add(entityPath.city.like(addLikeOperator(query.getCity())));
        }

        if (StringUtils.isNotBlank(query.getState())) {
            booleanExpressions.add(entityPath.state.like(addLikeOperator(query.getState())));
        }

        if (StringUtils.isNotBlank(query.getCountry())) {
            booleanExpressions.add(entityPath.country.like(addLikeOperator(query.getCountry())));
        }

        if (StringUtils.isNotBlank(query.getDescription())) {
            booleanExpressions.add(entityPath.description.like(addLikeOperator(query.getDescription())));
        }

        if (StringUtils.isNotBlank(query.getComplement())) {
            booleanExpressions.add(entityPath.complement.like(addLikeOperator(query.getComplement())));
        }

        if (StringUtils.isNotBlank(query.getNumber())) {
            booleanExpressions.add(entityPath.number.like(addLikeOperator(query.getNumber())));
        }

        if (StringUtils.isNotBlank(query.getNumber())) {
            final PropertyType type = EnumeratorUtils.valueOf(query.getNumber(), PropertyType.class);
            booleanExpressions.add(entityPath.type.eq(type.name()));
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
