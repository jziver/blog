package com.blog.web.rest;

import com.blog.domain.Category;
import com.blog.repository.CategoryRepository;
import com.blog.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/blog/categories")
public class CategoryResource {

    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    private final CategoryRepository repository;

    @Autowired
    public CategoryResource(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = repository.findAll();
        categories.sort((c1,c2) ->Integer.compare(c2.getArticleSize(),c1.getArticleSize()));
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody Category category) throws URISyntaxException {
        Category result = repository.save(category);
        return ResponseEntity.created(new URI("/blog/categories/" + result.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        repository.delete(id);
        return ResponseEntity.ok().build();
    }


}
