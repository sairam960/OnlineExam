import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-adminques',
  templateUrl: './adminques.component.html',
  styleUrls: ['./adminques.component.css']
})
export class AdminquesComponent implements OnInit {

  constructor(private route:Router) { }
gotoadd()
{
  this.route.navigate(['/addComponent']);
}
  ngOnInit(): void {
  }

}
