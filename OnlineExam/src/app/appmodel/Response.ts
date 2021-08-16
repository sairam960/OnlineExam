import { Exam } from "./Exam";
import { Question } from "./Question";

export class Response{

    question:Question=new Question();
    exam:Exam=new Exam();
    answer:String;
}