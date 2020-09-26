package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request;

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
public final class SearchBookDocumentsBookRequest implements Serializable {

    private static final long serialVersionUID = -7544256010303484878L;

    private Long id;
    private SearchBookDocumentsBookAuthorRequest author;
    private Long startExternalId;
    private Long endExternalId;
    private String title;
    private String isbn;
    private Boolean available;
    private String startCreatedDateTime;
    private String endCreatedDateTime;
    private String startLastModifiedDateTime;
    private String endLastModifiedDateTime;
    private BigDecimal startPrice;
    private BigDecimal endPrice;
}
