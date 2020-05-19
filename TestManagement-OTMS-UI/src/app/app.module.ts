import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTestComponent } from './add-test/add-test.component';
import { FormsModule }   from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TestServices } from 'src/app/services/test-services';
import { UpdateTestComponent } from './update-test/update-test.component';
import { FindTestComponent } from './find-test/find-test.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AllTestsComponent } from './all-tests/all-tests.component';
import { AssignTestComponent } from './assign-test/assign-test.component';
import { HomeComponent } from './home/home.component';
import { AllUsersComponent } from './all-users/all-users.component';



@NgModule({
  declarations: [
    AppComponent,
    AddTestComponent,
    UpdateTestComponent,
    FindTestComponent,
    AddUserComponent,
    AllTestsComponent,
    AssignTestComponent,
    HomeComponent,
    AllUsersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [TestServices],
  bootstrap: [AppComponent]
})
export class AppModule { }
