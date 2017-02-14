import {Routes, RouterModule} from "@angular/router";
import {NgModule} from "@angular/core";
import {ArticleDetailComponent} from "./articles/article/article-detail.component";
import {ArticleListComponent} from "./articles/article-list/article-list.component";

const routes:Routes=[

  {
    path:"",
    component:ArticleListComponent
  },
  {
    path:'article/:id',
    component:ArticleDetailComponent
  },

];

@NgModule({
  imports:[RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule{}
