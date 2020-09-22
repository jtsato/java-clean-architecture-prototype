package io.github.jtsato.bookstore.dataprovider.country;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;

import io.github.jtsato.bookstore.core.country.domain.Country;
import io.github.jtsato.bookstore.core.country.gateway.SearchCountriesGateway;
import io.github.jtsato.bookstore.core.country.usecase.parameter.SearchCountriesParameters;
import io.github.jtsato.bookstore.core.common.paging.Page;
import io.github.jtsato.bookstore.dataprovider.country.domain.CountryEntity;
import io.github.jtsato.bookstore.dataprovider.country.domain.QCountryEntity;
import io.github.jtsato.bookstore.dataprovider.country.mapper.CountryMapper;
import io.github.jtsato.bookstore.dataprovider.country.repository.CountryRepository;
import io.github.jtsato.bookstore.dataprovider.country.repository.SearchCountriesPredicateBuilder;
import io.github.jtsato.bookstore.dataprovider.common.PageMapper;
import io.github.jtsato.bookstore.dataprovider.common.PageRequestHelper;

/**
 * @author Jorge Takeshi Sato
 */

@Transactional(readOnly = true)
@Service
public class SearchCountriesDataProvider implements SearchCountriesGateway {
    
    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);
    private final PageMapper<Country, CountryEntity> pageMapper = new PageMapper<>() {};

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Page<Country> execute(final SearchCountriesParameters parameters, final Integer pageNumber, final Integer size, final String orderBy) {

        final PageRequest pageRequest = PageRequestHelper.buildPageRequest(pageNumber, size, sanitizeOrderBy(orderBy));
        final BooleanBuilder predicate = new SearchCountriesPredicateBuilder(QCountryEntity.countryEntity).buildBooleanBuilder(parameters);
        final org.springframework.data.domain.Page<CountryEntity> page = countryRepository.findAll(predicate, pageRequest);

        return pageMapper.of(page, countryMapper::of);
    }

    private String sanitizeOrderBy(final String orderBy) {
        if (StringUtils.isBlank(orderBy) || StringUtils.equalsIgnoreCase(orderBy, "UNSORTED")) {
            return "name:asc";
        }
        return StringUtils.stripToEmpty(orderBy);
    }
}
