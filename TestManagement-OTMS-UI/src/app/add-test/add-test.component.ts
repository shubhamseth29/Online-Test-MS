import { Component, OnInit } from '@angular/core';
import { Test } from '../model/test';
import { TestServices} from '../services/test-services'
import { Observable, observable } from 'rxjs';
@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {

  service:TestServices;
  constructor(service:TestServices) {
    this.service=service;
   }

  ngOnInit(): void {
  }

  addedTest:Test=null;
  addTest(form:any)
  {
    let details=form.value;
    let testId=details.id;
    let testTitle=details.title;
    let testTotalMarks=details.totalMarks;
    let testDuration=details.duration;
    let testStartTime=details.startTime;
    let testEndTime=details.endTime;

    this.addedTest=new Test();
    this.addedTest.testId=testId;
    this.addedTest.testTotalMarks=testTotalMarks;
    this.addedTest.testTitle=testTitle;
    this.addedTest.testDuration=testDuration;
    this.addedTest.testStartTime=testStartTime;
    this.addedTest.testEndTime=testEndTime;
    
    
    let result:Observable<Test>=this.service.addTest(this.addedTest);
    result.subscribe((test:Test)=>{
      this.addedTest=test;
      console.log(testStartTime);
    },
    err=>{
      console.log("error="+err)
    }
    );
    
    form.reset;
  }
  
  }

