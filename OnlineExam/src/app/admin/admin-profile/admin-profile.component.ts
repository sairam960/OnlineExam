import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent {

  constructor(private router: Router, private adservice: AdminService) { }

  addQuestions() {
    this.router.navigateByUrl("/add-question");
  }

  removeQuestions() {
    this.router.navigateByUrl("/remove-questions")
  }

  viewReports() {
    this.router.navigateByUrl("/admin-report")
  }

  adminLogout() {
    this.adservice.logout();
    this.router.navigateByUrl("/");
  }

}
