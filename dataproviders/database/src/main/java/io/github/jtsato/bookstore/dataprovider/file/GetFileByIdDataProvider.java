package io.github.jtsato.bookstore.dataprovider.file;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.GetFileByIdGateway;
import io.github.jtsato.bookstore.dataprovider.file.domain.FileEntity;
import io.github.jtsato.bookstore.dataprovider.file.mapper.FileMapper;
import io.github.jtsato.bookstore.dataprovider.file.repository.FileRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetFileByIdDataProvider implements GetFileByIdGateway {

    private final FileMapper fileMapper = Mappers.getMapper(FileMapper.class);
    
    @Autowired
    FileRepository fileRepository;

    @Override
    public Optional<File> execute(final Long id) {
        final Optional<FileEntity> optional = fileRepository.findById(id);
        return optional.map(fileMapper::of);
    }
}
