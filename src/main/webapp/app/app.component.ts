import {Component} from '@angular/core';

@Component({
  selector:'my-app',
  template: `
       <blog-nav></blog-nav>
       <div class="container">
        <!-- Page Content goes here -->
         <blog-home></blog-home>
       </div>
    `
})
export class AppComponent{
  name = "angular"
}
