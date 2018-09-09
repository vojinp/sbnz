import { BrowserModule } from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import { LogInPageComponent } from './pages/log-in-page/log-in-page.component';
import { AppRoutingModule } from './app-routing.module';
import {SharedModule} from './shared/shared.module';
import {LogInService} from './pages/log-in-page/log-in.service';
import {ReactiveFormsModule} from '@angular/forms';
import {SymptomsModule} from './symptom/symptoms.module';
import { ReasonerPageComponent } from './pages/reasoner-page/reasoner-page.component';
import { AdminPageComponent } from './pages/admin-page/admin-page.component';
import {DiseasesModule} from './disease/diseases.module';
import {DiagnosesModule} from './diagnosis/diagnoses.module';
import {PatientsModule} from './patient/patients.module';
import { ReportPageComponent } from './pages/report-page/report-page.component';
import { ChronicReportComponent } from './report/pages/chronic-report/chronic-report.component';
import { AddictionReportComponent } from './report/pages/addiction-report/addiction-report.component';
import { ImmuneReportComponent } from './report/pages/immune-report/immune-report.component';
import {ReportsModule} from './report/reports.module';
import {UsersModule} from './user/users.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {IngredientsModule} from './ingredient/ingredients.module';
import { MonitoringPageComponent } from './pages/monitoring-page/monitoring-page.component';


@NgModule({
  declarations: [
    AppComponent,
    LogInPageComponent,
    ReasonerPageComponent,
    AdminPageComponent,
    ReportPageComponent,
    MonitoringPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    SymptomsModule,
    DiagnosesModule,
    DiseasesModule,
    PatientsModule,
    ReportsModule,
    UsersModule,
    NgbModule,
    IngredientsModule,
  ],
  providers: [
    LogInService
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
