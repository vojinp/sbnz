import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserTableComponent } from './user-table/user-table.component';
import {UserManagerComponent} from './pages/user-manager/user-manager.component';
import { UserModalComponent } from './user-modal/user-modal.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [UserTableComponent, UserManagerComponent, UserModalComponent],
  entryComponents: [UserModalComponent]
})
export class UsersModule { }
