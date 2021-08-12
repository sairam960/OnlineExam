import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-exampage',
  templateUrl: './exampage.component.html',
  styleUrls: ['./exampage.component.css']
})
export class ExampageComponent implements OnInit {

  constructor(private route:Router) { }
  gotohome()
  {
    this.route.navigate(['/homeLink'])
  }
  ngOnInit(): void {
  }

}
