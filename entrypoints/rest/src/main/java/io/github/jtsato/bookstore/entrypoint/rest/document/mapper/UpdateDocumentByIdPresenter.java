package io.github.jtsato.bookstore.entrypoint.rest.document.mapper;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.UpdateDocumentByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.UpdateDocumentByIdLeadResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.UpdateDocumentByIdTypeResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateDocumentByIdPresenter {


    public static UpdateDocumentByIdResponse of(final Document document) {
        return new UpdateDocumentByIdResponse(document.getId(),
                                           of(document.getLead()),
                                           of(document.getType()),
                                              document.getFrontPhoto(),
                                              document.getBackPhoto(),
                                              document.getNumber(),
                                              document.getIssuer(),
                                              document.getState(),
                                              document.getIssueDate(),
                                              document.getCreatedDateTime(),
                                              document.getLastModifiedDateTime());
    }

    public static UpdateDocumentByIdLeadResponse of(final Lead lead) {
        return new UpdateDocumentByIdLeadResponse(lead.getId(),
                                                  lead.getSelfiePhoto(),
                                                  lead.getCpf(),
                                                  lead.getCellphone(),
                                                  lead.getName(),
                                                  lead.getMotherFullName(),
                                                  lead.getGender().name(),
                                                  lead.getEducation().name(),
                                                  lead.getMaritalStatus().name(),
                                                  lead.getStableUnion(),
                                                  lead.getBirthdate(),
                                                  lead.getCreatedDateTime(),
                                                  lead.getLastModifiedDateTime());
    }

    public static UpdateDocumentByIdTypeResponse of(final DocumentType documentType) {
        return new UpdateDocumentByIdTypeResponse(documentType.getId(),
                                                  documentType.getCountry(),
                                                  documentType.getDescription(),
                                                  documentType.getCreatedDateTime(),
                                                  documentType.getLastModifiedDateTime());
    }
}
