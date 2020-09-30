package io.github.jtsato.bookstore.dataprovider.lead.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.lead.domain.Lead;
import io.github.jtsato.bookstore.dataprovider.lead.domain.LeadEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper
public interface LeadMapper {

    Lead of(final LeadEntity leadEntity);

    LeadEntity of(final Lead lead);
}
