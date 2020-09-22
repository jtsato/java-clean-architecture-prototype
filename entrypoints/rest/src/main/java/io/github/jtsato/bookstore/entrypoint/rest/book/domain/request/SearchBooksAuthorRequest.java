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

    private static final long serialVersionUID = 1221045820674297463L;

    private Long id;
    private SearchBooksAuthorCountryRequest searchBooksAuthorCountryRequest;
    private String name;
    private String gender;
    private String startBirthdate;
    private String endBirthdate;
}
