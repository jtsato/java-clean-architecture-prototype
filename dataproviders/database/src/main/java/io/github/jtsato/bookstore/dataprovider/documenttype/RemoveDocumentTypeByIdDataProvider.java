package io.github.jtsato.bookstore.dataprovider.documenttype;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.RemoveDocumentTypeByIdGateway;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.DocumentTypeEntity;
import io.github.jtsato.bookstore.dataprovider.documenttype.mapper.DocumentTypeMapper;
import io.github.jtsato.bookstore.dataprovider.documenttype.repository.DocumentTypeRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RemoveDocumentTypeByIdDataProvider implements RemoveDocumentTypeByIdGateway {

    private final DocumentTypeMapper documentTypeMapper = Mappers.getMapper(DocumentTypeMapper.class);
    
    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public Optional<DocumentType> execute(final Long id) {

        final Optional<DocumentTypeEntity> optional = documentTypeRepository.findById(id);

        return optional.map(this::removeDocumentTypeEntity);
    }

    private DocumentType removeDocumentTypeEntity(final DocumentTypeEntity documentTypeEntity) {
        final DocumentType documentType = documentTypeMapper.of(documentTypeEntity);
        documentTypeRepository.delete(documentTypeEntity);
        return documentType;
    }
}
