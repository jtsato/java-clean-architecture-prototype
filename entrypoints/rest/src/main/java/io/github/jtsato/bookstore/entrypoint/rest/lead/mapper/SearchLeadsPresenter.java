package io.github.jtsato.bookstore.entrypoint.rest.lead.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.lead.domain.Lead;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response.SearchLeadsResponse;

import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response.SearchLeadsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchLeadsPresenter {

    public static SearchLeadsWrapperResponse of(final Page<Lead> page) {
        final List<Lead> leads = page.getContent();
        final List<SearchLeadsResponse> content = new ArrayList<>(leads.size());
        leads.forEach(element -> content.add(of(element)));
        return new SearchLeadsWrapperResponse(content, page.getPageable());
    }


    public static SearchLeadsResponse of(final Lead lead) {
        return new SearchLeadsResponse(lead.getId(),
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
}
