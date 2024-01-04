import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminReportService } from 'src/app/appmodel/admin-report.service';
import { AdminService } from '../admin.service';


@Component({
  selector: 'app-admin-report',
  templateUrl: './admin-report.component.html',
  styleUrls: ['./admin-report.component.css']
})
export class AdminReportComponent {

  searchInput: SearchInput = new SearchInput();
  detailsArray: DataResponse[] = []; 
  exams: ExamInfo[] = []; 
  result: any = [];
  response: any;
  status: any;
  total: number;
  passCount: number;
  failCount: number;
 


  constructor(private service: AdminReportService, private adservice: AdminService, private router: Router) { }

  submitDetails() {
    console.log(this.searchInput.subject);
    console.log(this.searchInput.state);
    console.log(this.searchInput.city);
    console.log(this.searchInput.level);
    this.service.fetchStudentsDetails(this.searchInput).subscribe(data => {
      //alert(JSON.stringify(data));
      this.result = data;

      if(this.result == null){
        alert("No Such User Found");
      }

      for(var i = 0; i < this.result.length; i++) {
        
        var detail: DataResponse = new DataResponse();
        
        detail.userId = data[i].userId;
        detail.name = data[i].name;
        detail.emailId = data[i].emailId;
        detail.password = data[i].password;
        detail.mobileNo = data[i].mobileNo;
        detail.city = data[i].city;
        detail.state = data[i].state;
        detail.dateOfBirth = data[i].dateOfBirth;
        detail.qualification = data[i].qualification;
        detail.yearOfCompletion = data[i].yearOfQualification;

        console.log(detail.yearOfCompletion);

        this.detailsArray.push(detail);
      }
    });



  }

  getExamInfo() {
    this.service.getExamDetails(this.searchInput).subscribe(response =>{
      //alert(JSON.stringify(response));
      this.result = response;

      this.passCount=0;
      
      for(var i = 0; i < this.result.length; i++) {

        var exam: ExamInfo = new ExamInfo();

        exam.status = response[i].status;
        console.log(exam.status);
        

        if(exam.status == true){
          console.log(exam.status);
          
          this.passCount = this.passCount + 1;
        }

        this.failCount = this.result.length - this.passCount;
        
      }

      console.log(this.passCount);  
      console.log(this.failCount);
      
      this.passCount = this.passCount ;
      this.failCount = this.failCount;
      this.total = this.passCount + this.failCount;

    });
  }

  adminLogout() {
    this.adservice.logout();
    this.router.navigateByUrl("/");
  }

  goBack() {
    this.router.navigateByUrl("/admin-profile");
  }
}

export class SearchInput {

  subject: String;
  state: String;
  city: String;
  level: number;
}

export class DataResponse {
  
  userId: number;
  name: String;
  emailId: String;
  password: String;
  mobileNo: number;
  city: String;
  state: String;
  dateOfBirth: Date;
  qualification: String;
  yearOfCompletion: Date;
}

export class ExamInfo {

  examId: number;
  marks: number;
  level: number;
  startTime: Date;
  endTime: Date;
  status: any;
}


