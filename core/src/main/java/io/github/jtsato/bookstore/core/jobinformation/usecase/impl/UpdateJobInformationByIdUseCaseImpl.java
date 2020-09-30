package io.github.jtsato.bookstore.core.jobinformation.usecase.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.jobinformation.domain.ReceiptType;
import io.github.jtsato.bookstore.core.lead.gateway.GetLeadByIdGateway;
import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.gateway.UpdateJobInformationByIdGateway;
import io.github.jtsato.bookstore.core.jobinformation.usecase.UpdateJobInformationByIdUseCase;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.UpdateJobInformationByIdParameters;
import io.github.jtsato.bookstore.core.common.GetLocalDateTime;
import io.github.jtsato.bookstore.core.common.EnumeratorUtils;
import io.github.jtsato.bookstore.core.exception.NotFoundException;
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
public class UpdateJobInformationByIdUseCaseImpl implements UpdateJobInformationByIdUseCase {

    private final UpdateJobInformationByIdGateway updateJobInformationByIdGateway;

    private final GetLeadByIdGateway getLeadByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public JobInformation execute(final UpdateJobInformationByIdParameters parameters) {
        final Lead lead = getLeadAndValidate(parameters.getLeadId());

        final Long id = parameters.getId();
        final Long attach = parameters.getAttach();
        final String profession = StringUtils.stripToEmpty(parameters.getProfession());
        final String referenceMonth = StringUtils.stripToEmpty(parameters.getReferenceMonth());
        final ReceiptType receiptType = EnumeratorUtils.valueOf(parameters.getReceiptType(), ReceiptType.class);
        final LocalDate startDate = LocalDate.parse(parameters.getStartDate());
        final LocalDateTime lastModifiedDateTime = getLocalDateTime.now();
        final BigDecimal monthlyIncome = parameters.getMonthlyIncome();

        final JobInformation jobInformation = new JobInformation(id ,
                                                                 lead,
                                                                 attach,
                                                                 profession,
                                                                 referenceMonth,
                                                                 receiptType,
                                                                 startDate,
                                                                 null,
                                                                 lastModifiedDateTime,
                                                                 monthlyIncome);

        final Optional<JobInformation> optional = updateJobInformationByIdGateway.execute(jobInformation);
        return optional.orElseThrow(() -> new NotFoundException("validation.job.information.id.notfound", String.valueOf(parameters.getId())));
    }

    private Lead getLeadAndValidate(final Long leadId) {
        final Optional<Lead> optional = getLeadByIdGateway.execute(leadId);
        return optional.orElseThrow(() -> new NotFoundException("validation.lead.id.notfound", String.valueOf(leadId)));
    }
}
