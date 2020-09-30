package io.github.jtsato.bookstore.entrypoint.rest.document.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.SearchDocumentsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.SearchDocumentsLeadResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.SearchDocumentsTypeResponse;

import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.SearchDocumentsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchDocumentsPresenter {

    public static SearchDocumentsWrapperResponse of(final Page<Document> page) {
        final List<Document> documents = page.getContent();
        final List<SearchDocumentsResponse> content = new ArrayList<>(documents.size());
        documents.forEach(element -> content.add(of(element)));
        return new SearchDocumentsWrapperResponse(content, page.getPageable());
    }


    public static SearchDocumentsResponse of(final Document document) {
        return new SearchDocumentsResponse(document.getId(),
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

    public static SearchDocumentsLeadResponse of(final Lead lead) {
        return new SearchDocumentsLeadResponse(lead.getId(),
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

    public static SearchDocumentsTypeResponse of(final DocumentType documentType) {
        return new SearchDocumentsTypeResponse(documentType.getId(),
                                               documentType.getCountry(),
                                               documentType.getDescription(),
                                               documentType.getCreatedDateTime(),
                                               documentType.getLastModifiedDateTime());
    }
}
