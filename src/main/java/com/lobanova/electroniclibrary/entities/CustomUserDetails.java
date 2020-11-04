package com.lobanova.electroniclibrary.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "user_details")
public class CustomUserDetails extends EntityBase implements UserDetails {

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @OneToOne
    private UserAuthority userAuthority;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(userAuthority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
