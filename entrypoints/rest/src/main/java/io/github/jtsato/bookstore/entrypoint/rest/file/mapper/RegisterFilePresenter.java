package io.github.jtsato.bookstore.entrypoint.rest.file.mapper;

import io.github.jtsato.bookstore.core.file.domain.File;

import io.github.jtsato.bookstore.entrypoint.rest.file.domain.response.RegisterFileResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegisterFilePresenter {


    public static RegisterFileResponse of(final File file) {
        return new RegisterFileResponse(file.getId(),
                                        file.getSize(),
                                        file.getContentType(),
                                        file.getExtension(),
                                        file.getName(),
                                        file.getContent(),
                                        file.getUrl(),
                                        file.getCreationDate(),
                                        file.getLastModifiedDate());
    }
}
