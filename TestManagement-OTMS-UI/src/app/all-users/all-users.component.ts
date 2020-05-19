import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { TestServices } from '../services/test-services';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {

  users:User[]=[];
  service:TestServices
  constructor(service:TestServices) 
  { 
    this.service=service;
  }

  ngOnInit(): void {
    
    this.service.fetchAllUsers().subscribe(
      result=>
      {
        this.users=result;
        console.log(result);
      },
      err=>console.log(err));
  
  }

}
