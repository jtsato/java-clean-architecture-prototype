package io.github.jtsato.bookstore.dataprovider.document;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.GetDocumentByNumberIgnoreCaseGateway;
import io.github.jtsato.bookstore.dataprovider.document.domain.DocumentEntity;
import io.github.jtsato.bookstore.dataprovider.document.mapper.DocumentMapper;
import io.github.jtsato.bookstore.dataprovider.document.repository.DocumentRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetDocumentByNumberIgnoreCaseDataProvider implements GetDocumentByNumberIgnoreCaseGateway {

    private final DocumentMapper documentMapper = Mappers.getMapper(DocumentMapper.class);

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Optional<Document> execute(final String number) {
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead", "type");
        final Optional<DocumentEntity> optional = documentRepository.findByNumberIgnoreCase(number, entityGraph);
        return optional.map(documentMapper::of);
    }
}
