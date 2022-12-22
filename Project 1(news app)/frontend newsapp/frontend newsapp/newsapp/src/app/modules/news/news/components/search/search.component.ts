import { Component, OnInit } from '@angular/core';
import {NewsService} from '../../news.service'
import {HttpClientModule} from '@angular/common/http';
@Component({
  selector: 'news-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  newsLists: Array<any>;
  constructor(private newsService: NewsService) { 
this.newsLists=[]
    
  }

  ngOnInit() {
    
  }

  onEnter(searchKey: string) {
    
    this.newsService.searchNews(searchKey).subscribe((data:any) => {
      this.newsLists = data['articles'];
    
    });
  }

}
