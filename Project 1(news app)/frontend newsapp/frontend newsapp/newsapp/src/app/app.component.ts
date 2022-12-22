import { Component,OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import {AuthenticationService} from './modules/authentication/authentication.service';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './modules/authentication/components/login/login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  
  ngOnInit(){
    
  
  }
 
  title = 'Newsapp';
 

  constructor(public router: Router ,public auth: AuthenticationService)
  {
   
  }

  logout()
  {
    this.auth.deleteToken();
    this.auth.deletname();
    this.router.navigate(['/login'])

  }
getuser()
{

} 


}
