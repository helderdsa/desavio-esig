import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Owner } from '../models/Owner';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  private url:string = "http://localhost:8080"

  constructor(private http: HttpClient) {}

  getOwners(): Observable<Owner[]> {
    return this.http.get<Owner[]>(this.url + "/owner");
  }

  getOwner(id: String): Observable<Owner> {
    return this.http.get<Owner>(this.url + "/owner/" + id);
  }

  postOwner(o: Owner): Observable<Owner> {
    return this.http.post<Owner>(this.url + "/owner", o);
  }

  putOwner(o: Owner): Observable<Owner> {
    return this.http.put<Owner>(this.url + "/owner", o);
  }

  deleteOwner(id: String): Observable<Owner> {
    return this.http.delete<Owner>(this.url + "/owner/" + id);
  }
}
