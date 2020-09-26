package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.GetBookDocumentByXxKeyResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.GetBookDocumentByXxKeyBookResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.GetBookDocumentByXxKeyBookAuthorResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetBookDocumentByXxKeyPresenter {

    public static GetBookDocumentByXxKeyResponse of(final BookDocument bookDocument) {
        return new GetBookDocumentByXxKeyResponse(bookDocument.getXxKey(),
                                               of(bookDocument.getBook()),
                                                  bookDocument.getSize(),
                                                  bookDocument.getContentType(),
                                                  bookDocument.getExtension(),
                                                  bookDocument.getName(),
                                                  bookDocument.getContent(),
                                                  bookDocument.getCreationDate(),
                                                  bookDocument.getLastModifiedDate());
    }

    public static GetBookDocumentByXxKeyBookResponse of(final Book book) {
        return new GetBookDocumentByXxKeyBookResponse(book.getId(),
                                                   of(book.getAuthor()),
                                                      book.getExternalId(),
                                                      book.getTitle(),
                                                      book.getIsbn(),
                                                      book.getAvailable(),
                                                      book.getCreatedDateTime(),
                                                      book.getLastModifiedDateTime(),
                                                      book.getPrice());
    }

    public static GetBookDocumentByXxKeyBookAuthorResponse of(final Author author) {
        return new GetBookDocumentByXxKeyBookAuthorResponse(author.getId(),
                                                            author.getName(),
                                                            author.getGender().name(),
                                                            author.getBirthdate());
    }
}
