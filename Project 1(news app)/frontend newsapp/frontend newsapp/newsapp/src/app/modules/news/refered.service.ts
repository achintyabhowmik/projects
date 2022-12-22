import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ReferedService {
  api_key = '01355523181c46dc98ad4c5a992edf44';
  springEndpoint : string;

  constructor(private http: HttpClient) {
    this.springEndpoint = 'http://localhost:8088/api/news/refer';
  }

 

 addToNews(news: any)
 {
    return this.http.post(this.springEndpoint, news);
 }

 

getReferedNewsList():Observable<Array<any>>{
  return this.http.get<Array<any>>(this.springEndpoint);
}

}
