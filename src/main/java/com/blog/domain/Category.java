package com.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 20,nullable = false,unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Article> articles = new ArrayList<>();

    @Transient
    private int articleSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArticleSize() {
        return articles.size();
    }

    public void setArticleSize(int articleSize) {
        this.articleSize = articleSize;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", articleSize=" + articleSize +
                '}';
    }
}
