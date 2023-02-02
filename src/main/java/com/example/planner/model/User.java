package com.example.planner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserSkill> userSkills;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position userPosition;

    @ManyToOne
    @JoinColumn(name = "subdivision_id")
    private Subdivision userSubdivision;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
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
