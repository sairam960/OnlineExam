import { Component, OnInit } from '@angular/core';

 declare function checkAnswer():void 
   
 

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  constructor() {
    checkAnswer()
   }
 
  
 
  ngOnInit() {
    
  }

}
