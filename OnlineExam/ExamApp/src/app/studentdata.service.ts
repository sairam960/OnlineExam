import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StudentData } from './student-data';

@Injectable({
  providedIn: 'root'
})
export class StudentdataService {

  constructor(private httpClient:HttpClient) { }

  baseUrl:string="http://localhost:9799/studentdata/api";

  //adding new student
  addNewStudent(student:StudentData){
    return this.httpClient.post(this.baseUrl+"/students",student)

  }

}
