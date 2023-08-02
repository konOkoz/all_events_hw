package de.ait.hw.repositories;

import de.ait.hw.models.Article;

import java.time.LocalDate;
import java.util.List;

public interface ArticlesRepository extends CrudRepository<Article> {
    List<Article> findAllByDate(Integer year, Integer month, Integer day);
}
