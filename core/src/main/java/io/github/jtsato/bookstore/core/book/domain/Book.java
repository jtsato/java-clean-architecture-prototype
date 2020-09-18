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

    private static final long serialVersionUID = 8231145717810089072L;

    private final Long bKey;
    private final Author author;
    private final String title;
    private final Boolean available;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;
    private final BigDecimal price;
}
