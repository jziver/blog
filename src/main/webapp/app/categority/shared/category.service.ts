import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
@Injectable()
export class CategoryService{

  private category_url = "http://localhost:8001/blog/categories";

  constructor(private http:Http){}

  getCategories(){
    return this.http.get(this.category_url);
  }

}
