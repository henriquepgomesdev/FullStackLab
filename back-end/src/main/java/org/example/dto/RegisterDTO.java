package org.example.dto;

import org.example.domain.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
