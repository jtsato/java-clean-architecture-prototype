package io.github.jtsato.bookstore.dataprovider.documenttype;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.UpdateDocumentTypeByIdGateway;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.DocumentTypeEntity;
import io.github.jtsato.bookstore.dataprovider.documenttype.mapper.DocumentTypeMapper;
import io.github.jtsato.bookstore.dataprovider.documenttype.repository.DocumentTypeRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateDocumentTypeByIdDataProvider implements UpdateDocumentTypeByIdGateway {

    private final DocumentTypeMapper documentTypeMapper = Mappers.getMapper(DocumentTypeMapper.class);

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public Optional<DocumentType> execute(final DocumentType documentType) {

        final Optional<DocumentTypeEntity> optional = documentTypeRepository.findById(documentType.getId());

        return optional.map(documentTypeEntity -> updateDocumentTypeEntity(documentTypeEntity, documentType));
    }

    private DocumentType updateDocumentTypeEntity(final DocumentTypeEntity documentTypeEntity, final DocumentType documentType) {
        documentTypeEntity.setCountry(documentType.getCountry());
        documentTypeEntity.setDescription(documentType.getDescription());
        documentTypeEntity.setLastModifiedDateTime(documentType.getLastModifiedDateTime());
        return documentTypeMapper.of(documentTypeRepository.saveAndFlush(documentTypeEntity));
    }
}
