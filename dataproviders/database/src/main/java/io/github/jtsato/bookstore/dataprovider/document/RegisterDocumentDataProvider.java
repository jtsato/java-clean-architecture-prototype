package io.github.jtsato.bookstore.dataprovider.document;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.RegisterDocumentGateway;
import io.github.jtsato.bookstore.dataprovider.document.domain.DocumentEntity;
import io.github.jtsato.bookstore.dataprovider.document.mapper.DocumentMapper;
import io.github.jtsato.bookstore.dataprovider.document.repository.DocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterDocumentDataProvider implements RegisterDocumentGateway {

    private final DocumentMapper documentMapper = Mappers.getMapper(DocumentMapper.class);
    
    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Document execute(final Document document) {
        final DocumentEntity documentEntity = documentMapper.of(document);
        return documentMapper.of(documentRepository.saveAndFlush(documentEntity));
    }
}
