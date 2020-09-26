package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class UpdateBookDocumentByXxKeyResponse implements Serializable {

    private static final long serialVersionUID = 6235955192394434677L;

    private final Long xxKey;
    private final UpdateBookDocumentByXxKeyBookResponse book;
    private final Long size;
    private final String contentType;
    private final String extension;
    private final String name;
    private final String content;
    private final LocalDate creationDate;
    private final LocalDate lastModifiedDate;
}
