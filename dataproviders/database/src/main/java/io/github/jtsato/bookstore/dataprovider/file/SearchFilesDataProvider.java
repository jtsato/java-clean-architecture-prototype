package io.github.jtsato.bookstore.dataprovider.file;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.SearchFilesGateway;
import io.github.jtsato.bookstore.core.file.usecase.parameter.SearchFilesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.file.domain.FileEntity;
import io.github.jtsato.bookstore.dataprovider.file.domain.QFileEntity;
import io.github.jtsato.bookstore.dataprovider.file.mapper.FileMapper;
import io.github.jtsato.bookstore.dataprovider.file.repository.FileRepository;
import io.github.jtsato.bookstore.dataprovider.file.repository.SearchFilesPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchFilesDataProvider implements SearchFilesGateway {
    
    private final FileMapper fileMapper = Mappers.getMapper(FileMapper.class);
    private final PageMapper<File, FileEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    FileRepository fileRepository;

    @Override
    public Page<File> execute(final SearchFilesParameters parameters, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
        final BooleanBuilder predicate = new SearchFilesPredicateBuilder(QFileEntity.fileEntity).buildBooleanBuilder(parameters);
        final org.springframework.data.domain.Page<FileEntity> page = fileRepository.findAll(predicate, pageRequest);

        return pageMapper.of(page, fileMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "contentType:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}
