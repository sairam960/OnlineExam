import { Component, OnInit, ViewChild } from '@angular/core';
import { NgxCsvParser, NgxCSVParserError } from 'ngx-csv-parser';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  SubjectName:string='';
  level:number=0;
  selectChangeHandler(event:any)
  {
    this.SubjectName=event.target.value;
  }
  selectChangesHandler(event:any)
  {
    this.level=event.target.value;
  }
  csvRecords: any[] = [];
  header: boolean = true;

  constructor(private ngxCsvParser: NgxCsvParser) {
  }

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

  ngOnInit(): void {
  }

}
