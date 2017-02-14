package com.blog.web.rest;

import com.blog.domain.Article;
import com.blog.repository.ArticleRepository;
import com.blog.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/blog/articles")
public class ArticleResource {

    private final Logger log = LoggerFactory.getLogger(ArticleResource.class);

    private final ArticleRepository repository;

    @Autowired
    public ArticleResource(ArticleRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Article>> findAll(@RequestParam(value = "offset", required = false) Integer offset,
                                                 @RequestParam(value = "limit", required = false) Integer limit) {

        Page<Article> page = repository.findAll(PaginationUtil.generatePageRequest(offset, limit, new Sort(Sort.Direction.DESC,"createTime")));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findOne(@PathVariable Integer id) {
        Article article = repository.findOne(id);
        return ResponseEntity.ok(article);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Article>> findByCategory(@PathVariable Integer id) {
        List<Article> articles = repository.findByCategoryIdOrderByCreateTimeDesc(id);
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<List<Article>> findByTag(@PathVariable Integer id) {
        List<Article> articles = repository.findByTagsIdOrderByCreateTimeDesc(id);
        return ResponseEntity.ok(articles);
    }

    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody Article article) throws URISyntaxException {
        log.debug("save article {}", article);
        Article result = repository.save(article);
        return ResponseEntity.created(new URI("/blog/articles/" + result.getId())).build();
    }

    @PutMapping
    public ResponseEntity<Article> update(@RequestBody Article article) {
        Article result = repository.saveAndFlush(article);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        repository.delete(id);
        return ResponseEntity.ok().build();
    }

}
