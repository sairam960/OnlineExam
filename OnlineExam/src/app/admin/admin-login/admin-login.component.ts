import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';


@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})

export class AdminLoginComponent {

  adlogin: AdminLogin = new AdminLogin();
  message: String;

  constructor(private adminService: AdminService, private router: Router) {}

  login() {

    console.log(this.adlogin.email);
    console.log(this.adlogin.password);
    this.adminService.loginAdmin(this.adlogin).subscribe(response => {
      //alert(JSON.stringify(response));

      if(response.status == true) {

        let userName = response.name;
        sessionStorage.setItem('userName', userName);
        this.router.navigateByUrl('/admin-profile');
      } else {

        this.message = response.message;
        alert(this.message);
      }
    })    
  }
}

export class AdminLogin  {

  email: String;
  password: String;
}
