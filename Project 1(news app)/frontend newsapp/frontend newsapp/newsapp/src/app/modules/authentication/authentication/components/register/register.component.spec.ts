import { TestBed,async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { RegisterComponent} from './register.component';
import { FormBuilder } from '@angular/forms';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

describe('RegisterComponent', () => {

  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule,
    RouterTestingModule,MatSnackBarModule,FormBuilder
], 
    providers: [RegisterComponent]
  }));

   it('should be created', () => {
    const service: RegisterComponent= TestBed.get(RegisterComponent);
    expect(service).toBeTruthy();
   });

   it('should have getData function', () => {
    const service:  RegisterComponent = TestBed.get(RegisterComponent);
    expect(service).toBeTruthy();
   });

});