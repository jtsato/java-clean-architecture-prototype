package io.github.jtsato.bookstore.dataprovider.file.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
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
@Table(name = "FILES",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = {"NAME"}, name = "UN_FILES_NAME"),
       },       indexes = {
            @Index(columnList = "CREATION_DATE", name = "IDX_FILES_CREATION_DATE"),
            @Index(columnList = "LAST_MODIFIED_DATE", name = "IDX_FILES_LAST_MODIFIED_DATE"),
       }
)
public class FileEntity implements Serializable {

    private static final long serialVersionUID = -2993716055764677845L;
    
    @Access(AccessType.PROPERTY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_ID", updatable = false, insertable = false)
    private Long id;

    @Column(name = "CONTENT_TYPE", nullable = false)
    private String contentType;

    @Column(name = "EXTENSION", nullable = false)
    private String extension;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SIZE", nullable = false)
    private Long size;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "URL", nullable = false)
    private String url;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDate lastModifiedDate;

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
        final FileEntity other = (FileEntity) obj;
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
        builder.append("File [id=");
        builder.append(id);
        builder.append(", contentType=");
        builder.append(contentType);
        builder.append(", extension=");
        builder.append(extension);
        builder.append(", name=");
        builder.append(name);
        builder.append(", size=");
        builder.append(size);
        builder.append(", content=");
        builder.append(content);
        builder.append(", url=");
        builder.append(url);
        builder.append(", creationDate=");
        builder.append(creationDate);
        builder.append(", lastModifiedDate=");
        builder.append(lastModifiedDate);
        builder.append("]");
        return builder.toString();
    }
}
