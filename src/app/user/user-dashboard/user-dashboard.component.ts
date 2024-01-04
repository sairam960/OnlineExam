import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user.service';
import { User } from 'src/app/appmodel/Register';
import { LoggedInUser } from 'src/app/appmodel/LoggedInUser';
import { SharedServiceService } from 'src/app/shared-service.service';


@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent  {

  subject:String;
 lg : LoggedInUser = new LoggedInUser;
             
 ngOnInit(): void {
  this.lg.userId =(Number) (sessionStorage.getItem('userId'));
  this.loggedInUser();
  this.subject=this.report.getSubjectName();
  //alert(this.subject+"this is value from getter");
 }

fetched:boolean = false;
name:String;
email:String;
qualification:String;

response:any;
 constructor(private service: UserService,private router: Router,private report:SharedServiceService) { }

 loggedInUser() {
        this.service.userDetails(this.lg).subscribe(response => {
         this.name = response.name;
         this.email = response.emailId;
         this.qualification = response.qualification;
         this.fetched =true;
          })
}

}

