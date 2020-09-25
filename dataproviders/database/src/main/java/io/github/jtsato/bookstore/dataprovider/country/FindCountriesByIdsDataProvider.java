package io.github.jtsato.bookstore.dataprovider.country;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.FindCountriesByIdsGateway;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.country.domain.CountryEntity;
import io.github.jtsato.bookstore.dataprovider.country.domain.QCountryEntity;
import io.github.jtsato.bookstore.dataprovider.country.mapper.CountryMapper;
import io.github.jtsato.bookstore.dataprovider.country.repository.CountryRepository;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class FindCountriesByIdsDataProvider implements FindCountriesByIdsGateway {

    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);
    private final PageMapper<Country, CountryEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Page<Country> execute(final List<Long> ids) {

        final BooleanExpression predicate = QCountryEntity.countryEntity.id.in(ids);
        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(0, 1000, "id:asc");
        final org.springframework.data.domain.Page<CountryEntity> page = countryRepository.findAll(predicate, pageRequest);
    
        return pageMapper.of(page, countryMapper::of);
    }
}
