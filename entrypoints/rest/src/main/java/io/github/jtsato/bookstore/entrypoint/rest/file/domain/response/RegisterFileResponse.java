package io.github.jtsato.bookstore.entrypoint.rest.file.domain.response;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class RegisterFileResponse implements Serializable {

    private static final long serialVersionUID = -702733450633785958L;

    private final Long id;
    private final Long size;
    private final String contentType;
    private final String extension;
    private final String name;
    private final String content;
    private final String url;
    private final LocalDate creationDate;
    private final LocalDate lastModifiedDate;
}