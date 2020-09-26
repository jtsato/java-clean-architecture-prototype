package io.github.jtsato.bookstore.core.book.usecase.parameter;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.github.jtsato.bookstore.core.common.validation.LocalDateTimeConstraint;
import io.github.jtsato.bookstore.core.common.validation.SelfValidating;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class RegisterBookParameters extends SelfValidating<RegisterBookParameters> implements Serializable {

    private static final long serialVersionUID = -3934097887650689782L;

    @NotNull(message = "validation.author.id.null")
    private final Long authorId;

    @NotNull(message = "validation.book.external.id.null")
    private final Long externalId;

    @NotBlank(message = "validation.book.title.blank")
    private final String title;

    @NotBlank(message = "validation.book.isbn.blank")
    private final String isbn;

    @NotNull(message = "validation.book.available.null")
    private final Boolean available;

    @LocalDateTimeConstraint(message = "validation.book.created.date.time.invalid")
    private final String createdDateTime;

    @LocalDateTimeConstraint(message = "validation.book.last.modified.date.time.invalid")
    private final String lastModifiedDateTime;

    @NotNull(message = "validation.book.price.null")
    @PositiveOrZero(message = "validation.book.price.negative")
    private final BigDecimal price; 

    public RegisterBookParameters(final Long authorId,
                                  final Long externalId,
                                  final String title,
                                  final String isbn,
                                  final Boolean available,
                                  final String createdDateTime,
                                  final String lastModifiedDateTime,
                                  final BigDecimal price) {
        this.authorId = authorId;
        this.externalId = externalId;
        this.title = title;
        this.isbn = isbn;
        this.available = available;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.price = price;
        this.validateSelf();
    }
}
