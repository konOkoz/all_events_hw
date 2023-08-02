package de.ait.hw.dto.articlesDto;

import de.ait.hw.models.Article;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Статьи пользователя")
public class ArticlesDto {
    @Schema(description = "Список статей")
    private List<ArticleDto> articles;
    @Schema(description = "Количество статей пользователя")
    private Integer count;
}
