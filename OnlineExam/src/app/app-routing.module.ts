import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddQuestionComponent } from './admin/add-question/add-question.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminProfileComponent } from './admin/admin-profile/admin-profile.component';
import { AdminReportComponent } from './admin/admin-report/admin-report.component';
import { EditQuestionsComponent } from './admin/edit-questions/edit-questions.component';
import { RemoveQuestionComponent } from './admin/remove-question/remove-question.component';
import { ForgotPasswordComponent } from './user/forgot-password/forgot-password.component';
import { HomePageComponent } from './user/home-page/home-page.component';
import { LoginComponent } from './user/login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { SelectExamComponent } from './user/select-exam/select-exam.component';
import { StartExamComponent } from './user/start-exam/start-exam.component';
import { TestEndComponent } from './user/test-end/test-end.component';
import { TestReportComponent } from './user/test-report/test-report.component';
import { TestComponent } from './user/test/test.component';
import { UserDashboardComponent } from './user/user-dashboard/user-dashboard.component';
import { UserReportComponent } from './user/user-report/user-report.component';


const routes: Routes = [

  {path:'',component:HomePageComponent},
  {path:'home-page',component:HomePageComponent},
  {path:'user-login',component:LoginComponent},
  {path:'user-register',component:RegisterComponent},
  {path:'admin-login',component:AdminLoginComponent},
  {path:'forgot-password',component:ForgotPasswordComponent},
  {path:'select-exam',component:SelectExamComponent},
  {path:'user-dashboard',component: UserDashboardComponent},
  {path:'test-start',component:TestComponent},
  {path:'test-report',component:TestReportComponent},
  {path:'start-exam',component:StartExamComponent},
  {path:'add-question',component:AddQuestionComponent},
  {path:'test-end',component:TestEndComponent},
  {path:'admin-profile',component:AdminProfileComponent},
  {path:'remove-questions',component:RemoveQuestionComponent},
  {path:'admin-report',component:AdminReportComponent},
  {path:'edit-question', component:EditQuestionsComponent},
  {path:'user-report',component:UserReportComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
