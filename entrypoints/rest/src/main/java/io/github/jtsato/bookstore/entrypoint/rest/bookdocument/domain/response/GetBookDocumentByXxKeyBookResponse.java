package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class GetBookDocumentByXxKeyBookResponse implements Serializable {

    private static final long serialVersionUID = -375269963601917419L;

    private final Long id;
    private final GetBookDocumentByXxKeyBookAuthorResponse author;
    private final Long externalId;
    private final String title;
    private final String isbn;
    private final Boolean available;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
    private final BigDecimal price;
}
