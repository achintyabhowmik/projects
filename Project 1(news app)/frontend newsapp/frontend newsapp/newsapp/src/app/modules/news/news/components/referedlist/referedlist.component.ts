import { Component, OnInit } from '@angular/core';
import { ReferedService} from '../../refered.service'
import {HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-referedlist',
  templateUrl: './referedlist.component.html',
  styleUrls: ['./referedlist.component.css']
})
export class ReferedlistComponent implements OnInit {
newsref:Array<any>;
  constructor(private referedService: ReferedService) { this.newsref=[];}

  ngOnInit(): void {
    this.referedService.getReferedNewsList().subscribe((data)=>{
      this.newsref.push(...data);
    });
  }
  
}
