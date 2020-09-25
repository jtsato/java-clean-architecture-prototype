package io.github.jtsato.bookstore.entrypoint.rest.country.mapper;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.GetCountryByIdResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetCountryByIdPresenter {

    public static GetCountryByIdResponse of(final Country country) {
        return new GetCountryByIdResponse(country.getId(),
                                          country.getName());
    }
}
