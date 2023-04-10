import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-loans',
  templateUrl: './add-loans.component.html',
  styleUrls: ['./add-loans.component.css']
})
export class AddLoansComponent implements OnInit {
  loansForm : FormGroup;
  
  constructor(private formbuilder: FormBuilder, private http: HttpClient,private router: Router) { 
  this.loansForm = this.formbuilder.group({
    bookId: [],
    studentId: [],
    checkoutDate:[],
    dueDate: [],
    returnDate: []
  })
}
isPink = true
  ngOnInit(): void {
  }
  saveLoan(){
    // Make Post call to request url http://localhost:8080/books/saveBook
  
    let loanData = this.loansForm.value;
    // Handle date to string
    this.http.post('http://localhost:8080/loan/saveloan',loanData)
    .subscribe(response => {
      console.log('Loan saved to DB', response)
      this.router.navigateByUrl('/loan')
    }, error =>{
      console.error("Error in loan save", error)
    }
    );

  }
  
}
