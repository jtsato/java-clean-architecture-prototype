package io.github.jtsato.bookstore.core.lead.usecase.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.lead.domain.Gender;
import io.github.jtsato.bookstore.core.lead.domain.Education;
import io.github.jtsato.bookstore.core.lead.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.lead.gateway.GetLeadByCpfIgnoreCaseGateway;
import io.github.jtsato.bookstore.core.lead.gateway.UpdateLeadByIdGateway;
import io.github.jtsato.bookstore.core.lead.usecase.UpdateLeadByIdUseCase;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.UpdateLeadByIdParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
import io.github.jtsato.bookstore.core.exception.UniqueConstraintException;
import lombok.RequiredArgsConstructor;

/*
 * A Use Case follows these steps:
 * - Takes input
 * - Validates business rules
 * - Manipulates the model state
 * - Returns output
 */

/**
 * @author Jorge Takeshi Sato
 */

@Named
@RequiredArgsConstructor
public class UpdateLeadByIdUseCaseImpl implements UpdateLeadByIdUseCase {

    private final UpdateLeadByIdGateway updateLeadByIdGateway;

    private final GetLeadByCpfIgnoreCaseGateway getLeadByCpfIgnoreCaseGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Lead execute(final UpdateLeadByIdParameters parameters) {

        checkDuplicatedCpfViolation(parameters.getId(), parameters.getCpf());

        final Long id = parameters.getId();
        final Long selfiePhoto = parameters.getSelfiePhoto();
        final String cpf = StringUtils.stripToEmpty(parameters.getCpf());
        final String cellphone = StringUtils.stripToEmpty(parameters.getCellphone());
        final String name = StringUtils.stripToEmpty(parameters.getName());
        final String motherFullName = StringUtils.stripToEmpty(parameters.getMotherFullName());
        final Gender gender = EnumeratorUtils.valueOf(parameters.getGender(), Gender.class);
        final Education education = EnumeratorUtils.valueOf(parameters.getEducation(), Education.class);
        final MaritalStatus maritalStatus = EnumeratorUtils.valueOf(parameters.getMaritalStatus(), MaritalStatus.class);
        final Boolean stableUnion = parameters.getStableUnion();
        final LocalDate birthdate = LocalDate.parse(parameters.getBirthdate());
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();

        final Lead lead = new Lead(id ,
                                   selfiePhoto,
                                   cpf,
                                   cellphone,
                                   name,
                                   motherFullName,
                                   gender,
                                   education,
                                   maritalStatus,
                                   stableUnion,
                                   birthdate,
                                   null,
                                   lastModifiedDateTime);

        final Optional<Lead> optional = updateLeadByIdGateway.execute(lead);
        return optional.orElseThrow(() -> new NotFoundException("validation.lead.id.notfound", String.valueOf(parameters.getId())));
    }

    private void checkDuplicatedCpfViolation(final Long id, final String cpf) {

        final Optional<Lead> optional = getLeadByCpfIgnoreCaseGateway.execute(cpf);

        if (optional.isEmpty()) {
            return;
        }

        final Lead lead = optional.get();
        if (!lead.getId().equals(id)) {
            throw new UniqueConstraintException("validation.lead.cpf.already.exists", lead.getCpf());
        }
    }
}
