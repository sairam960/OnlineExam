import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'src/app/appmodel/Subject';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-select-exam',
  templateUrl: './select-exam.component.html',
  styleUrls: ['./select-exam.component.css']
})
export class SelectExamComponent {
  
    subjects:Subject[]=[];
    result:any = [];
    imageurl:String='/assets/images/'; 
    constructor(private service:UserService,private router:Router){}

    ngOnInit():void{
      this.getSubjectsDetails();
    }

    
    getSubjectsDetails(){
    
        this.service.getSubjects().subscribe(response=>{
            //alert(JSON.stringify(response));
            this.result=response;
            for(let i=0;i<this.result.length;i++){
              var sub:Subject=new Subject();
              sub.id=response[i].subjectId;
              sub.name=response[i].name;
              sub.imageUrl=this.imageurl.concat(sub.name.toString()).concat(".png");
              console.log(sub.imageUrl)
              this.subjects.push(sub);
          }
        })
        
    }

    navigate(subjectId:number,subjectName:String){
      //console.log(subjectId);
      sessionStorage.setItem('subjectId',String(subjectId));
      sessionStorage.setItem('subjectName',subjectName.toString());
      this.router.navigateByUrl('/start-exam');
    }
}