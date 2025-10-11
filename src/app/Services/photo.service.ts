import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {
  private apiUrl = 'http://localhost:8080/api/deepinsta/photo';
  constructor(private http: HttpClient) { }

  getPhotos(id: any) {
    return this.http.get(`${this.apiUrl}/getPhotos/${id}`, { responseType: 'blob' });
  }
  getPhoto(id: any) {
    return this.http.get(`${this.apiUrl}/${id}`, { responseType: 'blob' });
  }
  deletePhoto(id: any) {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}
