package io.github.jtsato.bookstore.dataprovider.country.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "COUNTRIES",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"NAME"}, name = "UN_COUNTRIES_NAME"),
       })
public class CountryEntity implements Serializable {

    private static final long serialVersionUID = 543820893840229466L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID", updatable = false, insertable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;
}
