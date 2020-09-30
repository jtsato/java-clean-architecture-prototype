package io.github.jtsato.bookstore.entrypoint.rest.document.domain.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateDocumentByIdRequest implements Serializable {

    private static final long serialVersionUID = -8595843948618495418L;

    private Long id;
    private Long leadId;
    private Long typeId;
    private Long frontPhoto;
    private Long backPhoto;
    private String number;
    private String issuer;
    private String state;
    private String issueDate;
    private String createdDateTime;
    private String lastModifiedDateTime;
}
