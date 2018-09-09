import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ChronicReportComponent} from './pages/chronic-report/chronic-report.component';
import {AddictionReportComponent} from './pages/addiction-report/addiction-report.component';
import {ImmuneReportComponent} from './pages/immune-report/immune-report.component';
import {PatientsModule} from '../patient/patients.module';

@NgModule({
  imports: [
    CommonModule,
    PatientsModule
  ],
  declarations: [
    ChronicReportComponent,
    AddictionReportComponent,
    ImmuneReportComponent
  ]
})
export class ReportsModule { }
