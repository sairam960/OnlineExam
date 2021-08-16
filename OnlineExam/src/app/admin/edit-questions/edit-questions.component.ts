import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EditQuestionService } from 'src/app/appmodel/edit-question.service';
import { ExamDetails } from 'src/app/appmodel/ExamDetails';
import { CurrentQuestion } from 'src/app/CurrentQuestion';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-edit-questions',
  templateUrl: './edit-questions.component.html',
  styleUrls: ['./edit-questions.component.css']
})
export class EditQuestionsComponent {


  quesId: CurrentQuestion  = new CurrentQuestion();
  detail: ExamDetails = new ExamDetails();
  data: any;

  question:  string;
  level: number;
  option1: string;
  option2: string;
  option3: string;
  option4: string;
  answer: string;

  ngOnInit(): void {
    this.quesId.questionId = (Number) (sessionStorage.getItem('questionId'));
    this.getQuestionDetails();
  }

  constructor(private router: Router, private adservice: AdminService, private edit:EditQuestionService) { }

  getQuestionDetails() {
    this.edit.questionDetails(this.quesId).subscribe( data => {

      this.detail.question = data.question;
      this.detail.level = data.level;
      this.detail.option1 = data.option1;
      this.detail.option2 = data.option2;
      this.detail.option3 = data.option3;
      this.detail.option4 = data.option4;
      this.detail.answer = data.answer;

    })
  }
  
  adminLogout() {
    this.adservice.logout();
    this.router.navigateByUrl("/");
  }

  goBack() {
    this.router.navigateByUrl("/remove-questions");
  }

  newQuestion() {
    console.log(this.quesId.questionId);
    console.log(this.question);
    this.edit.editQuestion(this.quesId.questionId, this.question).subscribe(data => {
    });
    alert("Updation Complete");

  }

  newLevel() {
    console.log(this.quesId.questionId);
    console.log(this.level);
    this.edit.editLevel(this.quesId.questionId, this.level).subscribe(data => {
    });
    alert("Updation Complete");

    
  }

  newOption1() {

    console.log(this.quesId.questionId);
    console.log(this.option1);
    this.edit.editOptionOne(this.quesId.questionId, this.option1).subscribe(data => {
    });
    alert("Updation Complete");
  }

  newOption2() {
    console.log(this.quesId.questionId);
    console.log(this.option2);
    this.edit.editOptionTwo(this.quesId.questionId, this.option2).subscribe(data => {
    });
    alert("Updation Complete");

  }

  newOption3() {
    console.log(this.quesId.questionId);
    console.log(this.option3);
    this.edit.editOptionThree(this.quesId.questionId, this.option3).subscribe(data => {
    });
    alert("Updation Complete");
  }

  newOption4() {
    console.log(this.quesId.questionId);
    console.log(this.option4);
    this.edit.editOptionFour(this.quesId.questionId, this.option4).subscribe(data => {
    });
    alert("Updation Complete");
  }

  newAnswer() {
    console.log(this.quesId.questionId);
    console.log(this.answer);
    this.edit.editOptionOne(this.quesId.questionId, this.answer).subscribe(data => {
    });
    alert("Updation Complete");

  }

}
