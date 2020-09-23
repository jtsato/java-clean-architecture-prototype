package io.github.jtsato.bookstore.core.book.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.github.jtsato.bookstore.core.author.domain.Author;
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
public class Book implements Serializable {

    private static final long serialVersionUID = 7502889937516120433L;

    private final Long id;
    private final Author author;
    private final String title;
    private final Boolean available;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
    private final BigDecimal price;
}
