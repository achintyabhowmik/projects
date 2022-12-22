import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import {SharedModule} from '../shared/shared.module'
import { RouterModule, Routes} from '@angular/router';
import {FormBuilder, FormsModule} from '@angular/forms'
import {ReactiveFormsModule} from '@angular/forms';
import {AuthenticationService} from './authentication.service'
import {HttpClientModule} from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

import { FormArrayName } from '@angular/forms';

const authRouter: Routes = [
  {
    path:'',
    children: [
      {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
      },
      {
        path: 'register',
        component: RegisterComponent,
      },
      {
        path: 'login',
        component: LoginComponent,
      }
    ]
  }
];
@NgModule({
  declarations: [LoginComponent, RegisterComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(authRouter),
    SharedModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatSnackBarModule,
  
    
  ], schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  providers:[AuthenticationService],
  exports: [
    RouterModule,
    RegisterComponent,
    LoginComponent,
    SharedModule
  ]
})
export class AuthenticationModule { }
