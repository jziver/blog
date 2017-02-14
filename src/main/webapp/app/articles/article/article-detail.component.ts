import {Component, OnInit} from "@angular/core";
import {ArticleService} from "../shared/article.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import "rxjs/add/operator/switchMap";
import {Article} from "../article";
@Component({
  moduleId: module.id,
  selector: "blog-article-detail",
  templateUrl: "article-detail.html"
})
export class ArticleDetailComponent implements OnInit{

  article:Article = new Article();

  ngOnInit(): void {
    this.route.params
      .switchMap((params:Params) => this.service.getArticle(+params['id']))
      .subscribe(res => this.article = res.json());
  }

  constructor(private service: ArticleService,
              private route: ActivatedRoute,
              private location: Location) {
  }

}
