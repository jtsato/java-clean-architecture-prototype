package io.github.jtsato.bookstore.entrypoint.rest.author.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.SearchAuthorsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.SearchAuthorsCountryResponse;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.SearchAuthorsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchAuthorsPresenter {

    public static SearchAuthorsWrapperResponse of(final Page<Author> page) {
        final List<Author> authors = page.getContent();
        final List<SearchAuthorsResponse> content = new ArrayList<>(authors.size());
        authors.forEach(element -> content.add(of(element)));
        return new SearchAuthorsWrapperResponse(content, page.getPageable());
    }

    public static SearchAuthorsResponse of(final Author author) {
        return new SearchAuthorsResponse(author.getId(),
                                      of(author.getCountry()),
                                         author.getName(),
                                         author.getGender().name(),
                                         author.getBirthdate());
    }

    public static SearchAuthorsCountryResponse of(final Country country) {
        return new SearchAuthorsCountryResponse(country.getId(),
                                                country.getName());
    }
}
