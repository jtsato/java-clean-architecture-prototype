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

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUTHORS",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"NAME"}, name = "UN_AUTHORS_NAME"),
       },       indexes = {
            @Index(columnList = "GENDER", name = "IDX_AUTHORS_GENDER"),
            @Index(columnList = "BIRTHDATE", name = "IDX_AUTHORS_BIRTHDATE"),
       }
)
public class AuthorEntity implements Serializable {

    private static final long serialVersionUID = 4836346242129281897L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID", updatable = false, insertable = false)
    private Long id;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;

    @Override
    public int hashCode() {
        final int prime = 23;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuthorEntity other = (AuthorEntity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Author [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", birthdate=");
        builder.append(birthdate);
        builder.append("]");
        return builder.toString();
    }
}
