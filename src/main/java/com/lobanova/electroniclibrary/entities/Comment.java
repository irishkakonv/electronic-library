package com.lobanova.electroniclibrary.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "comments")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Comment extends EntityBase {

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @Column(name = "content")
    private String content;

    @Column(name = "data")
    @CreationTimestamp
    private Date data;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User authorComment;
}


