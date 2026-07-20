package com.rivalix.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArenaGamingRequest {
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String address;

    @NotBlank
    @Size(max = 20)
    private String phone;
}