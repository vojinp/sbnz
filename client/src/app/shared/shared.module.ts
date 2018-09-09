import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AuthenticationService} from './authentication.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { NavBarComponent } from './layout/nav-bar/nav-bar.component';
import { TabsComponent } from './layout/tabs/tabs.component';
import {RouterModule} from '@angular/router';
import { ReportTabsComponent } from './layout/report-tabs/report-tabs.component';
import { AdminTabsComponent } from './layout/admin-tabs/admin-tabs.component';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  providers: [
    AuthenticationService
  ],
  declarations: [NavBarComponent, TabsComponent, ReportTabsComponent, AdminTabsComponent],
  exports: [
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    TabsComponent,
    ReportTabsComponent,
    AdminTabsComponent
  ]
})
export class SharedModule { }
