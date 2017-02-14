import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app.routing.module";
import {ArticleModule} from "./articles/article.module";
import {HomeComponent} from "./shared/home/home.component";
import {NavComponent} from "./shared/nav/nav.componnent";
import {CategoryModule} from "./categority/category.module";
@NgModule({
  //放置Module
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    ArticleModule,
    CategoryModule
  ],
  //放置组件(Component),指令(directive),管道(pipe)
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent
  ],
  //启动组件(根组件)
  bootstrap: [
    AppComponent
  ],
  //放置服务
  providers: []
})
export class AppModule {
}
