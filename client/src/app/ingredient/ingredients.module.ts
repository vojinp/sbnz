import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IngredientModalComponent } from './ingredient-modal/ingredient-modal.component';
import { IngredientTableComponent } from './ingredient-table/ingredient-table.component';
import { IngredientManagerComponent } from './pages/ingredient-manager/ingredient-manager.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [IngredientModalComponent, IngredientTableComponent, IngredientManagerComponent],
  entryComponents: [IngredientModalComponent]
})
export class IngredientsModule { }
