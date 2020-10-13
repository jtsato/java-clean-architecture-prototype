package io.github.jtsato.bookstore.dataprovider.lead.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.lead.domain.Gender;
import io.github.jtsato.bookstore.core.lead.domain.Education;
import io.github.jtsato.bookstore.core.lead.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.SearchLeadsParameters;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
import io.github.jtsato.bookstore.dataprovider.lead.domain.QLeadEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchLeadsPredicateBuilder extends AbstractPredicateBuilderImpl<QLeadEntity, SearchLeadsParameters> {

    public SearchLeadsPredicateBuilder(final QLeadEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchLeadsParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (query.getStartSelfiePhoto() != null) {
            booleanExpressions.add(entityPath.selfiePhoto.goe(query.getStartSelfiePhoto()));
        }

        if (query.getEndSelfiePhoto() != null) {
            booleanExpressions.add(entityPath.selfiePhoto.loe(query.getEndSelfiePhoto()));
        }

        if (StringUtils.isNotBlank(query.getCpf())) {
            booleanExpressions.add(entityPath.cpf.like(addLikeOperator(query.getCpf())));
        }

        if (StringUtils.isNotBlank(query.getCellphone())) {
            booleanExpressions.add(entityPath.cellphone.like(addLikeOperator(query.getCellphone())));
        }

        if (StringUtils.isNotBlank(query.getName())) {
            booleanExpressions.add(entityPath.name.like(addLikeOperator(query.getName())));
        }

        if (StringUtils.isNotBlank(query.getMotherFullName())) {
            booleanExpressions.add(entityPath.motherFullName.like(addLikeOperator(query.getMotherFullName())));
        }

        if (StringUtils.isNotBlank(query.getGender())) {
            final Gender gender = EnumeratorUtils.valueOf(query.getGender(), Gender.class);
            booleanExpressions.add(entityPath.gender.eq(gender.name()));
        }

        if (StringUtils.isNotBlank(query.getEducation())) {
            final Education education = EnumeratorUtils.valueOf(query.getEducation(), Education.class);
            booleanExpressions.add(entityPath.education.eq(education.name()));
        }

        if (StringUtils.isNotBlank(query.getMaritalStatus())) {
            final MaritalStatus maritalStatus = EnumeratorUtils.valueOf(query.getMaritalStatus(), MaritalStatus.class);
            booleanExpressions.add(entityPath.maritalStatus.eq(maritalStatus.name()));
        }

        if (query.getStableUnion() != null) {
            booleanExpressions.add(entityPath.stableUnion.eq(query.getStableUnion()));
        }

        if (StringUtils.isNotBlank(query.getStartBirthdate())) {
            final LocalDate startBirthdate = LocalDate.parse(query.getStartBirthdate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.birthdate.goe(startBirthdate));
        }

        if (StringUtils.isNotBlank(query.getEndBirthdate())) {
            final LocalDate endBirthdate = LocalDate.parse(query.getEndBirthdate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.birthdate.loe(endBirthdate));
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
