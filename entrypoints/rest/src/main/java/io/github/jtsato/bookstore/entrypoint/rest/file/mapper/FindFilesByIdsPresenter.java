package io.github.jtsato.bookstore.entrypoint.rest.file.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.file.domain.File;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.response.FindFilesByIdsResponse;

import io.github.jtsato.bookstore.entrypoint.rest.file.domain.response.FindFilesByIdsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindFilesByIdsPresenter {

    public static FindFilesByIdsWrapperResponse of(final Page<File> page) {
        final List<File> files = page.getContent();
        final List<FindFilesByIdsResponse> content = new ArrayList<>(files.size());
        files.forEach(element -> content.add(of(element)));
        return new FindFilesByIdsWrapperResponse(content, page.getPageable());
    }


    public static FindFilesByIdsResponse of(final File file) {
        return new FindFilesByIdsResponse(file.getId(),
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
