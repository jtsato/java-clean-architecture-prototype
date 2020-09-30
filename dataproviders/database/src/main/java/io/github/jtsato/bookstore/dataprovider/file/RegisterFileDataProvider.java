package io.github.jtsato.bookstore.dataprovider.file;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.RegisterFileGateway;
import io.github.jtsato.bookstore.dataprovider.file.domain.FileEntity;
import io.github.jtsato.bookstore.dataprovider.file.mapper.FileMapper;
import io.github.jtsato.bookstore.dataprovider.file.repository.FileRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterFileDataProvider implements RegisterFileGateway {

    private final FileMapper fileMapper = Mappers.getMapper(FileMapper.class);
    
    @Autowired
    FileRepository fileRepository;

    @Override
    public File execute(final File file) {
        final FileEntity fileEntity = fileMapper.of(file);
        return fileMapper.of(fileRepository.saveAndFlush(fileEntity));
    }
}
