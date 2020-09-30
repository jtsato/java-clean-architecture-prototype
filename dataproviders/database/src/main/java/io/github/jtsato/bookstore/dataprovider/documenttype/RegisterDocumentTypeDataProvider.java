package io.github.jtsato.bookstore.dataprovider.documenttype;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.RegisterDocumentTypeGateway;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.DocumentTypeEntity;
import io.github.jtsato.bookstore.dataprovider.documenttype.mapper.DocumentTypeMapper;
import io.github.jtsato.bookstore.dataprovider.documenttype.repository.DocumentTypeRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterDocumentTypeDataProvider implements RegisterDocumentTypeGateway {

    private final DocumentTypeMapper documentTypeMapper = Mappers.getMapper(DocumentTypeMapper.class);
    
    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public DocumentType execute(final DocumentType documentType) {
        final DocumentTypeEntity documentTypeEntity = documentTypeMapper.of(documentType);
        return documentTypeMapper.of(documentTypeRepository.saveAndFlush(documentTypeEntity));
    }
}
