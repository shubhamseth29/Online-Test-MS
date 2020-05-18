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
  service:TestServices;
  constructor(service:TestServices) 
  { 
    this.service=service;
  }
  ngOnInit(): void {
    
      this.service.fetchAllTests().subscribe(result =>
        { 
        this.tests=result;
        }, 
        err => console.log(err));
}

 
  }


