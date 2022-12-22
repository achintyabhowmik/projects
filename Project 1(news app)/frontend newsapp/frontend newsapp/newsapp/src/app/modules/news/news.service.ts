import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewsService {
   api_key = 'e4b41bc6acf248d19f90e1617d411beb';
  springEndpoint : string;

  constructor(private http: HttpClient) {
    this.springEndpoint = 'http://localhost:8040/api/news/favourite';
  }

  searchNews(query: string) {
    const url ='https://newsapi.org/v2/everything?' +
    'q=' + query +
    '&apiKey='+this.api_key;
    console.log(url);
    return this.http.get(url);
 }

 addToNews(news: any)
 {
    return this.http.post(this.springEndpoint, news);
 }

 getFavouriteNewsList():Observable<Array<any>>
 {
   console.log("getting");
    return this.http.get<Array<any>>(this.springEndpoint);
 }

 deleteFromFavouriteList(news: any)
 {
    return this.http.delete(this.springEndpoint + "/" + news.id,{responseType:'text'});
 }

 getTopNews():Observable<any>
 {
   const url ='https://newsapi.org/v2/top-headlines?country=in&apiKey=' +
   this.api_key;
   return this.http.get(url);
 }

}
