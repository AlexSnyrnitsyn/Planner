package com.example.planner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String roleName;

    @Transient
    @ManyToMany(mappedBy = "role")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

}
