package de.ait.hw.dto.articlesDto;

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
@Schema(description = "Информация о пользователе в статье")
public class UserInArticleDto {
    @Schema(description = "Email пользователя", example = "user@gmail.com")
    private String email;
    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long id;

    public static UserInArticleDto from(User user){
        return UserInArticleDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
