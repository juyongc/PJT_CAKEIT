package cakeit.server.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "FILE")
public class FileEntity extends AbstractEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_ID")
    private Long fileId;

    //@Column(name = "TITLE")
    private String title;

    //@Column(name = "S3_URL")
    private String s3Url;

    public FileEntity(String title, String s3Url) {
        this.title = title;
        this.s3Url = s3Url;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "fileId=" + fileId +
                ", title='" + title + '\'' +
                ", s3Url='" + s3Url + '\'' +
                '}';
    }
}
