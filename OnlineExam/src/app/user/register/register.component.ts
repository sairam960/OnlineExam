import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/appmodel/Register';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent  {

user : User = new User(); 

constructor(private service: UserService, private router: Router ) { }

register(f:NgForm) {

  if(f.valid)
  {
   this.service.registerUser(this.user).subscribe(response => {
       alert("User registered successfully! Please Proceed to login");
       this.router.navigate(['/user-login']);
  })
}
else {
 alert("Fill all the  details correctly");
}
}
}


