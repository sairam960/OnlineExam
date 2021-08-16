import { Component, OnInit } from '@angular/core';
import { Exam } from 'src/app/appmodel/Exam';
import { SharedServiceService } from 'src/app/shared-service.service';
import { UserService } from 'src/app/user.service';
import { GoogleChartsModule } from 'angular-google-charts';


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
  data:any;
  right:number;
  wrong:number;
  notAnswered:number=0;
  title = 'Test Report';
  type = 'PieChart';
  data1: any;
  height = 600;
  width = 600;
  options = {
    colors: ['#00ff00', '#FF0000', '#696969'], is3D: true
  };

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
        //alert(JSON.stringify(response));
          this.message=response.message;
          alert(this.message);
          this.score=response.marks;
          this.level=response.level;
          this.subject=sessionStorage.getItem('subjectName');
          this.right=this.score*5;
          console.log(this.right);
          this.wrong=100-this.right;
          this.data1 = [
            ['Right Answer',this.right],
            ['Wrong Answer',this.wrong],
            ['Not Answered',this.notAnswered],
          ];
      })
  }
}
