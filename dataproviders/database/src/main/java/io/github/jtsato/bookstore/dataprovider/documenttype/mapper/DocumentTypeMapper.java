package io.github.jtsato.bookstore.dataprovider.documenttype.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.DocumentTypeEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper
public interface DocumentTypeMapper {

    DocumentType of(final DocumentTypeEntity documentTypeEntity);

    DocumentTypeEntity of(final DocumentType documentType);
}
