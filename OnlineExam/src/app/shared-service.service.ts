import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
    providedIn:'root'
})
export class SharedServiceService {

   data:any;
   subjectName:any;
   level:number;
   score:number;
   message:String;

  constructor() { }

  getData(){
      return this.data;
  }
  setData(data){
      this.data=data;
  }
  getSubjectName(){
      return this.subjectName;
  }
  setSubjectName(name){
      this.subjectName=name;
  }

  getLevel(){
      return this.level;
  }
  setLevel(level:number){
      this.level=level;
  }
  getScore(){
      return this.score;
  }
  setScore(score:number){
      this.score=score;
  }
  getMessage():String{
      //alert(this.message+"this message is from getter");
      return this.message;
  }
  setMessage(message:String){
     
      this.message=message;
      //alert(this.message+"this message is from setter");
  }

}
