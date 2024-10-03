import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task } from '../models/Task';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private url: string = 'https://desavio-esig-back-production.up.railway.app';

  constructor(private http: HttpClient) {}

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.url + '/task');
  }

  getTask(id: String | null): Observable<Task> {
    return this.http.get<Task>(this.url + '/task/' + id);
  }

  searchTasks(
    title?: string,
    status?: string,
    description?: string,
    priority?: string,
    deadline?: string,
    ownerId?: string
  ): Observable<Task[]> {
    let params = new HttpParams();

    if (title) params = params.set('title', title);
    if (status) params = params.set('status', status);
    if (description) params = params.set('description', description);
    if (priority) params = params.set('priority', priority);
    if (deadline) params = params.set('deadline', deadline);
    if (ownerId) params = params.set('ownerId', ownerId);
    return this.http.get<Task[]>(`${this.url}/task/search`, { params });
  }

  postTask(t: Task): Observable<Task> {
    return this.http.post<Task>(this.url + '/task', t);
  }

  putTask(t: Task): Observable<Task> {
    return this.http.put<Task>(this.url + '/task/' + t.id, t);
  }

  deleteTask(id: String | null): Observable<Task> {
    return this.http.delete<Task>(this.url + '/task/' + id);
  }
}
