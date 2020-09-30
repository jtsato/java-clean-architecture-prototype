package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.mapper;

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.lead.domain.Lead;

import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.RegisterJobInformationResponse;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.RegisterJobInformationLeadResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegisterJobInformationPresenter {


    public static RegisterJobInformationResponse of(final JobInformation jobInformation) {
        return new RegisterJobInformationResponse(jobInformation.getId(),
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

    public static RegisterJobInformationLeadResponse of(final Lead lead) {
        return new RegisterJobInformationLeadResponse(lead.getId(),
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
