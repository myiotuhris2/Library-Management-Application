import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  title = 'Students Management'
  students:any = []
  //books = []

  isPink = true
  constructor(private router: Router,private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllStudents()
  }

  addStudents(){
   
    console.log("addStudents button clicked!!")
    // Take user to /add-books url
    this.router.navigateByUrl('/add-students')
  }

  fetchAllStudents(){
    this.http.get("http://localhost:8080/student/allstudents")
    .subscribe(resp =>{
      this.students = resp;
      console.log('Students retrieved successfully:', this.students)
    }, error => {
      console.error('Error retrieving students:', error);
    });
  }
  deleteStudent(StudentId:Number){
    
    const url = 'http://localhost:8080/student/deletestudent/' +StudentId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Student deleted successfully');
      this.fetchAllStudents()
    }, error => {
      console.error('Error deleting student:', error);
    });
  }
}
