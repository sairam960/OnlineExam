import { Subject } from "./subject";

export class Question {

    questionId:Number;
    question:String;
    option1:String;
    option2:String;
    option3:String;
    option4:String;
    answer:String;
    sub:Subject=new Subject();
    level:String;

}
