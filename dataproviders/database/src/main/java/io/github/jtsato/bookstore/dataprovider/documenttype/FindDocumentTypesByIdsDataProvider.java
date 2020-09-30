package io.github.jtsato.bookstore.dataprovider.documenttype;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.FindDocumentTypesByIdsGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.DocumentTypeEntity;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.QDocumentTypeEntity;
import io.github.jtsato.bookstore.dataprovider.documenttype.mapper.DocumentTypeMapper;
import io.github.jtsato.bookstore.dataprovider.documenttype.repository.DocumentTypeRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindDocumentTypesByIdsDataProvider implements FindDocumentTypesByIdsGateway {

    private final DocumentTypeMapper documentTypeMapper = Mappers.getMapper(DocumentTypeMapper.class);
    private final PageMapper<DocumentType, DocumentTypeEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public Page<DocumentType> execute(final List<Long> ids) {

        final BooleanExpression predicate = QDocumentTypeEntity.documentTypeEntity.id.in(ids);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "id:asc");
        final org.springframework.data.domain.Page<DocumentTypeEntity> page = documentTypeRepository.findAll(predicate, pageRequest);
    
        return pageMapper.of(page, documentTypeMapper::of);
    }
}
