import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { InstructionComponent } from './instruction/instruction.component';
import { ExampageComponent } from './exampage/exampage.component';
import { AddComponent } from './add/add.component';
import { SearchComponent } from './search/search.component';
import { StudentLoginComponent } from './student-login/student-login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { NotClearComponent } from './not-clear/not-clear.component';
import { NextLevelComponent } from './next-level/next-level.component';
import { ReportComponent } from './report/report.component';
import { AdminquesComponent } from './adminques/adminques.component';
import { StudentdashboardComponent } from './studentdashboard/studentdashboard.component';
import { QuestionsComponent } from './questions/questions.component';
import { AboutUsComponent} from'./about-us/about-us.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'homeLink', component: HomeComponent
  },
  {
    path: 'student-loginLink', component: StudentLoginComponent
  },
  {
    path: 'admin-loginLink', component: AdminLoginComponent
  },
  {
    path: 'registerLink', component: RegisterComponent
  },
  {
    path: 'addComponent', component:AddComponent
  },

  {
    path: 'notclear',component:NotClearComponent
  },
  {
    path:'nextlevel',component:NextLevelComponent
  },
  {
    path:'report',component:ReportComponent
  },
  {path:'JavaTest',component:InstructionComponent},
  {path:'DBMSTest',component:InstructionComponent},
  {path:'PythonTest',component:InstructionComponent},
  {path:'AngularTest',component:InstructionComponent},
  {path:'ExamPage',component:ExampageComponent},
  {path:'searchLink', component:SearchComponent},
  {path:'adminques',component:AdminquesComponent},
  {path:'studentdashboard',component:StudentdashboardComponent},
  {path:'questions',component:QuestionsComponent},
  {path:'aboutusLink',component:AboutUsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
