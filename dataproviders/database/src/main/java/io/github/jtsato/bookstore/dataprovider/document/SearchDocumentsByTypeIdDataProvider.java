package io.github.jtsato.bookstore.dataprovider.document;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.gateway.SearchDocumentsByTypeIdGateway;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.document.domain.DocumentEntity;
import io.github.jtsato.bookstore.dataprovider.document.mapper.DocumentMapper;
import io.github.jtsato.bookstore.dataprovider.document.repository.DocumentRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchDocumentsByTypeIdDataProvider implements SearchDocumentsByTypeIdGateway {
    
	private final DocumentMapper documentMapper = Mappers.getMapper(DocumentMapper.class);
    private final PageMapper<Document, DocumentEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Page<Document> execute(final Long typeId, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
    	
        final EntityGraph entityGraph = EntityGraphUtils.fromAttributePaths("lead", "type");
        final org.springframework.data.domain.Page<DocumentEntity> page = documentRepository.findByTypeId(typeId, entityGraph, pageRequest);

        return pageMapper.of(page, documentMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "number:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}
