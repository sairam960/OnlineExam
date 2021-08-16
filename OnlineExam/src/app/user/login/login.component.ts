import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user.service';
import {Login} from 'src/app/appmodel/Login';
import { SharedServiceService } from 'src/app/shared-service.service';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent 
 {
   login:Login=new Login();
   message:String;

  constructor(private userService:UserService,private router:Router,private report:SharedServiceService){}

  loginCheck(){
    console.log(this.login.emailId);
    console.log(this.login.password);
    this.userService.login(this.login).subscribe(response=>{
     
     // alert(JSON.stringify(response));
      if(response.status== true){
        let userId=response.userId;
        let userName=response.name;
        sessionStorage.setItem('userId',String(userId));
        sessionStorage.setItem('userName',userName);
        this.router.navigateByUrl('/user-dashboard');
        this.report.setSubjectName("Java");
      }
      else{
          this.message=response.message;
      }

    })
  }

}


