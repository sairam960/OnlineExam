import { Component, OnInit } from '@angular/core';
import { Exam } from 'src/app/appmodel/Exam';
import { UserService } from 'src/app/user.service';


@Component({
  selector: 'app-test-report',
  templateUrl: './test-report.component.html',
  styleUrls: ['./test-report.component.css']
})
export class TestReportComponent implements OnInit {

  constructor(private service:UserService) { }

  message:String;
  score:number;
  level:number;
  subject:String;


  exam:Exam=new Exam();

  ngOnInit(): void {
    
     this.exam.examId=+localStorage.getItem('examId');
     this.exam.user.userId=+sessionStorage.getItem('userId');
     this.exam.subject.subjectId=+sessionStorage.getItem('subjectId');
     this.exam.level=+localStorage.getItem('levelId');
    //  alert(this.exam.examId);
    //  alert(this.exam.user.userId);
    //  alert(this.exam.subject.subjectId);
    //  alert(this.exam.level);
     this.setReportStatus()
  }

  setReportStatus(){
      this.service.getTestReport(this.exam).subscribe(response=>{
          this.message=response.message;
          alert(this.message);
          this.score=response.marks;
          this.level=response.level;
          this.subject=sessionStorage.getItem('subjectName');
      })
  }
}
