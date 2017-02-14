export class Page <T> {
  content:Array<T>;
  first:boolean;
  last:boolean;
  number=0;
  numberOfElements:number;
  totalElements:number;
  totalPages:number = 0;
  sort:any;
}
