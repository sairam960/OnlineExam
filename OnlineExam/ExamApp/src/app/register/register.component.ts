import { Component, OnInit } from '@angular/core';
import { StudentData } from '../student-data';
import { StudentdataService } from '../studentdata.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  stud:StudentData;

  constructor(private studservice:StudentdataService) { 
    this.stud=new StudentData();
  }

  ngOnInit(): void {
  }

  savedata(){

    this.studservice.addNewStudent(this.stud).subscribe(
      (data)=>{
        console.log("return Value from REST"+data)
      }
    )
  }
}
