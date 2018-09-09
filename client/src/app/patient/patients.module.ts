import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientPickerComponent } from './patient-picker/patient-picker.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { PatientTableComponent } from './patient-table/patient-table.component';
import { PatientManagerComponent } from './pages/patient-manager/patient-manager.component';
import { PatientModalComponent } from './patient-modal/patient-modal.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  declarations: [PatientPickerComponent, PatientTableComponent, PatientManagerComponent, PatientModalComponent],
  exports: [PatientPickerComponent, PatientTableComponent],
  entryComponents: [
    PatientModalComponent
  ]

})
export class PatientsModule { }
