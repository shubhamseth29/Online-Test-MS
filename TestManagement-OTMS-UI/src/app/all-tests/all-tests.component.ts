import { Component, OnInit } from '@angular/core';
import { TestServices } from '../services/test-services';
import { Test } from '../model/test';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-all-tests',
  templateUrl: './all-tests.component.html',
  styleUrls: ['./all-tests.component.css']
})

export class AllTestsComponent implements OnInit {
  tests:Test[]=[];
  test:Test;
  
  service:TestServices;
  constructor(service:TestServices) 
  { 
    this.service=service;
    this.getAllTests();
  }
  ngOnInit(): void {
    }

    getAllTests()
    {
      this.service.fetchAllTests().subscribe(result =>
        { 
        this.tests=result;
        }, 
        err => console.log(err));
}
     

deleteTest(test:Test)
{
  let testId=test.testId;
  this.service.deleteTestById(testId).subscribe
  ( 
    fetch =>
    {
      this.test=fetch;
      this.getAllTests();
      console.log("record deleted successfully for testId=" + fetch.testId)
    },
    err => 
    {
      console.log("err in deleting test record ="+ err)
    }
  );
}

 
  }


