import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MedicationTableComponent } from './medication-table/medication-table.component';
import { MedicationModalComponent } from './medication-modal/medication-modal.component';
import { MedicationManagerComponent } from './pages/medication-manager/medication-manager.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  declarations: [MedicationTableComponent, MedicationModalComponent, MedicationManagerComponent],
  exports: [MedicationTableComponent],
  entryComponents: [MedicationModalComponent]

})
export class MedicationsModule { }
