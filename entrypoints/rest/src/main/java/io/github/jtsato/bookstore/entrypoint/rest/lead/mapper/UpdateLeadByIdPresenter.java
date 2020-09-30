package io.github.jtsato.bookstore.entrypoint.rest.lead.mapper;

import io.github.jtsato.bookstore.core.lead.domain.Lead;

import io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response.UpdateLeadByIdResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateLeadByIdPresenter {


    public static UpdateLeadByIdResponse of(final Lead lead) {
        return new UpdateLeadByIdResponse(lead.getId(),
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
