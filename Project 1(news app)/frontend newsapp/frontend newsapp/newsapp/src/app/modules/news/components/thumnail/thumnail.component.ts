import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {  CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

@Component({
  selector: 'news-thumnail',
  templateUrl: './thumnail.component.html',
  styleUrls: ['./thumnail.component.css']
})
export class ThumnailComponent implements OnInit {
  @Input()
  news : any;
  @Output()
  addNews = new EventEmitter();
  @Output()
  addNewsto= new EventEmitter()
  @Output()
  deleteNews=new EventEmitter();
  @Input()
  favCheck :boolean;

  constructor() { }

  ngOnInit() {

  }

  addToFavouriteList()
  {
    this.addNews.emit(this.news);
  }
  deleteNewsFav(){
    console.log(this.news);
    this.deleteNews.emit(this.news);

    }
    addToReferedList(){
      this.addNewsto.emit(this.news);
    }


}
