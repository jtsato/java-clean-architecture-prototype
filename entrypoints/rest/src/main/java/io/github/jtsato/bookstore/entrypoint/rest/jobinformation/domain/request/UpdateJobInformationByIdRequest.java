package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateJobInformationByIdRequest implements Serializable {

    private static final long serialVersionUID = 7909287870038034707L;

    private Long id;
    private Long leadId;
    private Long attach;
    private String profession;
    private String referenceMonth;
    private String receiptType;
    private String startDate;
    private String createdDateTime;
    private String lastModifiedDateTime;
    private BigDecimal monthlyIncome;
}
