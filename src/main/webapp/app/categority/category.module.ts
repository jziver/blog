import {NgModule} from "@angular/core";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {CategoryService} from "./shared/category.service";
import {CategoryListComponent} from "./category-list/category-list.component";
@NgModule({
  imports:[
    CommonModule,
    FormsModule,
    HttpModule
  ],
  declarations:[
      CategoryListComponent
  ],
  exports:[
    CategoryListComponent
  ],
  providers:[
    CategoryService
  ]
})
export class CategoryModule{

}
