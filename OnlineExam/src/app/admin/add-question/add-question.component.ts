import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from 'src/app/appmodel/Question';
import { Subject } from 'src/app/appmodel/Subject';
import { UserService } from 'src/app/user.service';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent {

  constructor(private adminService:AdminService,private userService:UserService,private router: Router) { }

  question:Question=new Question();
  subject:Subject=new Subject();
  subjects:Subject[]=[];
  imageurl:String='/assets/images/'; 
  result:any=[];
  
  ngOnInit():void{
    this.getSubjects();
  }
  addQuestion(){
    alert(JSON.stringify(this.question));
    this.question.subject.name="Java";
    this.question.subject.id=100;
    
      this.adminService.addQuestion(this.question).subscribe(response=>{
        alert(JSON.stringify(response));
    })
  }

  getSubjects(){
      this.userService.getSubjects().subscribe(response=>{
          this.result=response;
          for(let i=0;i<this.result.length;i++){
            var sub:Subject=new Subject();
            sub.id=response[i].subjectId;
            sub.name=response[i].name;
            sub.imageUrl=this.imageurl.concat(sub.name.toString()).concat(".png");
            this.subjects.push(sub);
          }
      })
  }

  adminLogout() {
    this.adminService.logout();
    this.router.navigateByUrl("/");
  }

  goBack() {
    this.router.navigateByUrl("/admin-profile");
  }
}
