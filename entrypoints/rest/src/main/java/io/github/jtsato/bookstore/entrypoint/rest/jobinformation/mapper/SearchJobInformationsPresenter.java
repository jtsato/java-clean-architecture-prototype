package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.lead.domain.Lead;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.SearchJobInformationsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.SearchJobInformationsLeadResponse;

import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.SearchJobInformationsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SearchJobInformationsPresenter {

    public static SearchJobInformationsWrapperResponse of(final Page<JobInformation> page) {
        final List<JobInformation> jobInformations = page.getContent();
        final List<SearchJobInformationsResponse> content = new ArrayList<>(jobInformations.size());
        jobInformations.forEach(element -> content.add(of(element)));
        return new SearchJobInformationsWrapperResponse(content, page.getPageable());
    }


    public static SearchJobInformationsResponse of(final JobInformation jobInformation) {
        return new SearchJobInformationsResponse(jobInformation.getId(),
                                              of(jobInformation.getLead()),
                                                 jobInformation.getAttach(),
                                                 jobInformation.getProfession(),
                                                 jobInformation.getReferenceMonth(),
                                                 jobInformation.getReceiptType().name(),
                                                 jobInformation.getStartDate(),
                                                 jobInformation.getCreatedDateTime(),
                                                 jobInformation.getLastModifiedDateTime(),
                                                 jobInformation.getMonthlyIncome());
    }

    public static SearchJobInformationsLeadResponse of(final Lead lead) {
        return new SearchJobInformationsLeadResponse(lead.getId(),
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
