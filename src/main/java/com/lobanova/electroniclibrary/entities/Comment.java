package com.lobanova.electroniclibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Integer id;
    private Integer rate;
    private String content;
    private String data;
    private Book book;

}
