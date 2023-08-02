package de.ait.hw.dto.eventsDtos;

import de.ait.hw.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Информация о пользователе")
public class UserInEventDto {

    @Schema(description = "Email пользователя", example = "user@mail.com")
    private String email;

    @Schema(description = "Индетификатор пользователя", example = "2")
    private Long id;
    public static UserInEventDto from(User user){
        return UserInEventDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
