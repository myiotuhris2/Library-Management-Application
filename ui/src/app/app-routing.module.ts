import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { LoanComponent } from './loan/loan.component';
import { PublishersComponent } from './publishers/publishers.component';
import { StudentsComponent } from './students/students.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { AddAuthorsComponent } from './add-authors/add-authors.component';
import { AddStudentsComponent } from './add-students/add-students.component';
import { AddAdminsComponent } from './add-admins/add-admins.component';
import { AddPublishersComponent } from './add-publishers/add-publishers.component';
import { AddLoansComponent } from './add-loans/add-loans.component';
import { Router } from '@angular/router';

const routes: Routes = [
  {
    path:'books',
    component:BookComponent,
  },
  {
    path:'admin',
    component:AdminComponent,
  },
  {
    path:'loan',
    component:LoanComponent,
  },
  {
    path:'students',
    component:StudentsComponent,
  },
  {
    path:'publishers',
    component:PublishersComponent,
  },
  {
    path:'author',
    component:AuthorComponent,
  },
  {
    path: 'add-books',
    component:AddBooksComponent,
  },
  {
    path: 'add-authors',
    component:AddAuthorsComponent,
  },
  {
    path: 'add-students',
    component:AddStudentsComponent,
  },
  {
    path: 'add-admins',
    component:AddAdminsComponent,
  },
  {
    path: 'add-publishers',
    component:AddPublishersComponent,
  },
  {
    path: 'add-loans',
    component:AddLoansComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
