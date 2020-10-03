package io.github.jtsato.bookstore.core.document.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Document implements Serializable {

    private static final long serialVersionUID = -7188542182024068148L;

    private final Long id;
    private final Lead lead;
    private final DocumentType type;
    private final Long frontPhoto;
    private final Long backPhoto;
    private final String number;
    private final String issuer;
    private final String state;
    private final LocalDate issueDate;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}
