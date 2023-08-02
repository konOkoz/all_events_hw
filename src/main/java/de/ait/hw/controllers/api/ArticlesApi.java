package de.ait.hw.controllers.api;

import de.ait.hw.dto.articlesDto.ArticleDto;
import de.ait.hw.dto.articlesDto.ArticlesDto;
import de.ait.hw.dto.articlesDto.NewArticleDto;
import de.ait.hw.dto.usersDtos.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
        @Tag(name = "Articles")
})
@RequestMapping("/api/articles")
public interface ArticlesApi {

    @Operation(summary = "Создание статьи о пользователе", description = "Доступно всем пользователям ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = " Пользователь с указаным ID отсутствует в системе",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "201", description = "Добавленная статьи",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ArticleDto.class))
                    })
            })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ArticleDto addArticle(@RequestBody NewArticleDto  newArticle);

    @Operation(summary = "Получение всех статей", description = "Доступно всем пользователям ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список статей",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ArticlesDto.class))
                    })
    })
    @GetMapping
    ArticlesDto getArticles(@Parameter(description = "Год") @RequestParam(value = "year", required = false) Integer year,
                            @Parameter(description = "Месяц")@RequestParam(value = "month", required = false) Integer month,
                            @Parameter(description = "День")@RequestParam(value = "day", required = false)Integer day);
}

