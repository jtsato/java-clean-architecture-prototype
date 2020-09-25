package io.github.jtsato.bookstore.entrypoint.rest.author.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.FindAuthorsByIdsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.author.domain.response.FindAuthorsByIdsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindAuthorsByIdsPresenter {

    public static FindAuthorsByIdsWrapperResponse of(final Page<Author> page) {
        final List<Author> authors = page.getContent();
        final List<FindAuthorsByIdsResponse> content = new ArrayList<>(authors.size());
        authors.forEach(element -> content.add(of(element)));
        return new FindAuthorsByIdsWrapperResponse(content, page.getPageable());
    }

    public static FindAuthorsByIdsResponse of(final Author author) {
        return new FindAuthorsByIdsResponse(author.getId(),
                                            author.getName(),
                                            author.getGender().name(),
                                            author.getBirthdate());
    }
}
