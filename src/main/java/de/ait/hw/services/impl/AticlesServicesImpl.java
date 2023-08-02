package de.ait.hw.services.impl;

import de.ait.hw.dto.articlesDto.ArticleDto;
import de.ait.hw.dto.articlesDto.ArticlesDto;
import de.ait.hw.dto.articlesDto.NewArticleDto;
import de.ait.hw.exceptions.IncorrectUserIdException;
import de.ait.hw.models.Article;
import de.ait.hw.models.User;
import de.ait.hw.repositories.ArticlesRepository;
import de.ait.hw.repositories.UsersRepository;
import de.ait.hw.services.AticlesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static de.ait.hw.dto.articlesDto.ArticleDto.from;

@RequiredArgsConstructor
@Service
public class AticlesServicesImpl implements AticlesServices {

    private final UsersRepository usersRepository;

    private final ArticlesRepository articlesRepository;
    @Override
    public ArticleDto addArticles(NewArticleDto newArticle) {
        User user = usersRepository.findById(newArticle.getAboutUserId())
                .orElseThrow(() ->
                        new IncorrectUserIdException("Id <" + newArticle.getAboutUserId() + "> is not correct"));

        Article article = Article.builder()
                .text(newArticle.getText())
                .about(user)
                .publishDate(LocalDate.parse(newArticle.getPublishDate()))
                .build();

        user.getArticles().add(article);

        articlesRepository.save(article);

        return from(article);
    }

    @Override
    public ArticlesDto getAricles(Integer year, Integer month, Integer day) {
        if (isCorrect(year, month,day)) {
            List<Article> articles = articlesRepository.findAllByDate(year, month, day);
            return ArticlesDto.builder()
                    .articles(from(articles))
                    .count(articles.size())
                    .build();
        } else throw new IllegalArgumentException("Неверный формат даты");
    }
    private boolean isCorrect(Integer year, Integer month, Integer day){
        return year == null && month == null && day == null ||
                year != null && month == null && day == null ||
                year != null && month != null && day == null ||
                year != null && month != null && day != null;
    }
}
