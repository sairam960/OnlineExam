import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from '../appmodel/Question';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  addQuestion(question:Question) : Observable<any>{
    let url="http://localhost:8181/addQuestion";
    return this.http.post(url,question);
  }

  logout() :void {
    sessionStorage.clear();
  }

}

