import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EditQuestionService } from 'src/app/appmodel/edit-question.service';
import { ExamDetails } from 'src/app/appmodel/ExamDetails';
import { RemoveQuestionService } from 'src/app/appmodel/remove-question.service';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-remove-question',
  templateUrl: './remove-question.component.html',
  styleUrls: ['./remove-question.component.css']
})

export class RemoveQuestionComponent  {

  searchInput: SearchInput = new SearchInput();
  details: ExamDetails[] = [];
  detailsDelete: ExamDetails[] = [];
  result:any = [];

  constructor(private adservice: AdminService, private router: Router, private service: RemoveQuestionService, private edit: EditQuestionService) { }

  adminLogout() {
    this.adservice.logout();
    this.router.navigateByUrl("/");
  }

  goBack() {
    this.router.navigateByUrl("/admin-profile");
  }

  getQuestion() {
    console.log(this.searchInput.subject);

    this.service.fetchQuestionDetails(this.searchInput).subscribe( data => {
      //alert(JSON.stringify(data));
      this.result = data;

      for(var i = 0; i < this.result.length; i++) {
        
        var detail: ExamDetails = new ExamDetails();
        
        detail.questionId = data[i].questionId;
        detail.level = data[i].level;
        detail.question = data[i].question;
        detail.option1 = data[i].option1;
        detail.option2 = data[i].option2;
        detail.option3 = data[i].option3;
        detail.option4 = data[i].option4;
        detail.answer = data[i].answer;
        detail.status = data[i].status;

        if(detail.status == "Active"){
          this.details.push(detail);
        }
      }
    })
  }

  getDeletedQuestion() {
    console.log(this.searchInput.subject);

    this.service.fetchQuestionDetails(this.searchInput).subscribe( data => {
      //alert(JSON.stringify(data));
      this.result = data;

      for(var i = 0; i < this.result.length; i++) {
        
        var detailDelete: ExamDetails = new ExamDetails();
        
        detailDelete.questionId = data[i].questionId;
        detailDelete.level = data[i].level;
        detailDelete.question = data[i].question;
        detailDelete.option1 = data[i].option1;
        detailDelete.option2 = data[i].option2;
        detailDelete.option3 = data[i].option3;
        detailDelete.option4 = data[i].option4;
        detailDelete.answer = data[i].answer;
        detailDelete.status = data[i].status;

        if(detailDelete.status == "Inactive"){
          this.detailsDelete.push(detailDelete)
        }
      }
    })
  }

  deleteQuestion(id: number) {

    this.details.forEach((element,index)=>{  
      if(element.questionId == id) delete this.details[index];  
   });
    this.service.deleteQuestions(id).subscribe( data => {
    });
    alert("Row deleted");
  }

  activateQuestion(id: number) {

    this.detailsDelete.forEach((element, index)=> {
      if(element.questionId == id) delete this.detailsDelete[index];
    });

    console.log(id);
    this.edit.editStatus(id).subscribe( data => {
    });
    alert("Question Activated");
  }

}

export class SearchInput {

  subject:String;
}



