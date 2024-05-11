package t3h.manga.mangaweb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "manga")
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MangaID;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String thumbnailImg;
    @ManyToOne
    @JoinColumn(name = "author_id",nullable = true)
    private Author author;

    @ManyToMany // Một manga có thể có nhiều tag và một tag có thể được gắn cho nhiều manga
    @JoinTable(
            name = "manga_tag",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> listTag;

    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL) // Một manga có thể có nhiều chapter
    private List<Chapter> chapterList;
    private LocalDate createdAt;
    private LocalDate updateAt;
    public void addTag(Tag tag) {
        if (listTag == null) {
            listTag = new ArrayList<>();
        }
        listTag.add(tag);
    }
    public void addChapter(Chapter chapter) {
        if (chapterList == null) {
            chapterList = new ArrayList<>();
        }
        chapterList.add(chapter);
    }
}
