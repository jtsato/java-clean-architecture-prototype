package io.github.jtsato.bookstore.entrypoint.rest.book.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.core.book.domain.Book;
import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.SearchBooksResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.SearchBooksAuthorResponse;
import io.github.jtsato.bookstore.entrypoint.rest.book.domain.response.SearchBooksWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchBooksPresenter {

    public static SearchBooksWrapperResponse of(final Page<Book> page) {
        final List<Book> books = page.getContent();
        final List<SearchBooksResponse> content = new ArrayList<>(books.size());
        books.forEach(element -> content.add(of(element)));
        return new SearchBooksWrapperResponse(content, page.getPageable());
    }

    public static SearchBooksResponse of(final Book book) {
        return new SearchBooksResponse(book.getId(),
                                    of(book.getAuthor()),
                                       book.getTitle(),
                                       book.getIsbn(),
                                       book.getAvailable(),
                                       book.getCreatedDateTime(),
                                       book.getLastModifiedDateTime(),
                                       book.getPrice());
    }

    public static SearchBooksAuthorResponse of(final Author author) {
        return new SearchBooksAuthorResponse(author.getId(),
                                             author.getName(),
                                             author.getGender().name(),
                                             author.getBirthdate());
    }
}
