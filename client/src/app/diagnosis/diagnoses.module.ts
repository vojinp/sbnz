import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddDiagnosisComponent } from './pages/add-diagnosis/add-diagnosis.component';
import {DiseaseTableComponent} from '../disease/disease-table/disease-table.component';
import {DiseaseSelectComponent} from '../disease/disease-select/disease-select.component';
import {PatientPickerComponent} from '../patient/patient-picker/patient-picker.component';
import {PatientsModule} from '../patient/patients.module';
import {DiseasesModule} from '../disease/diseases.module';
import {MedicationsModule} from '../medication/medications.module';

@NgModule({
  imports: [
    CommonModule,
    PatientsModule,
    DiseasesModule,
    MedicationsModule
  ],
  declarations: [
    AddDiagnosisComponent
  ],
  exports: [AddDiagnosisComponent]

})
export class DiagnosesModule { }
