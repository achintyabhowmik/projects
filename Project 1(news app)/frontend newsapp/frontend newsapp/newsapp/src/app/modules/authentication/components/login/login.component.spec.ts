import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { Location } from '@angular/common';
import { LoginComponent } from './login.component';
import { AuthenticationService } from 'src/app/modules/authentication/authentication.service';
import { Router } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../../../shared/shared.module'
import { By } from '@angular/platform-browser';



const testConfig = {
  userData: {
    firstName: 'test',
    lastName: 'testLast',
    userId: 'testUser',
    password: 'testPass'
  }
}

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authService: AuthenticationService;
  let spyUser: any;
  let routes: Router;
  let location: Location;

  class AuthServiceStub {
    currentUser: any;

    constructor() {

    }

    login(credentials:any) {
      if (credentials.userId == testConfig.userData.userId) {
        console.log('data:::', this.currentUser);
        return credentials.userId;
      } else {
        return false;
      }
    }
  }

  class dummy {

  }

  beforeEach((() => {
    TestBed.configureTestingModule({
      declarations: [LoginComponent],
      imports: [FormsModule, SharedModule, BrowserAnimationsModule, HttpClientModule, MatIconModule, ReactiveFormsModule,
        RouterTestingModule.withRoutes(
          [{ path: '', component: dummy }]
        )
      ],
      providers: [{ provide: AuthenticationService, useClass: AuthServiceStub }]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    routes = TestBed.get(Router);
    fixture = TestBed.createComponent(LoginComponent);
    location = TestBed.get(Location);
    component = fixture.componentInstance;
    fixture.detectChanges();
    fixture.debugElement.injector.get(AuthenticationService);
  });

  it('should create app component', (() => {
    const app:any = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it('should contain two input box for userId and password', () => {
    let userId = fixture.debugElement.query(By.css('.userId'));
    let password = fixture.debugElement.query(By.css('.password'));
    let registerButton = fixture.debugElement.query(By.css('.register-button'));
    let userButton = fixture.debugElement.query(By.css('.login-button'));

    let userIdInput = userId.nativeElement;
    let passwordInput = password.nativeElement;
    let registerButtonInput = registerButton.nativeElement;
    let userButtonInput = userButton.nativeElement;

    expect(userIdInput).toBeTruthy();
    expect(passwordInput).toBeTruthy();
    expect(registerButtonInput).toBeTruthy();
    expect(userButtonInput).toBeTruthy();
  });

  it('should redirect to login if registered successfully', (() => {
    let userId = fixture.debugElement.query(By.css('.userId'));
    let password = fixture.debugElement.query(By.css('.password'));
    let userButton = fixture.debugElement.query(By.css('.login-button'));

    let userIdInput = userId.nativeElement;
    let passwordInput = password.nativeElement;
    let userButtonInput = userButton.nativeElement;
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      userIdInput.value = 'testuser';
      passwordInput.value = 'testpass';
      userIdInput.dispatchEvent(new Event('inptut'));
      passwordInput.dispatchEvent(new Event('inptut'));
      userButtonInput.click();
    }).then(() => {
      expect(location.path()).toBe('');
    });
  }));
});
