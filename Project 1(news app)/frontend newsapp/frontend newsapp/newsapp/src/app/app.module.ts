import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AuthenticationModule} from './modules/authentication/authentication.module';
import { HttpClientModule } from '@angular/common/http';
import {  CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';

import {NewsModule} from './modules/news/news.module';
import {SharedModule} from './modules/shared/shared.module';
import { RouterTestingModule } from '@angular/router/testing';
import { AppRoutingModule } from './app-routing.module';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatIconModule } from '@angular/material/icon';
import { MatButton, MatButtonModule } from '@angular/material/button';
import { MatSidenav, MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import {MatMenuModule} from '@angular/material/menu';


const appRoutes: Routes =[
  {
    path: '',
    redirectTo: '/news/top',
    pathMatch: 'full'
  }
]
@NgModule({
  declarations: [
    AppComponent,
    
  ],
  imports: [
    BrowserModule,
    NewsModule,
    HttpClientModule,
    SharedModule,
    AuthenticationModule,
    RouterModule.forRoot(appRoutes),
    AppRoutingModule,
    MatSnackBarModule,
    CommonModule,
    MatIconModule,
    MatButtonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatCardModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MatMenuModule,

    

  ],
  exports: [RouterModule],
  providers: [],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  bootstrap: [AppComponent]
})
export class AppModule { }
