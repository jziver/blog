package com.blog.domain;

import com.blog.domain.util.StringUtil;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    private Date createTime = new Date();

    @UpdateTimestamp
    private Date updateTime;

    @Column(length = 20,
            nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true, columnDefinition = "text")
    private String content;

    private String summary;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", updatable = false)
    private Category category;

    @ManyToMany(cascade = CascadeType.DETACH, targetEntity = Tag.class,fetch = FetchType.EAGER)
    @JoinTable(name = "ARTICLE_TAG",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setSummary(content);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        if(this.content !=null && summary.length() > 150){
            this.summary = summary.substring(0,100)+"...";
        }else {
            this.summary = summary;
        }
        this.summary = StringUtil.delHTMLTag(this.summary);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", tags=" + tags +
                '}';
    }
}
