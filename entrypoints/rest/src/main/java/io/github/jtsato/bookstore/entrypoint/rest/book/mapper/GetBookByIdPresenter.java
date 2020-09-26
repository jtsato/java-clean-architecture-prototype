package io.github.jtsato.bookstore.entrypoint.rest.book.mapper;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.GetBookByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.GetBookByIdAuthorResponse;
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
                                       book.getExternalId(),
                                       book.getTitle(),
                                       book.getIsbn(),
                                       book.getAvailable(),
                                       book.getCreatedDateTime(),
                                       book.getLastModifiedDateTime(),
                                       book.getPrice());
    }

    public static GetBookByIdAuthorResponse of(final Author author) {
        return new GetBookByIdAuthorResponse(author.getId(),
                                             author.getName(),
                                             author.getGender().name(),
                                             author.getBirthdate());
    }
}
