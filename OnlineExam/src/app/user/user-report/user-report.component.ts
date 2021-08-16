import { Component, OnInit } from '@angular/core';
import { LoggedInUser } from '../../appmodel/LoggedInUser';
import { User } from '../../appmodel/Register';
import { UserService } from '../../user.service';


@Component({
  selector: 'app-user-report',
  templateUrl: './user-report.component.html',
  styleUrls: ['./user-report.component.css']
})
export class UserReportComponent implements OnInit {


  result: any = [];
  user: User = new User();
  user1: LoggedInUser = new LoggedInUser();
  marks:number;
  subjectName:string;
  data1: any=[];
  data = [];
  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.getReportDetails();
  }




  getReportDetails() {
    this.user1.userId = +sessionStorage.getItem('userId');
    this.user.name = sessionStorage.getItem('userName');
    this.service.getUserReport(this.user1.userId).subscribe(response => {
    this.result = response;
      
    })
  }

}
