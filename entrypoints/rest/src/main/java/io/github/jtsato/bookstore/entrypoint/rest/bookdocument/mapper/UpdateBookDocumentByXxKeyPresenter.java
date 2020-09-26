package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.UpdateBookDocumentByXxKeyResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.UpdateBookDocumentByXxKeyBookResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.UpdateBookDocumentByXxKeyBookAuthorResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateBookDocumentByXxKeyPresenter {

    public static UpdateBookDocumentByXxKeyResponse of(final BookDocument bookDocument) {
        return new UpdateBookDocumentByXxKeyResponse(bookDocument.getXxKey(),
                                                  of(bookDocument.getBook()),
                                                     bookDocument.getSize(),
                                                     bookDocument.getContentType(),
                                                     bookDocument.getExtension(),
                                                     bookDocument.getName(),
                                                     bookDocument.getContent(),
                                                     bookDocument.getCreationDate(),
                                                     bookDocument.getLastModifiedDate());
    }

    public static UpdateBookDocumentByXxKeyBookResponse of(final Book book) {
        return new UpdateBookDocumentByXxKeyBookResponse(book.getId(),
                                                      of(book.getAuthor()),
                                                         book.getExternalId(),
                                                         book.getTitle(),
                                                         book.getIsbn(),
                                                         book.getAvailable(),
                                                         book.getCreatedDateTime(),
                                                         book.getLastModifiedDateTime(),
                                                         book.getPrice());
    }

    public static UpdateBookDocumentByXxKeyBookAuthorResponse of(final Author author) {
        return new UpdateBookDocumentByXxKeyBookAuthorResponse(author.getId(),
                                                               author.getName(),
                                                               author.getGender().name(),
                                                               author.getBirthdate());
    }
}
