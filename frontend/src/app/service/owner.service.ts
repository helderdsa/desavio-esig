import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Owner } from '../models/Owner';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  private url:string = "http://localhost:8080"

  constructor(private http: HttpClient) {}

  getOwners(): Observable<Owner[]> {
    return this.http.get<Owner[]>(this.url);
  }

  getOwner(id: String | null): Observable<Owner> {
    return this.http.get<Owner>(this.url + "/" + id);
  }

  postOwner(o: Owner): Observable<Owner> {
    return this.http.post<Owner>(this.url, o);
  }

  putOwner(o: Owner): Observable<Owner> {
    return this.http.put<Owner>(this.url, o);
  }

  deleteOwner(id: String | null): Observable<Owner> {
    return this.http.delete<Owner>(this.url + "/" + id);
  }
}
