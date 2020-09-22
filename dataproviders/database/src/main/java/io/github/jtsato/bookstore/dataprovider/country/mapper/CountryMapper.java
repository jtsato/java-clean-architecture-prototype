package io.github.jtsato.bookstore.dataprovider.country.mapper;

import org.mapstruct.Mapper;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.dataprovider.country.domain.CountryEntity;

/**
 * @author Jorge Takeshi Sato
 */

@Mapper
public interface CountryMapper {

    Country of(final CountryEntity countryEntity);

    CountryEntity of(final Country country);
}
