package io.github.jtsato.bookstore.entrypoint.rest.document.domain.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class RegisterDocumentResponse implements Serializable {

    private static final long serialVersionUID = -4905565326556836851L;

    private final Long id;
    private final RegisterDocumentLeadResponse lead;
    private final RegisterDocumentTypeResponse type;
    private final Long frontPhoto;
    private final Long backPhoto;
    private final String number;
    private final String issuer;
    private final String state;
    private final LocalDate issueDate;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}
