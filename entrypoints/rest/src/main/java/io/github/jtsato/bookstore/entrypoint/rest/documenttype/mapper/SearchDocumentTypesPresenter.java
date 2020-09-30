package io.github.jtsato.bookstore.entrypoint.rest.documenttype.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.SearchDocumentTypesResponse;

import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.SearchDocumentTypesWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchDocumentTypesPresenter {

    public static SearchDocumentTypesWrapperResponse of(final Page<DocumentType> page) {
        final List<DocumentType> documentTypes = page.getContent();
        final List<SearchDocumentTypesResponse> content = new ArrayList<>(documentTypes.size());
        documentTypes.forEach(element -> content.add(of(element)));
        return new SearchDocumentTypesWrapperResponse(content, page.getPageable());
    }


    public static SearchDocumentTypesResponse of(final DocumentType documentType) {
        return new SearchDocumentTypesResponse(documentType.getId(),
                                               documentType.getCountry(),
                                               documentType.getDescription(),
                                               documentType.getCreatedDateTime(),
                                               documentType.getLastModifiedDateTime());
    }
}
