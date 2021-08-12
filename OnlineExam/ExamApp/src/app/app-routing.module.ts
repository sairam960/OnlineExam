import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { InstructionComponent } from './instruction/instruction.component';
import { ExampageComponent } from './exampage/exampage.component';
import { AddComponent } from './add/add.component';
import { SearchComponent } from './search/search.component';
const routes: Routes = [
  {
    path: 'homeLink', component: HomeComponent
  },
  {
    path: 'loginLink', component: LoginComponent
  },
  {
    path: 'registerLink', component: RegisterComponent
  },
  {
    path: 'addComponent', component:AddComponent
  },
  {path:'JavaTest',component:InstructionComponent},
  {path:'DBMSTest',component:InstructionComponent},
  {path:'PythonTest',component:InstructionComponent},
  {path:'AngularTest',component:InstructionComponent},
  {path:'ExamPage',component:ExampageComponent},
  {path:'Search', component:SearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
