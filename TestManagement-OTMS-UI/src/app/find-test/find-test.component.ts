import { Component, OnInit } from '@angular/core';
import { TestServices } from '../services/test-services';
import {Test} from '../model/Test'
import { Observable } from 'rxjs';
@Component({
  selector: 'app-find-test',
  templateUrl: './find-test.component.html',
  styleUrls: ['./find-test.component.css']
})
export class FindTestComponent implements OnInit {

  service:TestServices;
  foundTest:Test=null;
  foundStatus=null;
  constructor(service:TestServices) 
  {
    this.service=service;
   }

  ngOnInit(): void {
  }

  findTestById(form:any):void{
    let details=form.value;
    let id=details.testId;
    let fetched:Observable<Test>=this.service.findTestById(id);
    fetched.subscribe(
      test=>{
        this.foundTest=test;
        this.foundStatus="found";
      },
      err=>{
        this.foundStatus="Not Found";
        console.log("Error while fetching Test="+err);
      }
    )
  }

}
