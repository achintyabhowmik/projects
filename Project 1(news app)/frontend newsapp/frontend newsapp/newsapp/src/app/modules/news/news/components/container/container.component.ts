import { Component, OnInit, Input} from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import {NewsService} from '../../news.service';
import { ReferedService } from '../../refered.service';

@Component({
  selector: 'news-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {
  
  @Input()
  newsList : Array<any>;

  @Input()
  favCheck :boolean;

  
  

  
  constructor(private referedService:ReferedService,private newsService: NewsService, private snackBar : MatSnackBar) {
   }


  ngOnInit() {
    

  }

  addToFavouriteList(news: any)
  {
    console.log(news);
    this.referedService.addToNews(news).subscribe(()=>{}),
    this.newsService.addToNews(news).subscribe(()=>{
      console.log(news.title);
      this.snackBar.open(news.title+'added to favouritelist', '', {
        duration : 2000
      });
    },error =>{
      this.snackBar.open(error['error'], '', {
       duration : 2000
     });
    });

  }

  deleteNews(news: any ){
    this.newsService.deleteFromFavouriteList(news).subscribe((data)=>{
    console.log(data);
  
    this.snackBar.open(news.title+' deleted', '', {
      duration : 2000
    });
    },error =>{
      const message=JSON.stringify(error.error.message);
      this.snackBar.open(message, '', {
       duration : 2000
     });
    });
    for( var i=0;i<this.newsList.length;i++){
      if(this.newsList[i].title===news.title){
        this.newsList.splice(i,1);
      }
    }
    
  }addToReferedList(news:any){
    this.referedService.addToNews(news).subscribe(()=>{ 

      console.log(news.title);

  },error =>{
    this.snackBar.open(error['error'], '', {
     duration : 2000
   });
  });
  }

}
