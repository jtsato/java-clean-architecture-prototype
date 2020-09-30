package io.github.jtsato.bookstore.dataprovider.document;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.FindDocumentsByIdsGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.document.domain.DocumentEntity;
import io.github.jtsato.bookstore.dataprovider.document.domain.QDocumentEntity;
import io.github.jtsato.bookstore.dataprovider.document.mapper.DocumentMapper;
import io.github.jtsato.bookstore.dataprovider.document.repository.DocumentRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindDocumentsByIdsDataProvider implements FindDocumentsByIdsGateway {

    private final DocumentMapper documentMapper = Mappers.getMapper(DocumentMapper.class);
    private final PageMapper<Document, DocumentEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Page<Document> execute(final List<Long> ids) {

        final BooleanExpression predicate = QDocumentEntity.documentEntity.id.in(ids);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "id:asc");
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead", "type");
        final org.springframework.data.domain.Page<DocumentEntity> page = documentRepository.findAll(predicate, pageRequest, entityGraph);
    
        return pageMapper.of(page, documentMapper::of);
    }
}
