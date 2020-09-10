package io.github.jtsato.bookstore.dataprovider.author.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato  
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "AUTHORS",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"ID"}, name = "UN_AUTHORS_ID"),
       },
       indexes = {
            @Index(columnList = "ID", name = "IDX_AUTHORS_ID"),
            @Index(columnList = "NAME", name = "IDX_AUTHORS_NAME"),
            @Index(columnList = "GENDER", name = "IDX_AUTHORS_GENDER"),
            @Index(columnList = "BIRTHDATE", name = "IDX_AUTHORS_BIRTHDATE"),
       }
)
public class AuthorEntity implements Serializable {

    private static final long serialVersionUID = -5846745220367235012L;

    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, insertable = false)
    private Long id;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "NAME ", nullable = false)
    private String name;

    @Column(name = "BIRTHDATE ", nullable = false)
    private LocalDate birthdate;
}