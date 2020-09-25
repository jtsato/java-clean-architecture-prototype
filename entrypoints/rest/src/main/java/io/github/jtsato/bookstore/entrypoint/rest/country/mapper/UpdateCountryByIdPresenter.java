package io.github.jtsato.bookstore.entrypoint.rest.country.mapper;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.UpdateCountryByIdResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateCountryByIdPresenter {

    public static UpdateCountryByIdResponse of(final Country country) {
        return new UpdateCountryByIdResponse(country.getId(),
                                             country.getName());
    }
}
