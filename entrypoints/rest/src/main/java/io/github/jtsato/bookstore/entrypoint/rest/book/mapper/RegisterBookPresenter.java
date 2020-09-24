package io.github.jtsato.bookstore.entrypoint.rest.book.mapper;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.RegisterBookResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.RegisterBookAuthorResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.RegisterBookAuthorCountryResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegisterBookPresenter {

    public static RegisterBookResponse of(final Book book) {
        return new RegisterBookResponse(book.getId(),
                                     of(book.getAuthor()),
                                        book.getTitle(),
                                        book.getIsbn(),
                                        book.getAvailable(),
                                        book.getCreatedDateTime(),
                                        book.getLastModifiedDateTime(),
                                        book.getPrice());
    }

    public static RegisterBookAuthorResponse of(final Author author) {
        return new RegisterBookAuthorResponse(author.getId(),
                                           of(author.getCountry()),
                                              author.getName(),
                                              author.getGender().name(),
                                              author.getBirthdate());
    }

    public static RegisterBookAuthorCountryResponse of(final Country country) {
        return new RegisterBookAuthorCountryResponse(country.getId(),
                                                     country.getName());
    }
}
