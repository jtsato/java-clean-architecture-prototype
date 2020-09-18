package io.github.jtsato.bookstore.core.bookdocument.domain;

import java.io.Serializable;
import java.time.LocalDate;

import io.github.jtsato.bookstore.core.book.domain.Book;
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

    private static final long serialVersionUID = 5224672554477177363L;

    private final Long xxx;
    private final Book book;
    private final Long size;
    private final String contentType;
    private final String extension;
    private final String name;
    private final String content;
    private final LocalDate creationDate;
    private final LocalDate lastModifiedDate;
}
