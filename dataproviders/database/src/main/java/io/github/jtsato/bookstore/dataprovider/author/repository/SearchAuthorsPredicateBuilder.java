package io.github.jtsato.bookstore.dataprovider.author.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.author.domain.Gender;
import io.github.jtsato.bookstore.core.author.usecase.parameter.SearchAuthorsParameters;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
import io.github.jtsato.bookstore.dataprovider.author.domain.QAuthorEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchAuthorsPredicateBuilder extends AbstractPredicateBuilderImpl<QAuthorEntity, SearchAuthorsParameters> {

    public SearchAuthorsPredicateBuilder(final QAuthorEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchAuthorsParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (StringUtils.isNotBlank(query.getGender())) {
            final Gender gender = EnumeratorUtils.valueOf(query.getGender(), Gender.class);
            booleanExpressions.add(entityPath.gender.eq(gender.name()));
        }

        if (StringUtils.isNotBlank(query.getName())) {
            booleanExpressions.add(entityPath.name.like(addLikeOperator(query.getName())));
        }

        if (StringUtils.isNotBlank(query.getStartBirthdate())) {
            final LocalDate startBirthdate = LocalDate.parse(query.getStartBirthdate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.birthdate.goe(startBirthdate));
        }

        if (StringUtils.isNotBlank(query.getEndBirthdate())) {
            final LocalDate endBirthdate = LocalDate.parse(query.getEndBirthdate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.birthdate.loe(endBirthdate));
        }

        return booleanExpressions;
    }
}
