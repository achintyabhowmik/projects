import { NgModule } from '@angular/core';
import { InterceptorService } from './interceptor.service';
import { SearchComponent } from './components/search/search.component';
import { ContainerComponent } from './components/container/container.component';
import { Routes, RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared.module';
import { FavComponent } from './components/fav/fav.component';
import { NewsService} from './news.service'
import{ReferedService} from "./refered.service";
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {  CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { AuthGuardService } from 'src/app/auth-guard.service';
import { TopNewsComponent } from './components/top-news/top-news.component';
import { ReferedlistComponent } from './components/referedlist/referedlist.component';
import { MatCardModule } from '@angular/material/card';
import { ThumnailComponent } from './components/thumnail/thumnail.component';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';


const newsRoutes: Routes = [
  {
      path : 'news',
      children : [
     
          {
              path : 'search',
              canActivate : [AuthGuardService],
              component : SearchComponent
          },
          {
            path : 'favourites',
            canActivate : [AuthGuardService],
            component : FavComponent
          },
          {
            path : 'top',
            canActivate : [AuthGuardService],
            component : TopNewsComponent
        },{
          path : 'RecomondedNews',
          canActivate : [AuthGuardService],
          component : ReferedlistComponent
        },
      ]
  }
];
@NgModule({
  declarations: [SearchComponent, ContainerComponent,ThumnailComponent,  FavComponent, TopNewsComponent, ReferedlistComponent],
  imports: [
    RouterModule.forChild(newsRoutes),
    SharedModule,
    HttpClientModule,
    MatCardModule,
    MatSnackBarModule
  ], schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  providers:[
    NewsService,
    ReferedService, {
      provide : HTTP_INTERCEPTORS,
      useClass :  InterceptorService,
      multi : true
    }
  ],
  exports :[
    SearchComponent, ContainerComponent, TopNewsComponent
  ]
})
export class NewsModule { }
