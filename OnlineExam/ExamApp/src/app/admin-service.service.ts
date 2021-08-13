import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from './question';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  constructor(private http:HttpClient) { }

  addQuestion(question:Question) : Observable<any>{
    let url="http://localhost:9799/questiondata/api/add";
    return this.http.post(url,question);
  }
}
