package io.github.jtsato.bookstore.entrypoint.rest.country.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.SearchCountriesResponse;
import io.github.jtsato.bookstore.entrypoint.rest.country.domain.response.SearchCountriesWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchCountriesPresenter {

    public static SearchCountriesWrapperResponse of(final Page<Country> page) {
        final List<Country> countries = page.getContent();
        final List<SearchCountriesResponse> content = new ArrayList<>(countries.size());
        countries.forEach(element -> content.add(of(element)));
        return new SearchCountriesWrapperResponse(content, page.getPageable());
    }

    public static SearchCountriesResponse of(final Country country) {
        return new SearchCountriesResponse(country.getId(),
                                           country.getName());
    }
}
