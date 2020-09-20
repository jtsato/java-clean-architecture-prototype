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
public class UpdateBookByIdParameters extends SelfValidating<UpdateBookByIdParameters> implements Serializable {

    private static final long serialVersionUID = -6638489230514304272L;

    @NotNull(message = "validation.book.id.null")
    private Long id;

    @NotNull(message = "validation.author.id.null")
    private final Long authorId;

    @NotBlank(message = "validation.book.title.blank")
    private final String title;

    @NotNull(message = "validation.book.available.null")
    private final Boolean available;

    @LocalDateTimeConstraint(message = "validation.book.created.date.time.invalid")
    private final String createdDateTime;

    @LocalDateTimeConstraint(message = "validation.book.last.modified.date.time.invalid")
    private final String lastModifiedDateTime;

    @NotNull(message = "validation.book.price.null")
    @PositiveOrZero(message = "validation.book.price.negative")
    private final BigDecimal price; 

    public UpdateBookByIdParameters(final Long id,
                                    final Long authorId,
                                    final String title,
                                    final Boolean available,
                                    final String createdDateTime,
                                    final String lastModifiedDateTime,
                                    final BigDecimal price) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.available = available;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.price = price;
        this.validateSelf();
    }
}
