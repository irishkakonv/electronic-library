package com.lobanova.electroniclibrary.entities;

import com.lobanova.electroniclibrary.enums.UserType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(exclude = "comments", callSuper = true)
@ToString
public class User extends Person {

    @Column(name = "login", nullable = false)
    private String userLogin;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserType type;

    @OneToMany(mappedBy = "authorComment", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Comment> comments;
}
