import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-authors',
  templateUrl: './add-authors.component.html',
  styleUrls: ['./add-authors.component.css']
})
export class AddAuthorsComponent implements OnInit {
  authorsForm : FormGroup;
  
  constructor(private formbuilder: FormBuilder, private http: HttpClient,private router: Router) { 
  this.authorsForm = this.formbuilder.group({
    name: [],
    nationality: [],
    birthDate: []
  })
}
isPink = true
  ngOnInit(): void {
  }
  saveAuthor(){
    // Make Post call to request url http://localhost:8080/books/saveBook
  
    let authorData = this.authorsForm.value;
    // Handle date to string
    this.http.post('http://localhost:8080/authors/saveAuthor',authorData)
    .subscribe(response => {
      console.log('Author saved to DB', response)
      this.router.navigateByUrl('/author')
    }, error =>{
      console.error("Error in author save", error)
    }
    );

  }
  
}
 