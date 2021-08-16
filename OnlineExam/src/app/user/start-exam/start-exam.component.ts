import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-start-exam',
  templateUrl: './start-exam.component.html',
  styleUrls: ['./start-exam.component.css']
})
export class StartExamComponent implements OnInit {

  checked:boolean=false;

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  start(){
      this.router.navigateByUrl('test-start');
      //let win =window.open("test-start","_blank","width=500, height=500");
  }
}
