import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentData } from '../student-data';
import { StudentdataService } from '../studentdata.service';

@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent implements OnInit {

 stud1:StudentData;
  
  constructor(private studservice:StudentdataService, private router:Router) {
    this.stud1=new StudentData();
   }

  ngOnInit(): void {
  }

  loginStudent(){
    this.studservice.loginStudentFromRemote(this.stud1).subscribe(
      (_data) => {
        console.log("response recieved")
        this.router.navigate(['/ExamPage']);
      },
      (_error) => {
        console.log("exception occured");
      alert("Credentials not found! Please Register First");
      }
    )
  }
}
