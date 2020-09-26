package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.RegisterBookDocumentResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.RegisterBookDocumentBookResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.RegisterBookDocumentBookAuthorResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegisterBookDocumentPresenter {

    public static RegisterBookDocumentResponse of(final BookDocument bookDocument) {
        return new RegisterBookDocumentResponse(bookDocument.getXxKey(),
                                             of(bookDocument.getBook()),
                                                bookDocument.getSize(),
                                                bookDocument.getContentType(),
                                                bookDocument.getExtension(),
                                                bookDocument.getName(),
                                                bookDocument.getContent(),
                                                bookDocument.getCreationDate(),
                                                bookDocument.getLastModifiedDate());
    }

    public static RegisterBookDocumentBookResponse of(final Book book) {
        return new RegisterBookDocumentBookResponse(book.getId(),
                                                 of(book.getAuthor()),
                                                    book.getExternalId(),
                                                    book.getTitle(),
                                                    book.getIsbn(),
                                                    book.getAvailable(),
                                                    book.getCreatedDateTime(),
                                                    book.getLastModifiedDateTime(),
                                                    book.getPrice());
    }

    public static RegisterBookDocumentBookAuthorResponse of(final Author author) {
        return new RegisterBookDocumentBookAuthorResponse(author.getId(),
                                                          author.getName(),
                                                          author.getGender().name(),
                                                          author.getBirthdate());
    }
}
