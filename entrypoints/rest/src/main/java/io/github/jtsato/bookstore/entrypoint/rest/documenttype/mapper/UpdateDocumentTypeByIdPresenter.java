package io.github.jtsato.bookstore.entrypoint.rest.documenttype.mapper;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.UpdateDocumentTypeByIdResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateDocumentTypeByIdPresenter {


    public static UpdateDocumentTypeByIdResponse of(final DocumentType documentType) {
        return new UpdateDocumentTypeByIdResponse(documentType.getId(),
                                                  documentType.getCountry(),
                                                  documentType.getDescription(),
                                                  documentType.getCreatedDateTime(),
                                                  documentType.getLastModifiedDateTime());
    }
}
