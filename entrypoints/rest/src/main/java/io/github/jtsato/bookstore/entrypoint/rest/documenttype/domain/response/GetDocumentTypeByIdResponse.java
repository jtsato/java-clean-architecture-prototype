package io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class GetDocumentTypeByIdResponse implements Serializable {

    private static final long serialVersionUID = -8453529458580698858L;

    private final Long id;
    private final String country;
    private final String description;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}
