import {Component, OnInit} from "@angular/core";
import {ArticleService} from "../shared/article.service";
import {Article} from "../article";
import {Page} from "../../shared/page/page";
@Component({
  moduleId: module.id,
  selector: "blog-article-list",
  templateUrl: "article-list.html"
})
export class ArticleListComponent implements OnInit {
  ngOnInit(): void {
    this.getArticles(1);
  }

  constructor(private service: ArticleService) {
  }

  page: Page<Article> = new Page<Article>();


  getArticles(pageNum: number) {
    this.service.getArticles(pageNum).subscribe(res => this.page = res.json())
  }
  onCurrent_page(pageNum:number){
    this.getArticles(pageNum);
  }

}
