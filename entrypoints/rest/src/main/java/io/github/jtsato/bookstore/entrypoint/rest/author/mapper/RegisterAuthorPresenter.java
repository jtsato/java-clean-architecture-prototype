package io.github.jtsato.bookstore.entrypoint.rest.author.mapper;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.RegisterAuthorResponse;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.RegisterAuthorCountryResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegisterAuthorPresenter {

    public static RegisterAuthorResponse of(final Author author) {
        return new RegisterAuthorResponse(author.getId(),
                                       of(author.getCountry()),
                                          author.getName(),
                                          author.getGender().name(),
                                          author.getBirthdate());
    }

    public static RegisterAuthorCountryResponse of(final Country country) {
        return new RegisterAuthorCountryResponse(country.getId(),
                                                 country.getName());
    }
}
