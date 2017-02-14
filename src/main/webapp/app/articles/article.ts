import {Category} from "../categority/category";
import {Tag} from "../tags/tag";
export class Article{
  id:number;
  createTime:Date;
  updateTime:Date;
  title:string;
  summary:string;
  content:string;
  category:Category;
  tags:Array<Tag> = [];
}
