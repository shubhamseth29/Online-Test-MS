import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Test } from '../model/test';
import { User } from '../model/user';

@Injectable()
export class TestServices {

    client:HttpClient ;
  constructor(client:HttpClient ){
  this.client=client;
}

baseTestUrl="http://localhost:8087/tests";
baseUserUrl="http://localhost:8087/users";

/**
  * fires post request to server with test as body
  * 
  * @param test 
  */
 addTest(test:Test): Observable<Test>{
    let url=this.baseTestUrl+"/add";
    let result:Observable<Test>= this.client.post<Test>(url,test);
    console.log("testing is this" + test);
    return result;
    }

    /**
  * fires post request to server with updated test as body
  * 
  * @param test 
  */
 updateTest(testId:Number,test:Test):Observable<Test>
 {
   let url=this.baseTestUrl+"/update/"+testId;
   let result:Observable<Test>= this.client.put<Test>(url,test);
    return result;
 }

 /**
   * fires get request to server to fetch test for id mentioned in url
   * @param id of test which has to be fetched
   */

   findTestById(id:number):Observable<Test>{
     let url=this.baseTestUrl+'/get/'+id;
     let observable:Observable<Test>=this.client.get<Test>(url);
    return observable;
    }

    /**
   * fires post request to server to add user for id mentioned in url
   * @param id of test which has to be fetched
   */

    addUser(user:User): Observable<User>{
      let url=this.baseUserUrl+"/add";
      let result:Observable<User>= this.client.post<User>(url,user);
      return result;
      }

        /**
   * fires get request to get all tests
   */

  fetchAllTests():Observable<Test[]>{
    let url = this.baseTestUrl;
    let observable : Observable<Test[]>=this.client.get<Test[]>(url);
    return observable;
  }

}
