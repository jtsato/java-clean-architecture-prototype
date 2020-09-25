package io.github.jtsato.bookstore.entrypoint.rest.country.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.FindCountriesByIdsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.FindCountriesByIdsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindCountriesByIdsPresenter {

    public static FindCountriesByIdsWrapperResponse of(final Page<Country> page) {
        final List<Country> countries = page.getContent();
        final List<FindCountriesByIdsResponse> content = new ArrayList<>(countries.size());
        countries.forEach(element -> content.add(of(element)));
        return new FindCountriesByIdsWrapperResponse(content, page.getPageable());
    }

    public static FindCountriesByIdsResponse of(final Country country) {
        return new FindCountriesByIdsResponse(country.getId(),
                                              country.getName());
    }
}
