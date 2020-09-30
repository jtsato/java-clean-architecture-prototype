package io.github.jtsato.bookstore.dataprovider.file.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import io.github.jtsato.bookstore.core.file.usecase.parameter.SearchFilesParameters;
import io.github.jtsato.bookstore.dataprovider.file.domain.QFileEntity;
import io.github.jtsato.bookstore.dataprovider.common.predicate.AbstractPredicateBuilderImpl;

/**
 * @author Jorge Takeshi Sato
 */

public class SearchFilesPredicateBuilder extends AbstractPredicateBuilderImpl<QFileEntity, SearchFilesParameters> {

    public SearchFilesPredicateBuilder(final QFileEntity entityPath) {
        super(entityPath);
    }

    @Override
    public List<BooleanExpression> buildBooleanExpressions(final SearchFilesParameters query) {

        final List<BooleanExpression> booleanExpressions = new LinkedList<>();

        if (query.getId() != null) {
            booleanExpressions.add(entityPath.id.eq(query.getId()));
        }

        if (query.getStartSize() != null) {
            booleanExpressions.add(entityPath.size.goe(query.getStartSize()));
        }

        if (query.getEndSize() != null) {
            booleanExpressions.add(entityPath.size.loe(query.getEndSize()));
        }

        if (StringUtils.isNotBlank(query.getContentType())) {
            booleanExpressions.add(entityPath.contentType.like(addLikeOperator(query.getContentType())));
        }

        if (StringUtils.isNotBlank(query.getExtension())) {
            booleanExpressions.add(entityPath.extension.like(addLikeOperator(query.getExtension())));
        }

        if (StringUtils.isNotBlank(query.getName())) {
            booleanExpressions.add(entityPath.name.like(addLikeOperator(query.getName())));
        }

        if (StringUtils.isNotBlank(query.getContent())) {
            booleanExpressions.add(entityPath.content.like(addLikeOperator(query.getContent())));
        }

        if (StringUtils.isNotBlank(query.getUrl())) {
            booleanExpressions.add(entityPath.url.like(addLikeOperator(query.getUrl())));
        }

        if (StringUtils.isNotBlank(query.getStartCreationDate())) {
            final LocalDate startCreationDate = LocalDate.parse(query.getStartCreationDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.creationDate.goe(startCreationDate));
        }

        if (StringUtils.isNotBlank(query.getEndCreationDate())) {
            final LocalDate endCreationDate = LocalDate.parse(query.getEndCreationDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.creationDate.loe(endCreationDate));
        }

        if (StringUtils.isNotBlank(query.getStartLastModifiedDate())) {
            final LocalDate startLastModifiedDate = LocalDate.parse(query.getStartLastModifiedDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.lastModifiedDate.goe(startLastModifiedDate));
        }

        if (StringUtils.isNotBlank(query.getEndLastModifiedDate())) {
            final LocalDate endLastModifiedDate = LocalDate.parse(query.getEndLastModifiedDate(), DateTimeFormatter.ISO_DATE);
            booleanExpressions.add(entityPath.lastModifiedDate.loe(endLastModifiedDate));
        }

        return booleanExpressions;
    }
}
