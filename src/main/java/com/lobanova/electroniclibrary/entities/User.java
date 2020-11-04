package com.lobanova.electroniclibrary.entities;

import com.lobanova.electroniclibrary.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(exclude = "comments", callSuper = true)
@ToString
public class User extends Person  {

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CustomUserDetails userDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole type;

    @OneToMany(mappedBy = "authorComment", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Comment> comments;

    public void addAddress(Address address) {
        this.address = address;
        this.address.getUsers().add(this);
    }

    private void setAddress(Address address) {
        this.address = address;
    }
}
