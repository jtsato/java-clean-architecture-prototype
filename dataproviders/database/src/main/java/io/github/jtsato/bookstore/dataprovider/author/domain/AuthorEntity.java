package io.github.jtsato.bookstore.dataprovider.author.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.github.jtsato.bookstore.dataprovider.country.domain.CountryEntity;
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
            @UniqueConstraint(columnNames = {"NAME"}, name = "UN_AUTHORS_NAME"),
       },       indexes = {
            @Index(columnList = "COUNTRY_ID", name = "IDX_AUTHORS_COUNTRY_ID"),
            @Index(columnList = "GENDER", name = "IDX_AUTHORS_GENDER"),
            @Index(columnList = "BIRTHDATE", name = "IDX_AUTHORS_BIRTHDATE"),
       }
)
public class AuthorEntity implements Serializable {

    private static final long serialVersionUID = -932492912745886847L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID", updatable = false, insertable = false)
    private Long id;

    @JoinColumn(name = "COUNTRY_ID", foreignKey = @ForeignKey(name = "FK_AUTHORS_COUNTRY_ID"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CountryEntity country;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;
}
