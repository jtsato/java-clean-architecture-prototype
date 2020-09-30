package io.github.jtsato.bookstore.dataprovider.documenttype;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.gateway.SearchDocumentTypesGateway;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.SearchDocumentTypesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.DocumentTypeEntity;
import io.github.jtsato.bookstore.dataprovider.documenttype.domain.QDocumentTypeEntity;
import io.github.jtsato.bookstore.dataprovider.documenttype.mapper.DocumentTypeMapper;
import io.github.jtsato.bookstore.dataprovider.documenttype.repository.DocumentTypeRepository;
import io.github.jtsato.bookstore.dataprovider.documenttype.repository.SearchDocumentTypesPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchDocumentTypesDataProvider implements SearchDocumentTypesGateway {
    
    private final DocumentTypeMapper documentTypeMapper = Mappers.getMapper(DocumentTypeMapper.class);
    private final PageMapper<DocumentType, DocumentTypeEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public Page<DocumentType> execute(final SearchDocumentTypesParameters parameters, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
        final BooleanBuilder predicate = new SearchDocumentTypesPredicateBuilder(QDocumentTypeEntity.documentTypeEntity).buildBooleanBuilder(parameters);
        final org.springframework.data.domain.Page<DocumentTypeEntity> page = documentTypeRepository.findAll(predicate, pageRequest);

        return pageMapper.of(page, documentTypeMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "country:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}
