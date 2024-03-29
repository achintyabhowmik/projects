import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from './modules/authentication/authentication.service';
import {HttpClientModule} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{
  constructor(private router: Router, private authService: AuthenticationService) { 
  
  }

  canActivate()
  {
    if(!this.authService.isTokenExpired())
      return true;
    this.router.navigate(['/login']);
    return false;
  }

}
