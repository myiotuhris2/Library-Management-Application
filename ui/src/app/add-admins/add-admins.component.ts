import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-admins',
  templateUrl: './add-admins.component.html',
  styleUrls: ['./add-admins.component.css']
})
export class AddAdminsComponent implements OnInit {
  adminsForm : FormGroup;
  
  constructor(private formbuilder: FormBuilder, private http: HttpClient,private router: Router) { 
  this.adminsForm = this.formbuilder.group({
    name: [],
    username: [],
    password: []
  })
}
isPink = true
  ngOnInit(): void {
  }
  saveAdmin(){
    // Make Post call to request url http://localhost:8080/books/saveBook
  
    let adminData = this.adminsForm.value;
    // Handle date to string
    this.http.post('http://localhost:8080/admin/saveadmin',adminData)
    .subscribe(response => {
      console.log('Admin saved to DB', response)
      this.router.navigateByUrl('/admin')
    }, error =>{
      console.error("Error in admin save", error)
    }
    );

  }
  
}
 
