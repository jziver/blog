import {Component, Input, OnInit, OnChanges, Output, EventEmitter} from "@angular/core";
import {Page} from "./page";
@Component({
  moduleId: module.id,
  selector: "blog-page",
  templateUrl:"page.html"
})
export class PageComponent<T> implements OnChanges{
  ngOnChanges(): void {
    this.pageNum = this.generatePageNav();
    console.log(this._page);
  }
  pageNum: Array<any> = [];
  @Input('page')
  private _page: Page<T>;
  @Output() onCurrent_page = new EventEmitter<number>();
  current_page = 1;
  generatePageNav() {
    if(this._page.totalPages <1){
      return;
    }
    let pageNum: Array<any> = [];
    if (this._page.totalPages < 5) {
      for (let i = 0; i < this._page.totalPages; i++) {
        pageNum.push(i+1);
      }
      return pageNum;
    } else {
      pageNum.push(1);
      if(this.current_page<=1){
        pageNum.push(2);
        pageNum.push(3);
      }else{
        for(let i=2;i>0;i--){
          if(this.current_page -i >1){
            pageNum.push(this.current_page-i);
          }
        }
        pageNum.push(this.current_page);
        for(let i=1;i<3;i++){
          if(this.current_page + i<this._page.totalPages){
            pageNum.push(this.current_page+i);
          }
        }
      }

      if(this.current_page != this._page.totalPages){
        pageNum.push(this._page.totalPages);
      }
      if(pageNum[1] > 2){
        pageNum.splice(1,0,"...");
      }
      if(pageNum[pageNum.length-2]+1<this._page.totalPages){
        pageNum.splice(pageNum.length-1,0,"...");

      }
      return pageNum;
    }
  }
  toPage(page:number){
    if(typeof page !="number"){
      return;
    }
    this.current_page = page;
    this.onCurrent_page.emit(page);
    this.pageNum = this.generatePageNav();
  }
}
