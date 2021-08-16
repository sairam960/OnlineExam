import { Component, OnInit } from '@angular/core';
import { StudentData } from '../student-data';
import { StudentdataService } from '../studentdata.service';
import { Router } from '@angular/router'  
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  stud:StudentData;
  date:NgbDate;
  newDate:Date;
  constructor(private studservice:StudentdataService, private router:Router) { 
    this.stud=new StudentData();
    
  }

  ngOnInit(): void {
  }

  savedata(){

    this.newDate=new Date(
      this.date.year,
      this.date.month-1,
      this.date.day

    );
    this.stud.dob=this.newDate.toLocaleDateString();
    this.studservice.addNewStudent(this.stud).subscribe(
      (data)=>{
        console.log("return Value from REST"+data)
      } 
    )  
    console.log(this.stud)
    alert("Student Register! Please click OK and Proceed to Login")
    this.router.navigate(['/student-loginLink']);
  }
}
