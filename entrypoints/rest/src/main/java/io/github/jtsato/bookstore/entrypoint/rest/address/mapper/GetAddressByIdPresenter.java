package io.github.jtsato.bookstore.entrypoint.rest.address.mapper;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.lead.domain.Lead;

import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.GetAddressByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.GetAddressByIdLeadResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetAddressByIdPresenter {


    public static GetAddressByIdResponse of(final Address address) {
        return new GetAddressByIdResponse(address.getId(),
                                       of(address.getLead()),
                                          address.getZipCode(),
                                          address.getCity(),
                                          address.getState(),
                                          address.getCountry(),
                                          address.getDescription(),
                                          address.getComplement(),
                                          address.getNumber(),
                                          address.getType().name(),
                                          address.getCreatedDateTime(),
                                          address.getLastModifiedDateTime());
    }

    public static GetAddressByIdLeadResponse of(final Lead lead) {
        return new GetAddressByIdLeadResponse(lead.getId(),
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
