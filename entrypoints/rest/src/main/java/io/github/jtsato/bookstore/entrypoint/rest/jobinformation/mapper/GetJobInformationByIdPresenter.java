package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.mapper;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.lead.domain.Lead;

import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.GetJobInformationByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.GetJobInformationByIdLeadResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetJobInformationByIdPresenter {


    public static GetJobInformationByIdResponse of(final JobInformation jobInformation) {
        return new GetJobInformationByIdResponse(jobInformation.getId(),
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

    public static GetJobInformationByIdLeadResponse of(final Lead lead) {
        return new GetJobInformationByIdLeadResponse(lead.getId(),
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
