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
import io.github.jtsato.bookstore.core.jobinformation.gateway.RegisterJobInformationGateway;
import io.github.jtsato.bookstore.core.jobinformation.usecase.RegisterJobInformationUseCase;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.RegisterJobInformationParameters;
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
public class RegisterJobInformationUseCaseImpl implements RegisterJobInformationUseCase {

    private final RegisterJobInformationGateway registerJobInformationGateway;

    private final GetLeadByIdGateway getLeadByIdGateway ;

    private final GetLocalDateTime getLocalDateTime;

    @Override
    public JobInformation execute(final RegisterJobInformationParameters parameters) {

        final Lead lead = getLeadAndValidate(parameters.getLeadId());

        final Long attach = parameters.getAttach();
        final String profession = StringUtils.stripToEmpty(parameters.getProfession());
        final String referenceMonth = StringUtils.stripToEmpty(parameters.getReferenceMonth());
        final ReceiptType receiptType = EnumeratorUtils.valueOf(parameters.getReceiptType(), ReceiptType.class);
        final LocalDate startDate = LocalDate.parse(parameters.getStartDate());
        final LocalDateTime createdDateTime = getLocalDateTime.now();
        final LocalDateTime lastModifiedDateTime = LocalDateTime.parse(parameters.getLastModifiedDateTime());
        final BigDecimal monthlyIncome = parameters.getMonthlyIncome();

        final JobInformation jobInformation = new JobInformation(null,
                                                                 lead,
                                                                 attach,
                                                                 profession,
                                                                 referenceMonth,
                                                                 receiptType,
                                                                 startDate,
                                                                 createdDateTime,
                                                                 lastModifiedDateTime,
                                                                 monthlyIncome);

        return registerJobInformationGateway.execute(jobInformation);
    }

    private Lead getLeadAndValidate(final Long leadId) {
        final Optional<Lead> optional = getLeadByIdGateway.execute(leadId);
        return optional.orElseThrow(() -> new NotFoundException("validation.lead.id.notfound", String.valueOf(leadId)));
    }
}
