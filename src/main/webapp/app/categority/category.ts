import {Article} from "../articles/article";
export class Category{
  id:number;
  name:string;
  articleSize:number;
  articles:Array<Article> = []
}
