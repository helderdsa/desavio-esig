import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task } from '../models/Task';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private url:string = "http://localhost:8080"

  constructor(private http: HttpClient) {}

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.url);
  }

  getTask(id: String | null): Observable<Task> {
    return this.http.get<Task>(this.url + "/" + id);
  }

  postTask(o: Task): Observable<Task> {
    return this.http.post<Task>(this.url, o);
  }

  putTask(o: Task): Observable<Task> {
    return this.http.put<Task>(this.url, o);
  }

  deleteTask(id: String | null): Observable<Task> {
    return this.http.delete<Task>(this.url + "/" + id);
  }
}
