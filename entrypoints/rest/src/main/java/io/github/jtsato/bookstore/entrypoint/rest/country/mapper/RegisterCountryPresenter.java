package io.github.jtsato.bookstore.entrypoint.rest.country.mapper;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.RegisterCountryResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegisterCountryPresenter {

    public static RegisterCountryResponse of(final Country country) {
        return new RegisterCountryResponse(country.getId(),
                                           country.getName());
    }
}
