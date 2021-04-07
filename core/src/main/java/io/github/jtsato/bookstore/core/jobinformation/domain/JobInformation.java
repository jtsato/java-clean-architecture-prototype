package io.github.jtsato.bookstore.core.jobinformation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class JobInformation implements Serializable {

    private static final long serialVersionUID = -4363656768757480188L;

    private final Long id;
    private final Lead lead;
    private final Long attach;
    private final String profession;
    private final String referenceMonth;
    private final ReceiptType receiptType;
    private final LocalDate startDate;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
    private final BigDecimal monthlyIncome;
}
