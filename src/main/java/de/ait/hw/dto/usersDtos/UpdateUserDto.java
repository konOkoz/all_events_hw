package de.ait.hw.dto.usersDtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Данные для обновления")
public class UpdateUserDto {

    @Schema(description = "Роль пользователя - USER - пользователь MANAGER - менеджер", example = "USER")
    private String newRole;

    @Schema(description = "Статус пользователя - NOT_CONFIRMED, CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
    private String newState;
}