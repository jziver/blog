import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/map";

@Injectable()
export class ArticleService {
  constructor(private http: Http) {
  }

  private article_url = "http://localhost:8001/blog/articles";

  getArticles(page: number) {
    return this.http.get(this.article_url + "?offset=" + page + "&&limit=" + 1);
  }


  getArticle(id: number) {
    return this.http.get(this.article_url+"/"+id);
  }
}
