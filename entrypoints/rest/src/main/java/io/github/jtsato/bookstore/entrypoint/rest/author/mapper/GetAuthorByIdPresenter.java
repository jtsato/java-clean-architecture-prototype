package io.github.jtsato.bookstore.entrypoint.rest.author.mapper;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.GetAuthorByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.GetAuthorByIdCountryResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetAuthorByIdPresenter {

    public static GetAuthorByIdResponse of(final Author author) {
        return new GetAuthorByIdResponse(author.getId(),
                                      of(author.getCountry()),
                                         author.getName(),
                                         author.getGender().name(),
                                         author.getBirthdate());
    }

    public static GetAuthorByIdCountryResponse of(final Country country) {
        return new GetAuthorByIdCountryResponse(country.getId(),
                                                country.getName());
    }
}
