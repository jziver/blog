import {Component, OnInit} from "@angular/core";
import {Category} from "../category";
import {CategoryService} from "../shared/category.service";
@Component({
  moduleId:module.id,
  selector:"blog-category-list",
  templateUrl:"category-list.html"
})
export class CategoryListComponent implements OnInit {
  categories: Array<Category>;

  constructor(private service: CategoryService) {
  }

  ngOnInit(): void {
    this.service.getCategories().subscribe(res => this.categories = res.json());
  }

}
