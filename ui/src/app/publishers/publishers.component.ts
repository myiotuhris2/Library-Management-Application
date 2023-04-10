import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-publishers',
  templateUrl: './publishers.component.html',
  styleUrls: ['./publishers.component.css']
})
export class PublishersComponent implements OnInit {
  title = 'Publishers Management'
  publishers:any = []
  //books = []

  isPink = true
  constructor(private router: Router,private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllPublishers()
  }

  addPublishers(){
   
    console.log("addPublishers button clicked!!")
    // Take user to /add-books url
    this.router.navigateByUrl('/add-publishers')
  }

  fetchAllPublishers(){
    this.http.get("http://localhost:8080/publisher/getallpublishers")
    .subscribe(resp =>{
      this.publishers = resp;
      console.log('Publishers retrieved successfully:', this.publishers)
    }, error => {
      console.error('Error retrieving publishers:', error);
    });
  }
  deletePublisher(PublisherId:Number){
    
    const url = 'http://localhost:8080/publisher/deletepublisher/' +PublisherId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Publisher deleted successfully');
      this.fetchAllPublishers()
    }, error => {
      console.error('Error deleting publisher:', error);
    });
  }
}
