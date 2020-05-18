import { Component, OnInit } from '@angular/core';
import { TestServices } from '../services/test-services';
import { User } from '../model/user';
import { Observable, observable } from 'rxjs';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  service:TestServices
  constructor(service:TestServices) {
    this.service=service;
   }
 
  

  ngOnInit(): void {
  }

  addedUser:User=null;

  addUser(form:any)
  {
    let data= form.value;
    let userId=data.id;
    let userName= data.userName;
    let userPassword= data.userPassword;
    let isAdmin = data.isAdmin;
    console.log(isAdmin);

    this.addedUser = new User();
    this.addedUser.userId=userId;
    this.addedUser.userName=userName;
    this.addedUser.isAdmin=isAdmin;
    console.log(this.addedUser.isAdmin);
    this.addedUser.userPassword=userPassword;

    let result:Observable<User> = this.service.addUser(this.addedUser);
    result.subscribe((user: User) => {
      this.addedUser = user;
    },
      err => {
        console.log("err=" + err);
      });
      
   form.reset();
    }
}
