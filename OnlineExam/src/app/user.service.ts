import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Login } from './appmodel/Login';
import { User } from './appmodel/Register';
import { LoggedInUser } from './appmodel/LoggedInUser';
import { Sub } from './appmodel/Sub';
import { Exam } from './appmodel/Exam';
import { Response } from './appmodel/Response';
import { Password } from './appmodel/Password';




@Injectable({
  providedIn: 'root'
})

export class UserService {

  
  constructor(private http: HttpClient) { }

  registerUser(user: User) : Observable<object> {
    let url = "http://localhost:8181/register";
   return this.http.post(url,user); 

   }

   login(login :Login):Observable<any>{
      let url = "http://localhost:8181/login";
      return this.http.post(url, login); 
   }

   userDetails(lg:LoggedInUser):Observable<any> {   
     let url = "http://localhost:8181/profile" ;
     return this.http.post(url,lg); 
   }

   getSubjects():Observable<Object>{

      let url="http://localhost:8181/getSubject";
      return this.http.get(url);
   }

   getQuestions(s : Sub):Observable<any>{
     
      let url="http://localhost:8181/questions";
      return this.http.post(url,s);
   }
   saveResult(exam :Exam):Observable<any>{
    let url="http://localhost:8181/insert";
    return this.http.post(url,exam);
 }
  saveResponse(response:Response):Observable<any>{
    let url="http://localhost:8181/save";
    return this.http.post(url,response);
  }

  getTestReport(e:Exam):Observable<any>{
    let url="http://localhost:8181/getTestReport";
    return this.http.post(url,e);
  }

  getUserReport(id: number):Observable<any>{
    let url="http://localhost:8181/userReport?id="+id;
    return this.http.get(url);
  }

  changePassword(password:Password):Observable<any>{
    let url="http://localhost:8181/changepassword";
    return this.http.post(url,password);
  }


}