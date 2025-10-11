import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

    private apiUrl = 'http://localhost:8080/api/deepinsta/discount/';

  constructor(private http: HttpClient) { }
  AddDiscount(id: any,discount:any): Observable<any> {
    return this.http.post(`${this.apiUrl}add/discount/${id}`, discount);
  }
    getDiscountsByAdmin(id_admin:any): Observable<any> {
    return this.http.get(`${this.apiUrl}get/by/admin/${id_admin}`);
  }
  updateDateDiscount(id_discount:any): Observable<any> {
    return this.http.get(`${this.apiUrl}update/discount/${id_discount}`);
  }
}
