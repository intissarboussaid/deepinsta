import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {
  private apiUrl='http://localhost:8080/api/deepshop/customers/'

  constructor(private http: HttpClient) { }

   GetCustomersByAdmin(id: any): Observable<any> {
      return this.http.get(`${this.apiUrl}by/admin/${id}`);
    }

    MakeItFidele(id: any): Observable<any> {
      return this.http.get(`${this.apiUrl}fidele/client/${id}`);
    }
     MakeItNotFidele(id: any): Observable<any> {
      return this.http.get(`${this.apiUrl}Notfidele/client/${id}`);
    }
}
