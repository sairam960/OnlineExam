import { Component, OnInit, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { Exam } from 'src/app/appmodel/Exam';
import { Question } from 'src/app/appmodel/Question';
import { Response } from 'src/app/appmodel/Response';
import { Sub } from 'src/app/appmodel/Sub';
import { UserResponse } from 'src/app/appmodel/UserResponse';
import { SharedServiceService } from 'src/app/shared-service.service';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent {

  constructor(private router: Router, private service: UserService, private report: SharedServiceService) {
    this.report.setMessage("Hello");
  }


  level_no: number = 1;
  question_no: number = 1;
  total_question: number = 0;
  count: number = 1;
  key: any;
  warning: number = 0;
  questions: Question[] = [];
  marks: any = 0;
  userResponses: UserResponse[] = [];
  result: any = [];
  ele: any;
  ele1: any = [];
  finished: any = 0;

  examId: number;
  res: Response[] = [];

  //temp: UserResponse = new UserResponse();
  e: Exam = new Exam();
  s: Sub = new Sub();


  ngOnInit(): void {
  
    this.getQuestionDetails();
  }



  getQuestionDetails() {
    this.s.subjectId = +sessionStorage.getItem('subjectId');
    this.e.subject.subjectId = this.s.subjectId;
    this.e.user.userId = +sessionStorage.getItem('userId');
    this.e.level = 1;
    this.service.getQuestions(this.s).subscribe(response => {

      this.result = response;
      this.total_question = this.result.length;
      for (let i = 0; i < this.result.length; i++) {
        var ques: Question = new Question();
        ques.questionId = response[i].questionId;
        ques.question = response[i].question;
        ques.option1 = response[i].option1;
        ques.option2 = response[i].option2;
        ques.option3 = response[i].option3;
        ques.option4 = response[i].option4;
        ques.answer = response[i].answer;
        ques.level = response[i].level;
        ques.subject.id = this.s.subjectId;
        this.questions.push(ques);

      }

    })
  }



  option1(i: any) {
    this.ele = this.questions[i].option1;
  }
  option2(i: any) {
    this.ele = this.questions[i].option2;
  }
  option3(i: any) {
    this.ele = this.questions[i].option3;
  }
  option4(i: any) {
    this.ele = this.questions[i].option4;
  }
  counter(i: any) {
    //console.log(i);
    if (i >= this.userResponses.length) {
      let temp: UserResponse = new UserResponse();
      this.ele1[this.question_no - 1] = this.ele;
      temp.userAnswer = this.ele1[this.question_no - 1];
      temp.questionId = this.questions[i].questionId;
      this.userResponses.push(temp);
      //alert(this.ele1);
      if (!(this.count == this.total_question)) {
        this.count = this.count + 1;
        this.question_no = this.count;
        //this.question=this.questions[this.count-2];
      }
    }
    else {
      this.ele1[this.question_no - 1] = this.ele;
      this.userResponses[i].userAnswer = this.ele1[this.question_no - 1];
      //alert(this.ele1);
      if (!(this.count == this.total_question)) {
        this.count = this.count + 1;
        this.question_no = this.count;
        //this.question=this.questions[this.count-2];
      }
    }
  }

  counter1() {
    if (!(this.count == 1)) {
      this.count -= 1;
      this.question_no = this.count;
    }
  }

  change(i: any) {
    this.count = i + 1;
    this.question_no = this.count;
  }

  finish() {
    for (let i = 0; i < this.total_question; i++) {
      if (this.userResponses[i].userAnswer == this.questions[i].answer) {
        this.marks += 2;
      }
    }
    this.finished = 1;
    this.e.marks = this.marks;
    //alert(this.ele1);
    // alert(JSON.stringify(this.userResponses));

    this.service.saveResult(this.e).subscribe(response => {

      //alert(JSON.stringify(response));
      this.report.setData(response);
      localStorage.setItem('examId',String(response.examId));
      localStorage.setItem('levelId',String(this.e.level));
      localStorage.setItem('levelNext',String(this.e.level+1));
      localStorage.setItem('marks',String(response.marks));


      console.log(JSON.stringify(response.examId))

      this.report.setScore(response.marks)
      this.report.setMessage(response.message);
      this.report.setLevel(response.level);
      this.report.setSubjectName(sessionStorage.getItem('subjectName'));

      //alert(JSON.stringify(this.report));
      this.examId = response.examId;
      this.saveUserResponse();
    })


    //one more for loop to call the service
    //window.opener.location = 'test-end';
    //this.router.navigateByUrl('/test-end');
  }

  saveUserResponse() {

    for (let re of this.userResponses) {
      let r: Response = new Response();
      r.question.questionId = re.questionId;
      r.exam.examId = this.examId;
      r.answer = re.userAnswer;
      this.res.push(r);
    }
    for (let re of this.res) {
      //alert(JSON.stringify(re))
      console.log(JSON.stringify(re))
      this.service.saveResponse(re).subscribe(response => {
        // alert(JSON.stringify(response));
        console.log(JSON.stringify(response));
      })
    }
  }

}

