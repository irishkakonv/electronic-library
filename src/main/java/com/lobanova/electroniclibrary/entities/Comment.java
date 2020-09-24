package com.lobanova.electroniclibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private int id;
    private int rate;
    private String content;
    private User author;
    private String data;
    private Book book;

}
