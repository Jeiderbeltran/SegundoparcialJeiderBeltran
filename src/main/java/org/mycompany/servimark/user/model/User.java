package org.mycompany.servimark.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.mycompany.servimark.core.models.Municipality;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_status_id", nullable = false)
    private UserStatus userStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "identification_type_id", nullable = false)
    private IdentificationType identificationType;

    @Column(name = "identification", nullable = false, length = 32)
    private String identification;

    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;

    @Column(name = "middle_first_name", length = 32)
    private String middleFirstName;

    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;

    @Column(name = "middle_last_name", length = 32)
    private String middleLastName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    @Column(name = "username", nullable = false, length = 32)
    private String username;

    @Column(name = "phone", nullable = false, length = 32)
    private String phone;

    @Column(name = "phone_home")
    private String phoneHome;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "municipality_id", nullable = false)
    private Municipality municipality;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email_verified_at")
    private Instant emailVerifiedAt;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}