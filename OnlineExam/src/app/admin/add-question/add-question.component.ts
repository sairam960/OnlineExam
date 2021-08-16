import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from '../../appmodel/Question';
import { Subject } from '../../appmodel/Subject';
import { UserService } from '../../user.service';
import { AdminService } from '../admin.service';
import { NgxCsvParser, NgxCSVParserError } from 'ngx-csv-parser';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent {

  constructor(private ngxCsvParser: NgxCsvParser,private adminService:AdminService,private userService:UserService,private router: Router) { }

  question:Question=new Question();
  subject:Subject=new Subject();
  subjects:Subject[]=[];
  imageurl:String='/assets/images/'; 
  result:any=[];
  csvRecords: any[] = [];
  header: boolean = true;
  
  ngOnInit():void{
    this.getSubjects();
  }

  fileChangeListener($event: any): void {

    const files = $event.srcElement.files;
    this.header = (this.header as unknown as string) === 'true' || this.header === true;
    this.ngxCsvParser.parse(files[0], { header: this.header, delimiter: '|' })
      .pipe().subscribe((result: any) => {
        console.log('Result', result);
        this.csvRecords = result;
      }, (error: NgxCSVParserError) => {
        console.log('Error', error);
      });
  } 
  addQuestion(){
    alert(JSON.stringify(this.question));
    this.question.subject.name="Java";
    this.question.subject.id=100;

    this.csvRecords.forEach(element => {
      this.question.question=element.question;
      this.question.option1=element.option1;
      this.question.option2=element.option2;
      this.question.option3=element.option3;
      this.question.option4=element.option4;
      this.question.answer=element.answer;
      console.log(this.question)
      this.adminService.addQuestion(this.question).subscribe(response=>{
        alert(JSON.stringify(response));
    })
    });
      //this.adminService.addQuestion(this.question).subscribe(response=>{
        //alert(JSON.stringify(response));
   // })
  }

  getSubjects(){
      this.userService.getSubjects().subscribe(response=>{
          this.result=response;
          for(let i=0;i<this.result.length;i++){
            var sub:Subject=new Subject();
            sub.id=response[i].subjectId;
            sub.name=response[i].name;
            sub.imageUrl=this.imageurl.concat(sub.name.toString()).concat(".png");
            this.subjects.push(sub);
          }
      })
  }

  adminLogout() {
    this.adminService.logout();
    this.router.navigateByUrl("/");
  }

  goBack() {
    this.router.navigateByUrl("/admin-profile");
  }
}
