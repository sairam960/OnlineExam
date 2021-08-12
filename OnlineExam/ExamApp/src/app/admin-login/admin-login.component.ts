import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  userName:string;
  password:string;
  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  checkadmin(){
    
    if(this.userName=="Admin" && this.password=="Admin@123"){
      this.router.navigate(['/adminques']);
      sessionStorage.setItem("uname", this.userName);

    }else{
    this.router.navigate(['/admin-loginLink']);
    }
  }
}
