package io.github.jtsato.bookstore.dataprovider.country;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.UpdateCountryByIdGateway;
import io.github.jtsato.bookstore.dataprovider.country.domain.CountryEntity;
import io.github.jtsato.bookstore.dataprovider.country.mapper.CountryMapper;
import io.github.jtsato.bookstore.dataprovider.country.repository.CountryRepository;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional
@Service
public class UpdateCountryByIdDataProvider implements UpdateCountryByIdGateway {

    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Optional<Country> execute(final Country country) {

        final Optional<CountryEntity> optional = countryRepository.findById(country.getId());

        return optional.map(countryEntity -> updateCountryEntity(countryEntity, country));
    }

    private Country updateCountryEntity(final CountryEntity countryEntity, final Country country) {
        countryEntity.setName(country.getName());
        return countryMapper.of(countryRepository.saveAndFlush(countryEntity));
    }
}
