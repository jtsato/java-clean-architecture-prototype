package io.github.jtsato.bookstore.core.document.usecase.parameter;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class UpdateDocumentByIdParameters extends SelfValidating<UpdateDocumentByIdParameters> implements Serializable {

    private static final long serialVersionUID = -3830109462604331384L;

    @NotNull(message = "validation.document.id.null")
    private Long id;

    @NotNull(message = "validation.lead.id.null")
    private final Long leadId;

    @NotNull(message = "validation.document.type.id.null")
    private final Long typeId;

    @NotNull(message = "validation.document.front.photo.null")
    private final Long frontPhoto;

    @NotNull(message = "validation.document.back.photo.null")
    private final Long backPhoto;

    @NotBlank(message = "validation.document.number.blank")
    private final String number;

    @NotBlank(message = "validation.document.issuer.blank")
    private final String issuer;

    @NotBlank(message = "validation.document.state.blank")
    private final String state;

    @NotBlank(message = "validation.document.issue.date.blank")
    @LocalDateConstraint(message = "validation.document.issue.date.invalid")
    private final String issueDate;

    public UpdateDocumentByIdParameters(final Long id,
                                        final Long leadId,
                                        final Long typeId,
                                        final Long frontPhoto,
                                        final Long backPhoto,
                                        final String number,
                                        final String issuer,
                                        final String state,
                                        final String issueDate) {
        this.id = id;
        this.leadId = leadId;
        this.typeId = typeId;
        this.frontPhoto = frontPhoto;
        this.backPhoto = backPhoto;
        this.number = number;
        this.issuer = issuer;
        this.state = state;
        this.issueDate = issueDate;
        this.validateSelf();
    }
}
