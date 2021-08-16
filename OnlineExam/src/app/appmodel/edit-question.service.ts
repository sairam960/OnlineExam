import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CurrentQuestion } from '../CurrentQuestion';

@Injectable({
  providedIn: 'root'
})
export class EditQuestionService {

  constructor(private http: HttpClient) { }

  questionDetails(quesId: CurrentQuestion): Observable<any> {
    let url = "http://localhost:8181/getQuestion?id="+quesId.questionId;
    return this.http.get(url);
  }

  editQuestion(id: number, question: String): Observable<object> {
    let url="http://localhost:8181/editQuestion?id="+id+"&question="+question;
    return this.http.get(url);
  }

  editLevel(id: number, level: number): Observable<object> {
    let url="http://localhost:8181/editLevel?id="+id+"&level="+level;
    return this.http.get(url);
  }

  editOptionOne(id: number, option: String): Observable<object> {
    let url="http://localhost:8181/editOptionOne?id="+id+"&option="+option;
    return this.http.get(url);
  }

  editOptionTwo(id: number, option: String): Observable<object> {
    let url="http://localhost:8181/editOptionTwo?id="+id+"&option="+option;
    return this.http.get(url);
  }

  editOptionThree(id: number, option: String): Observable<object> {
    let url="http://localhost:8181/editOptionThree?id="+id+"&option="+option;
    return this.http.get(url);
  }

  editOptionFour(id: number, option: String): Observable<object> {
    let url="http://localhost:8181/editOptionFour?id="+id+"&option="+option;
    return this.http.get(url);
  }

  editAnswer(id: number, answer: String): Observable<object> {
    let url="http://localhost:8181/editAnswer?id="+id+"&answer="+answer;
    return this.http.get(url);
  }

  editStatus(id: number): Observable<object> {
    let url="http://localhost:8181/editStatus?id="+id;
    return this.http.get(url);
  }
}
