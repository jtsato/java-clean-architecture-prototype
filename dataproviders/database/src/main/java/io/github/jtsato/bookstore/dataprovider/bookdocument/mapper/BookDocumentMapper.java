package io.github.jtsato.bookstore.dataprovider.bookdocument.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.bookdocument.domain.BookDocument;
import io.github.jtsato.bookstore.dataprovider.bookdocument.domain.BookDocumentEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper
public interface BookDocumentMapper {

    BookDocument of(final BookDocumentEntity bookDocumentEntity);

    BookDocumentEntity of(final BookDocument bookDocument);
}