import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { FormsModule } from '@angular/forms';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AddQuestionComponent } from './add-question/add-question.component';
import { RemoveQuestionComponent } from './remove-question/remove-question.component';
import { AdminReportComponent } from './admin-report/admin-report.component';
import { EditQuestionsComponent } from './edit-questions/edit-questions.component';




@NgModule({

  imports: [
    CommonModule,
    FormsModule
  ],
  exports:[
   AdminLoginComponent
  ],
  declarations: [AdminLoginComponent, AdminProfileComponent, AddQuestionComponent, RemoveQuestionComponent, AdminReportComponent, EditQuestionsComponent]
})
export class AdminModule { }
