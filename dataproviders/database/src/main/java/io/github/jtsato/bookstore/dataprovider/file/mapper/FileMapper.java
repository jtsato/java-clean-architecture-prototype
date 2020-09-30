package io.github.jtsato.bookstore.dataprovider.file.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.file.domain.File;
import io.github.jtsato.bookstore.dataprovider.file.domain.FileEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper
public interface FileMapper {

    File of(final FileEntity fileEntity);

    FileEntity of(final File file);
}
