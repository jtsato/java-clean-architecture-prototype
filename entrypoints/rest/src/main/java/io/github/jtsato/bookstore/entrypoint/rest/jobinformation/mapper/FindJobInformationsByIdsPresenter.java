package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.lead.domain.Lead;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.FindJobInformationsByIdsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.FindJobInformationsByIdsLeadResponse;

import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.FindJobInformationsByIdsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindJobInformationsByIdsPresenter {

    public static FindJobInformationsByIdsWrapperResponse of(final Page<JobInformation> page) {
        final List<JobInformation> jobInformations = page.getContent();
        final List<FindJobInformationsByIdsResponse> content = new ArrayList<>(jobInformations.size());
        jobInformations.forEach(element -> content.add(of(element)));
        return new FindJobInformationsByIdsWrapperResponse(content, page.getPageable());
    }


    public static FindJobInformationsByIdsResponse of(final JobInformation jobInformation) {
        return new FindJobInformationsByIdsResponse(jobInformation.getId(),
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

    public static FindJobInformationsByIdsLeadResponse of(final Lead lead) {
        return new FindJobInformationsByIdsLeadResponse(lead.getId(),
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
