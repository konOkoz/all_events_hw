package de.ait.hw.controllers;

import de.ait.hw.controllers.api.ArticlesApi;
import de.ait.hw.dto.articlesDto.ArticleDto;
import de.ait.hw.dto.articlesDto.ArticlesDto;
import de.ait.hw.dto.articlesDto.NewArticleDto;
import de.ait.hw.services.AticlesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticlesController implements ArticlesApi {

    private final AticlesServices articlesService;

    @Override
    public ArticleDto addArticle(NewArticleDto newArticle) {
        return articlesService.addArticles(newArticle);
    }

    @Override
    public ArticlesDto getArticles(Integer year, Integer month, Integer day) {
        return articlesService.getAricles(year,month,day);
    }

}
