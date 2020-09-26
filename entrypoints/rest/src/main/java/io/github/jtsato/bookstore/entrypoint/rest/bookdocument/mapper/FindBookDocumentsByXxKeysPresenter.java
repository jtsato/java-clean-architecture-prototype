package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.FindBookDocumentsByXxKeysResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.FindBookDocumentsByXxKeysBookResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.FindBookDocumentsByXxKeysBookAuthorResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.FindBookDocumentsByXxKeysWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindBookDocumentsByXxKeysPresenter {

    public static FindBookDocumentsByXxKeysWrapperResponse of(final Page<BookDocument> page) {
        final List<BookDocument> bookDocuments = page.getContent();
        final List<FindBookDocumentsByXxKeysResponse> content = new ArrayList<>(bookDocuments.size());
        bookDocuments.forEach(element -> content.add(of(element)));
        return new FindBookDocumentsByXxKeysWrapperResponse(content, page.getPageable());
    }

    public static FindBookDocumentsByXxKeysResponse of(final BookDocument bookDocument) {
        return new FindBookDocumentsByXxKeysResponse(bookDocument.getXxKey(),
                                                  of(bookDocument.getBook()),
                                                     bookDocument.getSize(),
                                                     bookDocument.getContentType(),
                                                     bookDocument.getExtension(),
                                                     bookDocument.getName(),
                                                     bookDocument.getContent(),
                                                     bookDocument.getCreationDate(),
                                                     bookDocument.getLastModifiedDate());
    }

    public static FindBookDocumentsByXxKeysBookResponse of(final Book book) {
        return new FindBookDocumentsByXxKeysBookResponse(book.getId(),
                                                      of(book.getAuthor()),
                                                         book.getExternalId(),
                                                         book.getTitle(),
                                                         book.getIsbn(),
                                                         book.getAvailable(),
                                                         book.getCreatedDateTime(),
                                                         book.getLastModifiedDateTime(),
                                                         book.getPrice());
    }

    public static FindBookDocumentsByXxKeysBookAuthorResponse of(final Author author) {
        return new FindBookDocumentsByXxKeysBookAuthorResponse(author.getId(),
                                                               author.getName(),
                                                               author.getGender().name(),
                                                               author.getBirthdate());
    }
}
