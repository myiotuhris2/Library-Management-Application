import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-publishers',
  templateUrl: './add-publishers.component.html',
  styleUrls: ['./add-publishers.component.css']
})
export class AddPublishersComponent implements OnInit {
  publishersForm : FormGroup;
  
  constructor(private formbuilder: FormBuilder, private http: HttpClient,private router: Router) { 
  this.publishersForm = this.formbuilder.group({
    name: [],
    address: [],
    phone:[],
    email: []
  })
}
isPink = true
  ngOnInit(): void {
  }
  savePublisher(){
    // Make Post call to request url http://localhost:8080/books/saveBook
  
    let publisherData = this.publishersForm.value;
    // Handle date to string
    this.http.post('http://localhost:8080/publisher/savepublisher',publisherData)
    .subscribe(response => {
      console.log('Publisher saved to DB', response)
      this.router.navigateByUrl('/publishers')
    }, error =>{
      console.error("Error in publisher save", error)
    }
    );

  }
  
}
