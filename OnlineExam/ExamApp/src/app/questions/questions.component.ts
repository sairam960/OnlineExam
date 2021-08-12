import { Component, OnInit } from '@angular/core';

 declare var checkAnswer: any;

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  constructor() { }
 CallcheckAnswer()
 {
   checkAnswer()
 }
  ngOnInit() {
    
  }

}
