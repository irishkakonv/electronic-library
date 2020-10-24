package com.lobanova.electroniclibrary.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Address extends EntityBase {

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<User> users;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }
}

