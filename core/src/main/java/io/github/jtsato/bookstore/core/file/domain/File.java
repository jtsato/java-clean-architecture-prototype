package io.github.jtsato.bookstore.core.file.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
public class File implements Serializable {

    private static final long serialVersionUID = 6416701222577717476L;

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
