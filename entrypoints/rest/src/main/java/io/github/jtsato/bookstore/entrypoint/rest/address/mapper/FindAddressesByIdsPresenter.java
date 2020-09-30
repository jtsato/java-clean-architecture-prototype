package io.github.jtsato.bookstore.entrypoint.rest.address.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.jtsato.bookstore.core.address.domain.Address;
import io.github.jtsato.bookstore.core.lead.domain.Lead;

import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.FindAddressesByIdsResponse;
import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.FindAddressesByIdsLeadResponse;

import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.FindAddressesByIdsWrapperResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FindAddressesByIdsPresenter {

    public static FindAddressesByIdsWrapperResponse of(final Page<Address> page) {
        final List<Address> addresses = page.getContent();
        final List<FindAddressesByIdsResponse> content = new ArrayList<>(addresses.size());
        addresses.forEach(element -> content.add(of(element)));
        return new FindAddressesByIdsWrapperResponse(content, page.getPageable());
    }


    public static FindAddressesByIdsResponse of(final Address address) {
        return new FindAddressesByIdsResponse(address.getId(),
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

    public static FindAddressesByIdsLeadResponse of(final Lead lead) {
        return new FindAddressesByIdsLeadResponse(lead.getId(),
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
