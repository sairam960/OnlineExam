import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/appmodel/Login';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent  {

  login: Login= new Login();
  constructor(private userService : UserService,private router: Router){}
  
  changed(){
    
      alert("A reset link has been sent to your registered mail");
      this.router.navigateByUrl("");
  }
}
