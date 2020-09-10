package io.github.jtsato.bookstore.dataprovider.author.mapper;

import io.github.jtsato.bookstore.core.author.domain.Author;
import io.github.jtsato.bookstore.core.author.domain.Gender;
import io.github.jtsato.bookstore.dataprovider.author.domain.AuthorEntity;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-10T02:04:56-0300",
    comments = "version: 1.4.0.Beta3, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 11.0.7 (GraalVM Community)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author of(AuthorEntity authorEntity) {
        if ( authorEntity == null ) {
            return null;
        }

        Long id = null;
        Gender gender = null;
        String name = null;
        LocalDate birthdate = null;

        id = authorEntity.getId();
        if ( authorEntity.getGender() != null ) {
            gender = Enum.valueOf( Gender.class, authorEntity.getGender() );
        }
        name = authorEntity.getName();
        birthdate = authorEntity.getBirthdate();

        Author author = new Author( id, gender, name, birthdate );

        return author;
    }

    @Override
    public AuthorEntity of(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorEntity authorEntity = new AuthorEntity();

        authorEntity.setBirthdate( author.getBirthdate() );
        if ( author.getGender() != null ) {
            authorEntity.setGender( author.getGender().name() );
        }
        authorEntity.setId( author.getId() );
        authorEntity.setName( author.getName() );

        return authorEntity;
    }
}
