import { Component, OnInit } from '@angular/core';
import { TestServices} from '../services/test-services'
import { Test } from '../model/test';
import { Observable, observable } from 'rxjs';
@Component({
  selector: 'app-update-test',
  templateUrl: './update-test.component.html',
  styleUrls: ['./update-test.component.css']
})
export class UpdateTestComponent implements OnInit {

  service:TestServices;
  constructor(service:TestServices) {
    this.service=service;
   }

  ngOnInit(): void {
  }

  updatedTest:Test=null;
  updateTest(form:any)
  {
    let details=form.value;
    let testId=details.id;
    let testTitle=details.title;
    let testTotalMarks=details.totalMarks;
    let testDuration=details.duration;
    let testStartTime=details.startTime;
    let testEndTime=details.endTime;

    this.updatedTest=new Test();
    this.updatedTest.testId=testId;
    this.updatedTest.testTotalMarks=testTotalMarks;
    this.updatedTest.testTitle=testTitle;
    this.updatedTest.testDuration=testDuration;
    this.updatedTest.testStartTime=testStartTime;
    this.updatedTest.testEndTime=testEndTime;
    
    let result:Observable<Test>=this.service.updateTest(testId,this.updatedTest);
    result.subscribe((test:Test)=>{
      this.updatedTest=test;
    },
    err=>{
      console.log("error="+err)
    }
    );
    
    form.reset;

  }

}
