package io.github.jtsato.bookstore.entrypoint.rest.book.mapper;

import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.UpdateBookByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.UpdateBookByIdAuthorResponse;
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
                                          book.getExternalId(),
                                          book.getTitle(),
                                          book.getIsbn(),
                                          book.getAvailable(),
                                          book.getCreatedDateTime(),
                                          book.getLastModifiedDateTime(),
                                          book.getPrice());
    }

    public static UpdateBookByIdAuthorResponse of(final Author author) {
        return new UpdateBookByIdAuthorResponse(author.getId(),
                                                author.getName(),
                                                author.getGender().name(),
                                                author.getBirthdate());
    }
}
