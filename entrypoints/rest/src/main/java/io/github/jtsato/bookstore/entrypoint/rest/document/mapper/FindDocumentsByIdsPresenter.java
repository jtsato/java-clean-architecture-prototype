package io.github.jtsato.bookstore.entrypoint.rest.document.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.FindDocumentsByIdsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.FindDocumentsByIdsLeadResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.FindDocumentsByIdsTypeResponse;

import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.FindDocumentsByIdsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindDocumentsByIdsPresenter {

    public static FindDocumentsByIdsWrapperResponse of(final Page<Document> page) {
        final List<Document> documents = page.getContent();
        final List<FindDocumentsByIdsResponse> content = new ArrayList<>(documents.size());
        documents.forEach(element -> content.add(of(element)));
        return new FindDocumentsByIdsWrapperResponse(content, page.getPageable());
    }


    public static FindDocumentsByIdsResponse of(final Document document) {
        return new FindDocumentsByIdsResponse(document.getId(),
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

    public static FindDocumentsByIdsLeadResponse of(final Lead lead) {
        return new FindDocumentsByIdsLeadResponse(lead.getId(),
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

    public static FindDocumentsByIdsTypeResponse of(final DocumentType documentType) {
        return new FindDocumentsByIdsTypeResponse(documentType.getId(),
                                                  documentType.getCountry(),
                                                  documentType.getDescription(),
                                                  documentType.getCreatedDateTime(),
                                                  documentType.getLastModifiedDateTime());
    }
}
