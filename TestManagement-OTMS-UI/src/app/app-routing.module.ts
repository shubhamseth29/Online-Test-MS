import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddTestComponent } from './add-test/add-test.component';
import { FindTestComponent } from './find-test/find-test.component';
import { UpdateTestComponent } from './update-test/update-test.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AllTestsComponent } from './all-tests/all-tests.component';
import { AssignTestComponent } from './assign-test/assign-test.component';
import { AllUsersComponent } from './all-users/all-users.component';


const routes: Routes = 
[
  {
    path:'add-test',
    component:AddTestComponent
  },
  {
    path:'find-test',
    component:FindTestComponent
  },
  {
    path:'update-test',
    component:UpdateTestComponent
  },
  {
    path:'add-user',
    component:AddUserComponent
  },
  {
    path:'all-tests',
    component:AllTestsComponent
  },
  {
    path:'assign-test',
    component:AssignTestComponent
  },
  {
    path:'all-users',
    component:AllUsersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
