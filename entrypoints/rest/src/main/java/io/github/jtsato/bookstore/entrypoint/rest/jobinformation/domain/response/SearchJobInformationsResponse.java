package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class SearchJobInformationsResponse implements Serializable {

    private static final long serialVersionUID = 1763034091549642674L;

    private final Long id;
    private final SearchJobInformationsLeadResponse lead;
    private final Long attach;
    private final String profession;
    private final String referenceMonth;
    private final String receiptType;
    private final LocalDate startDate;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
    private final BigDecimal monthlyIncome;
}
