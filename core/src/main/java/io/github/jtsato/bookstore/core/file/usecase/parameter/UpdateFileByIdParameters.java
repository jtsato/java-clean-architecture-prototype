package io.github.jtsato.bookstore.core.file.usecase.parameter;

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
public class UpdateFileByIdParameters extends SelfValidating<UpdateFileByIdParameters> implements Serializable {

    private static final long serialVersionUID = 1582566148785128052L;

    @NotNull(message = "validation.file.id.null")
    private Long id;

    @NotNull(message = "validation.file.size.null")
    @Positive(message = "validation.file.size.negative.or.zero")
    private final Long size;

    @NotBlank(message = "validation.file.content.type.blank")
    private final String contentType;

    @NotBlank(message = "validation.file.extension.blank")
    private final String extension;

    @NotBlank(message = "validation.file.name.blank")
    private final String name;

    @NotBlank(message = "validation.file.content.blank")
    private final String content;

    @NotBlank(message = "validation.file.url.blank")
    private final String url;

    @LocalDateConstraint(message = "validation.file.creation.date.invalid")
    private final String creationDate;

    @LocalDateConstraint(message = "validation.file.last.modified.date.invalid")
    private final String lastModifiedDate;

    public UpdateFileByIdParameters(final Long id,
                                    final Long size,
                                    final String contentType,
                                    final String extension,
                                    final String name,
                                    final String content,
                                    final String url,
                                    final String creationDate,
                                    final String lastModifiedDate) {
        this.id = id;
        this.size = size;
        this.contentType = contentType;
        this.extension = extension;
        this.name = name;
        this.content = content;
        this.url = url;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.validateSelf();
    }
}
