package io.github.jtsato.bookstore.core.bookdocument.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
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
public class BookDocument implements Serializable {

    private static final long serialVersionUID = 7381595637318371837L;

    private final Long xxx;
    private final Long bookId;
    private final Long size;
    private final String contentType;
    private final String extension;
    private final String name;
    private final String content;
    private final LocalDateTime creationDate;
    private final LocalDateTime lastModifiedDate;
}
