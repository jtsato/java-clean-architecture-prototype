package io.github.jtsato.bookstore.dataprovider.file;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.core.file.gateway.UpdateFileByIdGateway;
import io.github.jtsato.bookstore.dataprovider.file.domain.FileEntity;
import io.github.jtsato.bookstore.dataprovider.file.mapper.FileMapper;
import io.github.jtsato.bookstore.dataprovider.file.repository.FileRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateFileByIdDataProvider implements UpdateFileByIdGateway {

    private final FileMapper fileMapper = Mappers.getMapper(FileMapper.class);

    @Autowired
    FileRepository fileRepository;

    @Override
    public Optional<File> execute(final File file) {

        final Optional<FileEntity> optional = fileRepository.findById(file.getId());

        return optional.map(fileEntity -> updateFileEntity(fileEntity, file));
    }

    private File updateFileEntity(final FileEntity fileEntity, final File file) {
        fileEntity.setContentType(file.getContentType());
        fileEntity.setExtension(file.getExtension());
        fileEntity.setName(file.getName());
        fileEntity.setSize(file.getSize());
        fileEntity.setContent(file.getContent());
        fileEntity.setUrl(file.getUrl());
        fileEntity.setCreationDate(file.getCreationDate());
        fileEntity.setLastModifiedDate(file.getLastModifiedDate());
        return fileMapper.of(fileRepository.saveAndFlush(fileEntity));
    }
}
