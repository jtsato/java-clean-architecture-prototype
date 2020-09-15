package io.github.jtsato.bookstore.core.bookdocument.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class RegisterBookDocumentParameters extends SelfValidating<RegisterBookDocumentParameters> implements Serializable {

    private static final long serialVersionUID = -7457612103854439118L;

    private final Long bookId;

    @NotBlank(message = "validation.book.document.content.type.blank")
    private final String contentType;

    @NotBlank(message = "validation.book.document.extension.blank")
    private final String extension;

    @NotBlank(message = "validation.book.document.name.blank")
    private final String name;

    @NotNull(message = "validation.book.document.size.null")
    private final Long size;

    @NotBlank(message = "validation.book.document.content.blank")
    private final String content;

    public RegisterBookDocumentParameters(final Long bookId,
                                          final Long size,
                                          final String contentType,
                                          final String extension,
                                          final String name,
                                          final String content) {
        this.bookId = bookId;
        this.size = size;
        this.contentType = contentType;
        this.extension = extension;
        this.name = name;
        this.content = content;
        this.validateSelf();
    }
}
