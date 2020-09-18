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
public class UpdateBookByBKeyParameters extends SelfValidating<UpdateBookByBKeyParameters> implements Serializable {

    private static final long serialVersionUID = -9067621415912128130L;

    @NotNull(message = "validation.book.b.key.null")
    private Long bKey;

    @NotNull(message = "validation.book.author.null")
    private final Long authorAKey;

    @NotBlank(message = "validation.book.title.blank")
    private final String title;

    @NotNull(message = "validation.book.available.null")
    private final Boolean available;

    @NotNull(message = "validation.book.price.null")
    @PositiveOrZero(message = "validation.book.price.negative")
    private final BigDecimal price; 

    @LocalDateTimeConstraint(message = "validation.book.created.date.invalid")
    private final String createdDate;

    @LocalDateTimeConstraint(message = "validation.book.last.modified.date.invalid")
    private final String lastModifiedDate;


    public UpdateBookByBKeyParameters(final Long bKey,
                                      final Long authorAKey,
                                      final String title,
                                      final Boolean available,
                                      final String createdDate,
                                      final String lastModifiedDate,
                                      final BigDecimal price) {
        this.bKey = bKey;
        this.authorAKey = authorAKey;
        this.title = title;
        this.available = available;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.price = price;
        this.validateSelf();
    }
}
