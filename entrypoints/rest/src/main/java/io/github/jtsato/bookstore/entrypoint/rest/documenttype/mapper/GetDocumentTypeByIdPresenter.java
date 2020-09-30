package io.github.jtsato.bookstore.entrypoint.rest.documenttype.mapper;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.GetDocumentTypeByIdResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetDocumentTypeByIdPresenter {


    public static GetDocumentTypeByIdResponse of(final DocumentType documentType) {
        return new GetDocumentTypeByIdResponse(documentType.getId(),
                                               documentType.getCountry(),
                                               documentType.getDescription(),
                                               documentType.getCreatedDateTime(),
                                               documentType.getLastModifiedDateTime());
    }
}
