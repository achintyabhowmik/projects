import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import { ReferedService} from './refered.service'


describe('myService', () => {

      beforeEach(() => TestBed.configureTestingModule({
        imports: [HttpClientTestingModule], 
        providers: [ReferedService]
      }));

       it('should be created', () => {
        const service: ReferedService = TestBed.get(ReferedService);
        expect(service).toBeTruthy();
       });

       it('should have getData function', () => {
        const service: ReferedService = TestBed.get(ReferedService);
        expect(service).toBeTruthy();
       });

    });