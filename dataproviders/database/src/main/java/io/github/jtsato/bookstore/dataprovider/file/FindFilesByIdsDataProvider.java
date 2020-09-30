package io.github.jtsato.bookstore.dataprovider.file;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.FindFilesByIdsGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.file.domain.FileEntity;
import io.github.jtsato.bookstore.dataprovider.file.domain.QFileEntity;
import io.github.jtsato.bookstore.dataprovider.file.mapper.FileMapper;
import io.github.jtsato.bookstore.dataprovider.file.repository.FileRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindFilesByIdsDataProvider implements FindFilesByIdsGateway {

    private final FileMapper fileMapper = Mappers.getMapper(FileMapper.class);
    private final PageMapper<File, FileEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    FileRepository fileRepository;

    @Override
    public Page<File> execute(final List<Long> ids) {

        final BooleanExpression predicate = QFileEntity.fileEntity.id.in(ids);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "id:asc");
        final org.springframework.data.domain.Page<FileEntity> page = fileRepository.findAll(predicate, pageRequest);
    
        return pageMapper.of(page, fileMapper::of);
    }
}
