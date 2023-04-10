import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  title = 'Authors Management'
  authors:any = []
  //books = []

  isPink = true
  constructor(private router: Router,private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAuthors()
  }

  addAuthors(){
   
    console.log("addAuthors button clicked!!")
    // Take user to /add-books url
    this.router.navigateByUrl('/add-authors')
  }

  fetchAllAuthors(){
    this.http.get("http://localhost:8080/authors/getAllAuth")
    .subscribe(resp =>{
      this.authors = resp;
      console.log('Authors retrieved successfully:', this.authors)
    }, error => {
      console.error('Error retrieving authors:', error);
    });
  }
  deleteAuthor(AuthorId:Number){
    
    const url = 'http://localhost:8080/authors/delete/' +AuthorId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Author deleted successfully');
      this.fetchAllAuthors()
    }, error => {
      console.error('Error deleting author:', error);
    });
  }
}
