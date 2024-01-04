import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';


@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})

export class AdminLoginComponent {

  userName:string;
  password:string;
  constructor(private router: Router) {}

  login() {

  if(this.userName=="Admin" && this.password=="Admin@123"){
    this.router.navigate(['/admin-profile']);
    sessionStorage.setItem("uname", this.userName);

  }else{
  alert("Credentials Don't match Admin")
  this.router.navigate(['/admin-login']);
  }
}

}
