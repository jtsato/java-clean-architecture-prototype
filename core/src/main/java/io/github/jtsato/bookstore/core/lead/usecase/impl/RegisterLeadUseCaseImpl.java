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
import io.github.jtsato.bookstore.core.lead.gateway.RegisterLeadGateway;
import io.github.jtsato.bookstore.core.lead.usecase.RegisterLeadUseCase;
import io.github.jtsato.bookstore.core.lead.usecase.parameter.RegisterLeadParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
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
public class RegisterLeadUseCaseImpl implements RegisterLeadUseCase {

    private final RegisterLeadGateway registerLeadGateway;

    private final GetLeadByCpfIgnoreCaseGateway getLeadByCpfIgnoreCaseGateway;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public Lead execute(final RegisterLeadParameters parameters) {

        checkDuplicatedCpfViolation(parameters.getCpf());

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
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());

        final Lead lead = new Lead(null,
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
                                   createdDateTime,
                                   lastModifiedDateTime);

        return registerLeadGateway.execute(lead);
    }

    private void checkDuplicatedCpfViolation(final String cpf) {
        final Optional<Lead> optional = getLeadByCpfIgnoreCaseGateway.execute(cpf);
        optional.ifPresent(this::throwUniqueConstraintExceptionForCpf);
    }

    private void throwUniqueConstraintExceptionForCpf(final Lead lead) {
        throw new UniqueConstraintException("validation.lead.cpf.already.exists", lead.getCpf());
    }
}
