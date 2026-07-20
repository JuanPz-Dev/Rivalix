package com.rivalix.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArenaGamingResponse {
    private Long id;
    private String name;
    private String address;
    private String phone;
}