package com.lobanova.electroniclibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authorities")
public class UserAuthority extends EntityBase implements GrantedAuthority {

    @Column(name = "authority")
    private String authority;
}
