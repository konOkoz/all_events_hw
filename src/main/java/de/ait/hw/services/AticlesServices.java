package de.ait.hw.services;

import de.ait.hw.dto.articlesDto.ArticleDto;
import de.ait.hw.dto.articlesDto.ArticlesDto;
import de.ait.hw.dto.articlesDto.NewArticleDto;

public interface AticlesServices {
    ArticleDto addArticles(NewArticleDto newArticle);

    ArticlesDto getAricles(Integer year, Integer month, Integer day);
}
