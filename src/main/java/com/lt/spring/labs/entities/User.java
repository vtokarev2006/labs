package com.lt.spring.labs.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios;

    private String emailAddress;

    private String phoneNumber;

    private String countryOfResidence;

    private String governmentIdentifier;

    private Long balanceHeldOnAccount;

    @Enumerated(EnumType.ORDINAL)
    private IdentifierType identifierType;
}
