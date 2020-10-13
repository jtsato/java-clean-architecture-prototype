package io.github.jtsato.bookstore.core.enumerator.usecase.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import io.github.jtsato.bookstore.core.address.domain.PropertyType;
import io.github.jtsato.bookstore.core.balance.domain.Currency;
import io.github.jtsato.bookstore.core.balance.domain.ResourceOrigin;
import io.github.jtsato.bookstore.core.jobinformation.domain.ReceiptType;
import io.github.jtsato.bookstore.core.lead.domain.Gender;
import io.github.jtsato.bookstore.core.lead.domain.Education;
import io.github.jtsato.bookstore.core.lead.domain.MaritalStatus;
import io.github.jtsato.bookstore.core.enumerator.domain.Enumerator;
import io.github.jtsato.bookstore.core.enumerator.usecase.SearchEnumeratorsUseCase;
import io.github.jtsato.bookstore.core.enumerator.usecase.parameter.SearchEnumeratorsParameters;
import lombok.RequiredArgsConstructor;

/*
 * A Use Case follows these steps:
 * - Takes input
 * - Validates business rules
 * - Manipulates the model state
 * - Returns output
 */

/**
 * @author Jorge Takeshi Sato
 */

@Named
@RequiredArgsConstructor
public class SearchEnumeratorsUseCaseImpl implements SearchEnumeratorsUseCase {

    @Override
    public List<Enumerator> execute(final SearchEnumeratorsParameters parameters) {
        final Predicate<? super Enumerator> filter = enumerator -> compare(enumerator, parameters.getDomain(), parameters.getKey());
        return getAllEnumerators().stream().filter(filter).collect(Collectors.toList());
    }

    private boolean compare(final Enumerator enumerator, final String domain, final String key) {
        final boolean domainNotProvidedOrSameDomain = StringUtils.isBlank(domain) || enumerator.getDomain().equalsIgnoreCase(domain);
        final boolean keyNotProvidedOrSameKey = StringUtils.isBlank(key) || enumerator.getKey().equalsIgnoreCase(key);
        return domainNotProvidedOrSameDomain && keyNotProvidedOrSameKey;
    }

    private List<Enumerator> getAllEnumerators() {
        final List<Enumerator> enumerators = new ArrayList<>(0);
        enumerators.addAll(Arrays.asList(Currency.values()).stream().map(this::buildEnumerator).collect(Collectors.toList()));
        enumerators.addAll(Arrays.asList(Education.values()).stream().map(this::buildEnumerator).collect(Collectors.toList()));
        enumerators.addAll(Arrays.asList(Gender.values()).stream().map(this::buildEnumerator).collect(Collectors.toList()));
        enumerators.addAll(Arrays.asList(MaritalStatus.values()).stream().map(this::buildEnumerator).collect(Collectors.toList()));
        enumerators.addAll(Arrays.asList(PropertyType.values()).stream().map(this::buildEnumerator).collect(Collectors.toList()));
        enumerators.addAll(Arrays.asList(ReceiptType.values()).stream().map(this::buildEnumerator).collect(Collectors.toList()));
        enumerators.addAll(Arrays.asList(ResourceOrigin.values()).stream().map(this::buildEnumerator).collect(Collectors.toList()));
        return enumerators;
    }

    private Enumerator buildEnumerator(final Currency enumerator) {
        return new Enumerator("Currency", enumerator.name(), enumerator.getMessageKey());
    }

    private Enumerator buildEnumerator(final Education enumerator) {
        return new Enumerator("Education", enumerator.name(), enumerator.getMessageKey());
    }

    private Enumerator buildEnumerator(final Gender enumerator) {
        return new Enumerator("Gender", enumerator.name(), enumerator.getMessageKey());
    }

    private Enumerator buildEnumerator(final MaritalStatus enumerator) {
        return new Enumerator("MaritalStatus", enumerator.name(), enumerator.getMessageKey());
    }

    private Enumerator buildEnumerator(final PropertyType enumerator) {
        return new Enumerator("PropertyType", enumerator.name(), enumerator.getMessageKey());
    }

    private Enumerator buildEnumerator(final ReceiptType enumerator) {
        return new Enumerator("ReceiptType", enumerator.name(), enumerator.getMessageKey());
    }

    private Enumerator buildEnumerator(final ResourceOrigin enumerator) {
        return new Enumerator("ResourceOrigin", enumerator.name(), enumerator.getMessageKey());
    }
}