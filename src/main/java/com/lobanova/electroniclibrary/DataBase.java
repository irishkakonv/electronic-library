package com.lobanova.electroniclibrary;

import com.lobanova.electroniclibrary.entities.Address;
import com.lobanova.electroniclibrary.entities.Author;
import com.lobanova.electroniclibrary.entities.Book;
import com.lobanova.electroniclibrary.entities.Comment;
import com.lobanova.electroniclibrary.entities.User;
import com.lobanova.electroniclibrary.enums.Genre;
import com.lobanova.electroniclibrary.enums.PersonType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Address> addresses = new ArrayList<>();
    public static List<Comment> comments = new ArrayList<>();

    static {
        books.add(getCaptainsDaughterBook());
        books.add(getThinkingInJavaBook());
        authors.add(getAleksanderPyshkin());
        authors.add(getBruceEckel());
        users.add(getUser1());
        users.add(getUser2());
        addresses.add(getUser1Address());
        addresses.add(getUser2Address());
        comments.add(Comment.builder().id(1).book(getCaptainsDaughterBook()).content("comment1").rate(5).build());
        comments.add(Comment.builder().id(2).book(getThinkingInJavaBook()).content("comment2").rate(5).build());
    }

    private static Address getUser1Address() {
        return Address.builder().id(1).city("NN").country("Russia").build();
    }

    private static Address getUser2Address() {
        return Address.builder().id(2).city("NN").country("Russia").build();
    }

    private static User getUser1() {
        return User.builder()
                .id(1)
                .name("user1")
                .surname("user1")
                .address(getUser1Address())
                .comments(comments)
                .type(PersonType.USER)
                .address(getUser1Address())
                .build();
    }

    private static User getUser2() {
        return User.builder()
                .id(2)
                .name("admin")
                .surname("admin")
                .address(getUser1Address())
                .type(PersonType.ADMIN)
                .build();
    }

    private static Book getThinkingInJavaBook() {
        return Book.builder()
                .id(1)
                .name("Thinking in Java")
                .pageCount(800)
                .authors(Arrays.asList(getBruceEckel()))
                .genre(Genre.SIENCE)
                .build();
    }

    private static Author getBruceEckel() {
        return Author.builder()
                    .id(1)
                    .name("Eckel")
                    .surname("Bruce")
                    .type(PersonType.AUTHOR).build();
    }

    private static Book getCaptainsDaughterBook() {
        return Book.builder()
                .id(2)
                .name("Captains daughter")
                .pageCount(50)
                .authors(Arrays.asList(getAleksanderPyshkin()))
                .genre(Genre.CLASSIC)
                .build();
    }

    private static Author getAleksanderPyshkin() {
        return Author.builder()
                .id(2)
                .name("Aleksander")
                .surname("Pyshkin")
                .type(PersonType.AUTHOR).build();
    }
}
