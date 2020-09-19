package io.github.jtsato.bookstore.core.bookdocument.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.github.jtsato.bookstore.core.common.validation.LocalDateConstraint;
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
public class UpdateBookDocumentByXxKeyParameters extends SelfValidating<UpdateBookDocumentByXxKeyParameters> implements Serializable {

    private static final long serialVersionUID = 1040563539378194538L;

    @NotNull(message = "validation.book.document.xx.key.null")
    private Long xxKey;

    @NotNull(message = "validation.book.document.book.null")
    private final Long bookBbKey;

    @NotBlank(message = "validation.book.document.content.type.blank")
    private final String contentType;

    @NotBlank(message = "validation.book.document.extension.blank")
    private final String extension;

    @NotBlank(message = "validation.book.document.name.blank")
    private final String name;

    @NotNull(message = "validation.book.document.size.null")
    @Positive(message = "validation.book.document.size.negative.or.zero")
    private final Long size;

    @NotBlank(message = "validation.book.document.content.blank")
    private final String content;

    @LocalDateConstraint(message = "validation.book.document.creation.date.invalid")
    private final String creationDate;

    @LocalDateConstraint(message = "validation.book.document.last.modified.date.invalid")
    private final String lastModifiedDate;


    public UpdateBookDocumentByXxKeyParameters(final Long xxKey,
                                               final Long bookBbKey,
                                               final Long size,
                                               final String contentType,
                                               final String extension,
                                               final String name,
                                               final String content,
                                               final String creationDate,
                                               final String lastModifiedDate) {
        this.xxKey = xxKey;
        this.bookBbKey = bookBbKey;
        this.size = size;
        this.contentType = contentType;
        this.extension = extension;
        this.name = name;
        this.content = content;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.validateSelf();
    }
}
