import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { element } from 'protractor';

@Component({
  selector: 'app-test-end',
  templateUrl: './test-end.component.html',
  styleUrls: ['./test-end.component.css']
})
export class TestEndComponent implements OnInit {

  correct:number;
  level:number=1;
  retests:number=0;
  marks:number;


  constructor(private router:Router) { }

  ngOnInit(): void {
      this.marks=+localStorage.getItem('marks');
      if(this.marks>=10)
      {
        this.level=+localStorage.getItem('levelNext');
      }
      else
      {
        localStorage.setItem('levelNext',String(this.level));
      }
      this.correct=this.marks/2;
  }

  report(){
    this.router.navigateByUrl('test-report');
  }

  start(){
    if(this.retests==0){
      alert("You should wait atleast 5 seconds for Retest");
      var element = <HTMLInputElement> document.getElementsByName("Retest")[0] ;
      element.disabled = true;
      setTimeout(function(){  
        alert("You can take your Retest now");
        element.disabled = false; 
    },6000);
      this.retests=1;
    }
    else{
      this.retests=0;
    this.router.navigateByUrl('start-exam');}
  }

  start1(){
    this.router.navigateByUrl('start-exam');
  }

}
