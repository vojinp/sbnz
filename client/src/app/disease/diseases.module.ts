import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FindSymptomsComponent } from './pages/find-symptoms/find-symptoms.component';
import { DiseaseTableComponent } from './disease-table/disease-table.component';
import { DiseaseSelectComponent } from './disease-select/disease-select.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { DiseaseManagerComponent } from './pages/disease-manager/disease-manager.component';
import { DiseaseModalComponent } from './disease-modal/disease-modal.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  declarations: [FindSymptomsComponent, DiseaseTableComponent, DiseaseSelectComponent, DiseaseManagerComponent, DiseaseModalComponent],
  exports: [FindSymptomsComponent, DiseaseTableComponent, DiseaseSelectComponent],
  entryComponents: [DiseaseModalComponent]

})
export class DiseasesModule { }
