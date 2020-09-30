package io.github.jtsato.bookstore.dataprovider.document;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.UpdateDocumentByIdGateway;
import io.github.jtsato.bookstore.dataprovider.lead.repository.LeadRepository;
import io.github.jtsato.bookstore.dataprovider.documenttype.repository.DocumentTypeRepository;
import io.github.jtsato.bookstore.dataprovider.document.domain.DocumentEntity;
import io.github.jtsato.bookstore.dataprovider.document.mapper.DocumentMapper;
import io.github.jtsato.bookstore.dataprovider.document.repository.DocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateDocumentByIdDataProvider implements UpdateDocumentByIdGateway {

    private final DocumentMapper documentMapper = Mappers.getMapper(DocumentMapper.class);

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public Optional<Document> execute(final Document document) {

        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead", "type");
        final Optional<DocumentEntity> optional = documentRepository.findById(document.getId(), entityGraph);

        return optional.map(documentEntity -> updateDocumentEntity(documentEntity, document));
    }

    private Document updateDocumentEntity(final DocumentEntity documentEntity, final Document document) {
        updateLeadEntity(document, documentEntity);
        updateDocumentTypeEntity(document, documentEntity);
        documentEntity.setNumber(document.getNumber());
        documentEntity.setIssueDate(document.getIssueDate());
        documentEntity.setIssuer(document.getIssuer());
        documentEntity.setState(document.getState());
        documentEntity.setFrontPhoto(document.getFrontPhoto());
        documentEntity.setBackPhoto(document.getBackPhoto());
        documentEntity.setLastModifiedDateTime(document.getLastModifiedDateTime());
        return documentMapper.of(documentRepository.saveAndFlush(documentEntity));
    }

    private void updateLeadEntity(final Document document, final DocumentEntity documentEntity) {
        final Long currentLeadId = documentEntity.getLead().getId();
        final Long newLeadId = document.getLead().getId();
        if (!newLeadId.equals(currentLeadId)) {
            leadRepository.findById(newLeadId).ifPresent(documentEntity::setLead);
        }
    }

    private void updateDocumentTypeEntity(final Document document, final DocumentEntity documentEntity) {
        final Long currentDocumentTypeId = documentEntity.getType().getId();
        final Long newDocumentTypeId = document.getType().getId();
        if (!newDocumentTypeId.equals(currentDocumentTypeId)) {
            documentTypeRepository.findById(newDocumentTypeId).ifPresent(documentEntity::setType);
        }
    }
}
