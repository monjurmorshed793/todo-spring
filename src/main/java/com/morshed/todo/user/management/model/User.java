package com.morshed.todo.user.management.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.YesNoConverter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "todo_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name="last_name", length = 25)
    private String lastName;

    private String password;

    @Convert(converter = YesNoConverter.class)
    @Column(name="is_account_expired")
    private Boolean isAccountExpired;

    @Convert(converter = YesNoConverter.class)
    @Column(name="is_account_blocked")
    private Boolean isAccountBlocked;

    @Column(nullable = false, name = "is_enabled")
    @Convert(converter = YesNoConverter.class)
    private Boolean isEnabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
