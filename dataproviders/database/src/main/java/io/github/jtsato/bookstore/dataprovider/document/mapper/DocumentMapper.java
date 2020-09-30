package io.github.jtsato.bookstore.dataprovider.document.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.dataprovider.lead.mapper.LeadMapper;
import io.github.jtsato.bookstore.dataprovider.documenttype.mapper.DocumentTypeMapper;
import io.github.jtsato.bookstore.dataprovider.document.domain.DocumentEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper(uses = {LeadMapper.class, DocumentTypeMapper.class})
public interface DocumentMapper {

    Document of(final DocumentEntity documentEntity);

    DocumentEntity of(final Document document);
}
