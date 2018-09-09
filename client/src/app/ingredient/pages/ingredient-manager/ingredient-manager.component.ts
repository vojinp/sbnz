import { Component, OnInit } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {IngredientService} from '../../../ingredient/shared/ingredient.service';
import {Ingredient} from '../../../ingredient/shared/ingredient.model';
import {IngredientModalComponent} from '../../../ingredient/ingredient-modal/ingredient-modal.component';

@Component({
  selector: 'app-ingredient-manager',
  templateUrl: './ingredient-manager.component.html',
  styleUrls: ['./ingredient-manager.component.css']
})
export class IngredientManagerComponent implements OnInit {
  ingredients;
  constructor(
    private ingredientService: IngredientService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.ingredientService.getAll('/api/ingredient').subscribe(res => {
      this.ingredients = res;
      console.log(res);
    });
  }

  open(ingredient: Ingredient, option) {
    const modalRef = this.modalService.open(IngredientModalComponent);
    modalRef.componentInstance.ingredient = JSON.parse(JSON.stringify(ingredient));
    modalRef.result.then((result) => {
      if (option === 'add')
        this.addIngredient(result);
      else if (option === 'change')
        this.changeIngredient(result);
    }, reason => {

    });
  }

  addIngredient(ingredient) {
    this.ingredientService.post('/api/ingredient', ingredient).subscribe(res => {
      console.log(res);
      this.ingredients.push(res);
    });
  }

  changeIngredient(ingredient) {
    this.ingredientService.put('/api/ingredient', ingredient).subscribe(res => {
      console.log(res);
      for (let i in this.ingredients)
        if(this.ingredients[i].id === ingredient.id)
          this.ingredients[i] = res;
    });
  }

  removeIngredient(ingredient) {
    this.ingredientService.delete(`/api/ingredient/${ingredient.id}`).subscribe(res => {
      console.log(res);
      for (let i in this.ingredients)
        if(this.ingredients[i].id === ingredient.id)
          this.ingredients.splice(i, 1);
    });
  }

}

