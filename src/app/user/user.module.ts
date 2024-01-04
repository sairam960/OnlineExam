import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HomePageComponent } from './home-page/home-page.component';
import { FormsModule } from '@angular/forms';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { RouterModule } from '@angular/router';
import { UserReportComponent } from './user-report/user-report.component';
import { SelectExamComponent } from './select-exam/select-exam.component';
import { StartExamComponent } from './start-exam/start-exam.component';
import { TestComponent } from './test/test.component';
import { TestEndComponent } from './test-end/test-end.component';
import { TestReportComponent } from './test-report/test-report.component';
import { GoogleChartsModule } from 'angular-google-charts';




@NgModule({
  declarations: [LoginComponent, RegisterComponent, ForgotPasswordComponent, HomePageComponent, UserDashboardComponent, UserReportComponent, SelectExamComponent, StartExamComponent, TestComponent, TestEndComponent, TestReportComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    GoogleChartsModule
  ],
  
  exports:[
    LoginComponent,
     RegisterComponent,
     ForgotPasswordComponent,
     HomePageComponent,
     GoogleChartsModule

  ]
})
export class UserModule { }
