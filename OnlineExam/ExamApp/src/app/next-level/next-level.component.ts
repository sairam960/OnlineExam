import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-next-level',
  templateUrl: './next-level.component.html',
  styleUrls: ['./next-level.component.css']
})
export class NextLevelComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
goto()
{
  this.router.navigate(['/homeLink']);
}
}
