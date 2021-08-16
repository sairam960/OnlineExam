import { LoggedInUser } from "./LoggedInUser";
import { Sub } from "./Sub";

export class Exam{
    examId:number;
    marks : number;
    level : number;
    user: LoggedInUser = new LoggedInUser();
    subject: Sub = new Sub();
}