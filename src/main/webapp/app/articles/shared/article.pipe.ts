import {Pipe, PipeTransform} from "@angular/core";
@Pipe({
  name: "articleContent"
})
export class ArticleContentTransformation implements PipeTransform {
  transform(value: string, ...args: string[]): string {
    return value.length > 197 ? value.substring(0, 196) + '...' : value;
  }

}
