import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NgxCsvParser, NgxCSVParserError } from 'ngx-csv-parser';
import { AdminServiceService } from '../admin-service.service';
import { Question } from '../question';
import { Subject } from '../subject';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
 
  
  csvRecords: any[] = [];
  header: boolean = true;

  constructor(private ngxCsvParser: NgxCsvParser, private adminservice:AdminServiceService,private router:Router) {
  }
  ques:Question;
  sub:Subject;

  @ViewChild('fileImportInput') fileImportInput: any;

  fileChangeListener($event: any): void {

    const files = $event.srcElement.files;
    this.header = (this.header as unknown as string) === 'true' || this.header === true;
    this.ngxCsvParser.parse(files[0], { header: this.header, delimiter: '|' })
      .pipe().subscribe((result: any) => {
        console.log('Result', result);
        this.csvRecords = result;
      }, (error: NgxCSVParserError) => {
        console.log('Error', error);
      });
  }

  addQuestion()
  {
   
    this.csvRecords.forEach(element => {this.ques=element;
      
      
      console.log(this.ques)
      this.adminservice.addQuestion(this.ques).subscribe(
        (data)=>{
          console.log("return Value from REST"+data)
        }
      )  
    });
    
    
    alert("Questions Added")

  }

  ngOnInit(): void {
  }

}
