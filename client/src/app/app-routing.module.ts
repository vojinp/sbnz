import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import {LogInPageComponent} from './pages/log-in-page/log-in-page.component';
import {ReasonerPageComponent} from './pages/reasoner-page/reasoner-page.component';
import {AdminPageComponent} from './pages/admin-page/admin-page.component';
import {NavBarComponent} from './shared/layout/nav-bar/nav-bar.component';
import {StartReasonerComponent} from './symptom/pages/start-reasoner/start-reasoner.component';
import {FindDiseaseComponent} from './symptom/pages/find-disease/find-disease.component';
import {FindSymptomsComponent} from './disease/pages/find-symptoms/find-symptoms.component';
import {AddDiagnosisComponent} from './diagnosis/pages/add-diagnosis/add-diagnosis.component';
import {ReportPageComponent} from './pages/report-page/report-page.component';
import {ChronicReportComponent} from './report/pages/chronic-report/chronic-report.component';
import {AddictionReportComponent} from './report/pages/addiction-report/addiction-report.component';
import {ImmuneReportComponent} from './report/pages/immune-report/immune-report.component';
import {UserManagerComponent} from './user/pages/user-manager/user-manager.component';
import {PatientManagerComponent} from './patient/pages/patient-manager/patient-manager.component';
import {DiseaseManagerComponent} from './disease/pages/disease-manager/disease-manager.component';
import {SymptomManagerComponent} from './symptom/pages/symptom-manager/symptom-manager.component';
import {MedicationManagerComponent} from './medication/pages/medication-manager/medication-manager.component';
import {IngredientManagerComponent} from './ingredient/pages/ingredient-manager/ingredient-manager.component';
import {MonitoringPageComponent} from './pages/monitoring-page/monitoring-page.component';

const routes = [
  {path: '', component: NavBarComponent, outlet: 'navbar'},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LogInPageComponent},
  {path: 'reasoner', component: ReasonerPageComponent, children: [
      {path: '', redirectTo: 'start-reasoner', pathMatch: 'full'},
      {path: 'start-reasoner', component: StartReasonerComponent},
      {path: 'find-disease', component: FindDiseaseComponent},
      {path: 'find-symptoms', component: FindSymptomsComponent},
      {path: 'add-diagnosis', component: AddDiagnosisComponent}

    ]},
  {path: 'report', component: ReportPageComponent, children: [
      {path: '', redirectTo: 'chronic-patients', pathMatch: 'full'},
      {path: 'chronic-patients', component: ChronicReportComponent},
      {path: 'addiction-patients', component: AddictionReportComponent},
      {path: 'immune-patients', component: ImmuneReportComponent}
    ]},
  {path: 'monitoring', component: MonitoringPageComponent},
  {path: 'admin', component: AdminPageComponent, children: [
      {path: '', redirectTo: 'users-manager', pathMatch: 'full'},
      {path: 'users-manager', component: UserManagerComponent},
      {path: 'patients-manager', component: PatientManagerComponent},
      {path: 'diseases-manager', component: DiseaseManagerComponent},
      {path: 'symptoms-manager', component: SymptomManagerComponent},
      {path: 'medications-manager', component: MedicationManagerComponent},
      {path: 'ingredients-manager', component: IngredientManagerComponent}
      ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
