import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private apiUrl = 'http://localhost:8080/api/deepshop/contact';

  constructor( private http: HttpClient) { }
  
  sendMessage(contactBody:any): Observable<any> {
      return this.http.post(`${this.apiUrl}/send`, contactBody);
    }
}
