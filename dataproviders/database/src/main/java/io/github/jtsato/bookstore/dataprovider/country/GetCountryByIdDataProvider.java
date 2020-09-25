package io.github.jtsato.bookstore.dataprovider.country;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.GetCountryByIdGateway;
import io.github.jtsato.bookstore.dataprovider.country.domain.CountryEntity;
import io.github.jtsato.bookstore.dataprovider.country.mapper.CountryMapper;
import io.github.jtsato.bookstore.dataprovider.country.repository.CountryRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class GetCountryByIdDataProvider implements GetCountryByIdGateway {

    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);
    
    @Autowired
    CountryRepository countryRepository;

    @Override
    public Optional<Country> execute(final Long id) {
        final Optional<CountryEntity> optional = countryRepository.findById(id);
        return optional.map(countryMapper::of);
    }
}
