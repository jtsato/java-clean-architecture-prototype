package io.github.jtsato.bookstore.entrypoint.rest.documenttype.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.FindDocumentTypesByIdsResponse;

import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.FindDocumentTypesByIdsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindDocumentTypesByIdsPresenter {

    public static FindDocumentTypesByIdsWrapperResponse of(final Page<DocumentType> page) {
        final List<DocumentType> documentTypes = page.getContent();
        final List<FindDocumentTypesByIdsResponse> content = new ArrayList<>(documentTypes.size());
        documentTypes.forEach(element -> content.add(of(element)));
        return new FindDocumentTypesByIdsWrapperResponse(content, page.getPageable());
    }


    public static FindDocumentTypesByIdsResponse of(final DocumentType documentType) {
        return new FindDocumentTypesByIdsResponse(documentType.getId(),
                                                  documentType.getCountry(),
                                                  documentType.getDescription(),
                                                  documentType.getCreatedDateTime(),
                                                  documentType.getLastModifiedDateTime());
    }
}
