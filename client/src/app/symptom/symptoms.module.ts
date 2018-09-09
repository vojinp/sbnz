import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SymptomTableComponent } from './symptom-table/symptom-table.component';
import { StartReasonerComponent } from './pages/start-reasoner/start-reasoner.component';
import { FindDiseaseComponent } from './pages/find-disease/find-disease.component';
import {PatientsModule} from '../patient/patients.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { SymptomModalComponent } from './symptom-modal/symptom-modal.component';
import { SymptomManagerComponent } from './pages/symptom-manager/symptom-manager.component';

@NgModule({
  imports: [
    CommonModule,
    PatientsModule,
    ReactiveFormsModule,
    FormsModule
  ],
  declarations: [SymptomTableComponent, StartReasonerComponent, FindDiseaseComponent, SymptomModalComponent, SymptomManagerComponent],
  exports: [SymptomTableComponent, StartReasonerComponent, FindDiseaseComponent],
  entryComponents: [SymptomModalComponent]
})
export class SymptomsModule { }
