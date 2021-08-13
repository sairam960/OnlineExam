import { Component, OnInit } from '@angular/core';
import { EmailValidator } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent implements OnInit {

 userName:string;
 password:string;
  
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  loginStudent(){

  }
}
