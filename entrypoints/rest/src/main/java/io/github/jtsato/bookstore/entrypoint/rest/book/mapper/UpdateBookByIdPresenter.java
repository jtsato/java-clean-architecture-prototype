package io.github.jtsato.bookstore.entrypoint.rest.book.mapper;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.UpdateBookByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.UpdateBookByIdAuthorResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.UpdateBookByIdAuthorCountryResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateBookByIdPresenter {

    public static UpdateBookByIdResponse of(final Book book) {
        return new UpdateBookByIdResponse(book.getId(),
                                       of(book.getAuthor()),
                                          book.getTitle(),
                                          book.getIsbn(),
                                          book.getAvailable(),
                                          book.getCreatedDateTime(),
                                          book.getLastModifiedDateTime(),
                                          book.getPrice());
    }

    public static UpdateBookByIdAuthorResponse of(final Author author) {
        return new UpdateBookByIdAuthorResponse(author.getId(),
                                             of(author.getCountry()),
                                                author.getName(),
                                                author.getGender().name(),
                                                author.getBirthdate());
    }

    public static UpdateBookByIdAuthorCountryResponse of(final Country country) {
        return new UpdateBookByIdAuthorCountryResponse(country.getId(),
                                                       country.getName());
    }
}
