import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {LogInPageComponent} from './pages/log-in-page/log-in-page.component';

const routes = [
  // {path: '', component: NavbarComponent, outlet: 'navbar'},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LogInPageComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
