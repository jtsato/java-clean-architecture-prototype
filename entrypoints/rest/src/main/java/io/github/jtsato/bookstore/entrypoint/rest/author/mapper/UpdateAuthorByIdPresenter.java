package io.github.jtsato.bookstore.entrypoint.rest.author.mapper;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.UpdateAuthorByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.UpdateAuthorByIdCountryResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateAuthorByIdPresenter {

    public static UpdateAuthorByIdResponse of(final Author author) {
        return new UpdateAuthorByIdResponse(author.getId(),
                                         of(author.getCountry()),
                                            author.getName(),
                                            author.getGender().name(),
                                            author.getBirthdate());
    }

    public static UpdateAuthorByIdCountryResponse of(final Country country) {
        return new UpdateAuthorByIdCountryResponse(country.getId(),
                                                   country.getName());
    }
}
