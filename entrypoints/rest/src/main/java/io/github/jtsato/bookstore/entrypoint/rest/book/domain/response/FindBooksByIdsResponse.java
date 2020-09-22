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
public class FindBooksByIdsResponse implements Serializable {

    private static final long serialVersionUID = -8701096891991306838L;

    private final Long id;
    private final FindBooksByIdsAuthorResponse author;
    private final String title;
    private final Boolean available;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
    private final BigDecimal price;
}
