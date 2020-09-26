package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.SearchBookDocumentsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.SearchBookDocumentsBookResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.SearchBookDocumentsBookAuthorResponse;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.SearchBookDocumentsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchBookDocumentsPresenter {

    public static SearchBookDocumentsWrapperResponse of(final Page<BookDocument> page) {
        final List<BookDocument> bookDocuments = page.getContent();
        final List<SearchBookDocumentsResponse> content = new ArrayList<>(bookDocuments.size());
        bookDocuments.forEach(element -> content.add(of(element)));
        return new SearchBookDocumentsWrapperResponse(content, page.getPageable());
    }

    public static SearchBookDocumentsResponse of(final BookDocument bookDocument) {
        return new SearchBookDocumentsResponse(bookDocument.getXxKey(),
                                            of(bookDocument.getBook()),
                                               bookDocument.getSize(),
                                               bookDocument.getContentType(),
                                               bookDocument.getExtension(),
                                               bookDocument.getName(),
                                               bookDocument.getContent(),
                                               bookDocument.getCreationDate(),
                                               bookDocument.getLastModifiedDate());
    }

    public static SearchBookDocumentsBookResponse of(final Book book) {
        return new SearchBookDocumentsBookResponse(book.getId(),
                                                of(book.getAuthor()),
                                                   book.getExternalId(),
                                                   book.getTitle(),
                                                   book.getIsbn(),
                                                   book.getAvailable(),
                                                   book.getCreatedDateTime(),
                                                   book.getLastModifiedDateTime(),
                                                   book.getPrice());
    }

    public static SearchBookDocumentsBookAuthorResponse of(final Author author) {
        return new SearchBookDocumentsBookAuthorResponse(author.getId(),
                                                         author.getName(),
                                                         author.getGender().name(),
                                                         author.getBirthdate());
    }
}
