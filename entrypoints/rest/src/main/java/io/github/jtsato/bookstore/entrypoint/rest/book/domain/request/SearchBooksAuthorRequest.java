package io.github.jtsato.bookstore.entrypoint.rest.book.domain.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class SearchBooksAuthorRequest implements Serializable {

    private static final long serialVersionUID = -7752528783905437285L;

    private Long id;
    private String name;
    private String gender;
    private String startBirthdate;
    private String endBirthdate;
}
