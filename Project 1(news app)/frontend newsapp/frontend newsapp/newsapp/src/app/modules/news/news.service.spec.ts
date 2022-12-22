import { TestBed,async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import { NewsService } from './news.service';
import { Injectable } from '@angular/core';

describe('NewsService', () => {

  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule], 
    providers: [NewsService]
  }));

   it('should be created', () => {
    const service: NewsService = TestBed.get( NewsService);
    expect(service).toBeTruthy();
   });

   it('should have getData function', () => {
    const service:  NewsService = TestBed.get( NewsService);
    expect(service).toBeTruthy();
   });

});