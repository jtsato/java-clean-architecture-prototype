package io.github.jtsato.bookstore.dataprovider.country;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.RegisterCountryGateway;
import io.github.jtsato.bookstore.dataprovider.country.domain.CountryEntity;
import io.github.jtsato.bookstore.dataprovider.country.mapper.CountryMapper;
import io.github.jtsato.bookstore.dataprovider.country.repository.CountryRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class RegisterCountryDataProvider implements RegisterCountryGateway {

    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);
    
    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country execute(final Country country) {
        final CountryEntity countryEntity = countryMapper.of(country);
        return countryMapper.of(countryRepository.saveAndFlush(countryEntity));
    }
}
