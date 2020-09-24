package io.github.jtsato.bookstore.entrypoint.rest.book.mapper;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.GetBookByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.GetBookByIdAuthorResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.GetBookByIdAuthorCountryResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetBookByIdPresenter {

    public static GetBookByIdResponse of(final Book book) {
        return new GetBookByIdResponse(book.getId(),
                                    of(book.getAuthor()),
                                       book.getTitle(),
                                       book.getIsbn(),
                                       book.getAvailable(),
                                       book.getCreatedDateTime(),
                                       book.getLastModifiedDateTime(),
                                       book.getPrice());
    }

    public static GetBookByIdAuthorResponse of(final Author author) {
        return new GetBookByIdAuthorResponse(author.getId(),
                                          of(author.getCountry()),
                                             author.getName(),
                                             author.getGender().name(),
                                             author.getBirthdate());
    }

    public static GetBookByIdAuthorCountryResponse of(final Country country) {
        return new GetBookByIdAuthorCountryResponse(country.getId(),
                                                    country.getName());
    }
}
