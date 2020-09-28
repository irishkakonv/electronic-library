package com.lobanova.electroniclibrary.dtos;

import com.lobanova.electroniclibrary.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
public class CommentDto {

    private Integer id;
    private Integer rate;
    private String content;
    private String data;
    private Book book;

}
