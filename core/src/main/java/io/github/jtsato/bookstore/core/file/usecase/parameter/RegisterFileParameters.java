package io.github.jtsato.bookstore.core.file.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
public class RegisterFileParameters extends SelfValidating<RegisterFileParameters> implements Serializable {

    private static final long serialVersionUID = 2506453344670924996L;

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

    public RegisterFileParameters(final Long size,
                                  final String contentType,
                                  final String extension,
                                  final String name,
                                  final String content,
                                  final String url) {
        this.size = size;
        this.contentType = contentType;
        this.extension = extension;
        this.name = name;
        this.content = content;
        this.url = url;
        this.validateSelf();
    }
}
