package io.github.jtsato.bookstore.entrypoint.rest.book.domain.request;

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
public final class SearchBooksRequest implements Serializable {

    private static final long serialVersionUID = -5322552365939474408L;

    private Long id;
    private SearchBooksAuthorRequest searchBooksAuthorRequest;
    private String title;
    private Boolean available;
    private String startCreatedDateTime;
    private String endCreatedDateTime;
    private String startLastModifiedDateTime;
    private String endLastModifiedDateTime;
    private BigDecimal startPrice;
    private BigDecimal endPrice;
}
