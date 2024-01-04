import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SearchInput } from '../admin/admin-report/admin-report.component';

@Injectable({
  providedIn: 'root'
})
export class AdminReportService {

  constructor(private http:HttpClient) { }

  fetchStudentsDetails(searchInput: SearchInput): Observable<object> {
    let url = "http://localhost:8181/adminReport?subject_name="+searchInput.subject+"&city="+searchInput.city+"&state="+searchInput.state+"&level="+searchInput.level;
    return this.http.get(url);
  }

  getExamDetails(searchInput: SearchInput): Observable<any> {

    let url = "http://localhost:8181/examDetailsReport?subject_name="+searchInput.subject+"&city="+searchInput.city+"&state="+searchInput.state+"&level="+searchInput.level;
    return this.http.get(url);
  }
}
