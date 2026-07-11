package com.rivalix.backend.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "arena_gaming")
public class ArenaGaming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String address;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String phone;

    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "arenaGaming", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Customer> customers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "arenaGaming", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Computer> computers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "arenaGaming", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tournament> tournaments = new ArrayList<>();
}