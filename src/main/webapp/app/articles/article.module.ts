import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {ArticleListComponent} from "./article-list/article-list.component";
import {ArticleDetailComponent} from "./article/article-detail.component";
import {ArticleContentTransformation} from "./shared/article.pipe";
import {ArticleService} from "./shared/article.service";
import {RouterModule} from "@angular/router";
import {PageComponent} from "../shared/page/page.component";
@NgModule({
  imports:[
    CommonModule,
    FormsModule,
    HttpModule,
    RouterModule
  ],
  declarations:[
    ArticleListComponent,
    ArticleDetailComponent,
    ArticleContentTransformation,
    PageComponent
  ],

  exports:[
    ArticleListComponent,
    ArticleDetailComponent,
    PageComponent
  ],
  providers:[
    ArticleService
  ]
})
export class ArticleModule{

}
