import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NewsService} from '../../news.service'
import { MatSnackBar } from '@angular/material/snack-bar';
import {HttpClientModule} from '@angular/common/http';
import { ContainerComponent } from '../container/container.component';
import { AuthenticationService } from 'src/app/modules/authentication/authentication.service';

@Component({
  selector: 'news-top-news',
  templateUrl: './top-news.component.html',
  styleUrls: ['./top-news.component.css']
})
export class TopNewsComponent implements OnInit {
  newsList : Array<any>;
  

  constructor(private newsService: NewsService, private snackBar : MatSnackBar,public auth:AuthenticationService) {
    
    this.newsList = [];
   }
   

  ngOnInit() {
    
    

    this.newsService.getTopNews().subscribe((data:any)=>{
      console.log(data.articles);
      

      this.newsList = data['articles'];
    
    },
    error =>{
     this.snackBar.open(error['error'], '', {
      duration : 2000
    });
   });
  }
  


}



