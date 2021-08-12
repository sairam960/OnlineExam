import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router,ParamMap } from '@angular/router';

@Component({
  selector: 'app-exampage',
  templateUrl: './exampage.component.html',
  styleUrls: ['./exampage.component.css']
})
export class ExampageComponent implements OnInit {


  constructor(private router:Router, private route:ActivatedRoute) { }
  gotohome()
  {
    this.router.navigate(['/homeLink'])
  }
  ngOnInit(): void {
  }

  submitsub(subject:String)
  {
    this.router.navigate(['instruction',subject]);
    console.log(subject);
  }

}
