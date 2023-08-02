package de.ait.hw.dto.articlesDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Добавляемая статья")
public class NewArticleDto {

    @Schema(description = "Текст статьи", example = "Текст о пользователе...")
    private String text;

    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long aboutUserId;

    @Schema(description = "Дата публикации в формате YYYY_MM_DD", example = "2022.02.02")
    private String publishDate;
}
