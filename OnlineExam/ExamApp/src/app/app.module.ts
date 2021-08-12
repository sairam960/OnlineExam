import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { NgxCsvParserModule} from 'ngx-csv-parser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ReportComponent } from './report/report.component';
import { RegisterComponent } from './register/register.component';
import { ExampageComponent } from './exampage/exampage.component';
import { InstructionComponent } from './instruction/instruction.component';
import { AddComponent } from './add/add.component';
import { SearchComponent } from './search/search.component';
import { StudentLoginComponent } from './student-login/student-login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HttpClientModule} from '@angular/common/http';
import { NotClearComponent } from './not-clear/not-clear.component';
import { NextLevelComponent } from './next-level/next-level.component';
import { AdminquesComponent } from './adminques/adminques.component';
import { StudentdashboardComponent } from './studentdashboard/studentdashboard.component';
import { QuestionsComponent } from './questions/questions.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ReportComponent,
    RegisterComponent,
    ExampageComponent,
    InstructionComponent,
    AddComponent,
    SearchComponent,
    StudentLoginComponent,
    AdminLoginComponent,
    NotClearComponent,
    NextLevelComponent,
    AdminquesComponent,
    StudentdashboardComponent,
    QuestionsComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxCsvParserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
