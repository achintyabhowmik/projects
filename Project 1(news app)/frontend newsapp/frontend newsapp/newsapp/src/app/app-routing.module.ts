import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './auth-guard.service';
import { SearchComponent } from './modules/news/components/search/search.component';
import { TopNewsComponent } from './modules/news/components/top-news/top-news.component';
import {HttpClientModule} from '@angular/common/http';
import { ContainerComponent } from './modules/news/components/container/container.component';


const routes: Routes = [{
  path:'',component:TopNewsComponent},
  
   { path:'search',component:SearchComponent,
    canActivate:[AuthGuardService],
    data:{
      routeparam:'search'
  }}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),HttpClientModule],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],

  exports: [RouterModule]
})
export class AppRoutingModule { }
