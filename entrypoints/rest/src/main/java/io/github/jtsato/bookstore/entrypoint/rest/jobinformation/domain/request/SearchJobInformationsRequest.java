package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class SearchJobInformationsRequest implements Serializable {

    private static final long serialVersionUID = -2952622186005377657L;

    private Long id;
    private SearchJobInformationsLeadRequest lead;
    private Long startAttach;
    private Long endAttach;
    private String profession;
    private String referenceMonth;
    private String receiptType;
    private String startStartDate;
    private String endStartDate;
    private String startCreatedDateTime;
    private String endCreatedDateTime;
    private String startLastModifiedDateTime;
    private String endLastModifiedDateTime;
    private BigDecimal startMonthlyIncome;
    private BigDecimal endMonthlyIncome;
}
