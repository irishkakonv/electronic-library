package com.lobanova.electroniclibrary.entities;

import com.lobanova.electroniclibrary.enums.Genre;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Setter
@Getter
@EqualsAndHashCode(exclude = {"authors", "description", "content", "image", "comments"}, callSuper = true)
public class Book extends EntityBase {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private Set<Author> authors = new HashSet<>();

    @Column(name = "genre", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(name = "description")
    private String description;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "content")
    private byte[] content;

    @Column(name = "image")
    private byte[] image;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();

}
