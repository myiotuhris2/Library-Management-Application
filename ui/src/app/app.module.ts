import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { AdminComponent } from './admin/admin.component';
import { LoanComponent } from './loan/loan.component';
import { StudentsComponent } from './students/students.component';
import { AuthorComponent } from './author/author.component';
import { PublishersComponent } from './publishers/publishers.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddAuthorsComponent } from './add-authors/add-authors.component';
import { AddStudentsComponent } from './add-students/add-students.component';
import { AddAdminsComponent } from './add-admins/add-admins.component';
import { AddPublishersComponent } from './add-publishers/add-publishers.component';
import { AddLoansComponent } from './add-loans/add-loans.component';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    AdminComponent,
    LoanComponent,
    StudentsComponent,
    AuthorComponent,
    PublishersComponent,
    SidenavComponent,
    AddBooksComponent,
    AddAuthorsComponent,
    AddStudentsComponent,
    AddAdminsComponent,
    AddPublishersComponent,
    AddLoansComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
