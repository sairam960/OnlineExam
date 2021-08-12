import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-not-clear',
  templateUrl: './not-clear.component.html',
  styleUrls: ['./not-clear.component.css']
})
export class NotClearComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  goto()
  {
    this.router.navigate(['/homeLink']);
  }
}
