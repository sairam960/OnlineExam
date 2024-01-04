import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SearchInput } from '../admin/remove-question/remove-question.component';

@Injectable({
  providedIn: 'root'
})
export class RemoveQuestionService {

  constructor(private http: HttpClient) { }

  fetchQuestionDetails(searchInput: SearchInput): Observable<object> {
    let url = "http://localhost:8181/removeQuestions?subjectName="+searchInput.subject;
    return this.http.get(url);
  }

  deleteQuestions(id): Observable<any>{
    let url = "http://localhost:8181/deleteQuestions?questionId="+id
    return this.http.get(url)
  }
}
