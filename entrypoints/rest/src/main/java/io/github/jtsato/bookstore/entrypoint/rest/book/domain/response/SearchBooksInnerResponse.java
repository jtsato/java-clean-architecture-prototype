package io.github.jtsato.bookstore.entrypoint.rest.book.domain.response;

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
public class SearchBooksInnerResponse implements Serializable {

    private static final long serialVersionUID = -4931005400821055432L;

    private final Long id;
    private final SearchBooksAuthorInnerResponse author;
    private final String title;
    private final Boolean available;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
    private final BigDecimal price;
}
