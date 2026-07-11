package com.rivalix.backend.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rivalix.backend.enums.TeamStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String tag;

    @NotBlank
    @Size(max = 100)
    @Column(name = "captain_name", nullable = false, length = 100)
    private String captainName;

    @Size(max = 10)
    @Column(name = "captain_phone", length = 10)
    private String captainPhone;

    @Email
    @Size(max = 255)
    @Column(name = "captain_email", length = 255)
    private String captainEmail;

    @Size(max = 500)
    @Column(name = "logo_url", length = 500)
    private String logoUrl;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TeamStatus status;

    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @JsonIgnore
    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TournamentRegistration> tournamentRegistrations = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();
}