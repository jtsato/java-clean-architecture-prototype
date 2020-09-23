package io.github.jtsato.bookstore.entrypoint.rest.author.domain.request;

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
public final class SearchAuthorsRequest implements Serializable {

    private static final long serialVersionUID = -9072099279955475982L;

    private Long id;
    private SearchAuthorsCountryRequest country;
    private String name;
    private String gender;
    private String startBirthdate;
    private String endBirthdate;
}