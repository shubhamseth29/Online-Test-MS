import { Component, OnInit } from '@angular/core';
import { TestServices } from '../services/test-services';
import { Observable } from 'rxjs';
import { Test } from '../model/test';

@Component({
  selector: 'app-assign-test',
  templateUrl: './assign-test.component.html',
  styleUrls: ['./assign-test.component.css']
})
export class AssignTestComponent implements OnInit {

  test:Test;
  service:TestServices;
  assigned=null;
  constructor(service:TestServices) 
  { 
    this.service=service;
  }
 
  ngOnInit(): void {
  }
  
  assignTest(form:any)
  { 
    let details=form.value;
    let testId=details.testId;
    let userId=details.userId;
    let response:Observable<Test>=this.service.assignTest(testId,userId);
      response.subscribe
      (
          result=>
          {
            this.test=result;
            console.log(this.test);
            this.assigned="true";
          },
          err=>{
            console.log(err);
            this.assigned="false";
          }
       );
    }
}
