package io.github.jtsato.bookstore.core.jobinformation.usecase.parameter;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.github.jtsato.bookstore.core.common.validation.LocalDateConstraint;
import io.github.jtsato.bookstore.core.common.validation.SelfValidating;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class UpdateJobInformationByIdParameters extends SelfValidating<UpdateJobInformationByIdParameters> implements Serializable {

    private static final long serialVersionUID = 1447434486719923550L;

    @NotNull(message = "validation.job.information.id.null")
    private Long id;

    @NotNull(message = "validation.lead.id.null")
    private final Long leadId;

    @NotNull(message = "validation.job.information.attach.null")
    private final Long attach;

    @NotBlank(message = "validation.job.information.profession.blank")
    private final String profession;

    @NotBlank(message = "validation.job.information.reference.month.blank")
    private final String referenceMonth;

    @NotBlank(message = "validation.job.information.receipt.type.blank")
    private final String receiptType;

    @NotBlank(message = "validation.job.information.start.date.blank")
    @LocalDateConstraint(message = "validation.job.information.start.date.invalid")
    private final String startDate;

    @NotNull(message = "validation.job.information.monthly.income.null")
    @PositiveOrZero(message = "validation.job.information.monthly.income.negative")
    private final BigDecimal monthlyIncome; 

    public UpdateJobInformationByIdParameters(final Long id,
                                              final Long leadId,
                                              final Long attach,
                                              final String profession,
                                              final String referenceMonth,
                                              final String receiptType,
                                              final String startDate,
                                              final BigDecimal monthlyIncome) {
        this.id = id;
        this.leadId = leadId;
        this.attach = attach;
        this.profession = profession;
        this.referenceMonth = referenceMonth;
        this.receiptType = receiptType;
        this.startDate = startDate;
        this.monthlyIncome = monthlyIncome;
        this.validateSelf();
    }
}
