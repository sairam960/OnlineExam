import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-test-end',
  templateUrl: './test-end.component.html',
  styleUrls: ['./test-end.component.css']
})
export class TestEndComponent implements OnInit {

  correct:number;
  level:number=1;
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
    
    this.router.navigateByUrl('start-exam');
  }

  start1(){
    this.router.navigateByUrl('start-exam');
  }

}
