import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LogInService {
  constructor(
    private http: HttpClient
  ) { }

  logIn(obj) {
    return this.http.post('/api/login', obj, {observe: 'response'});
  }
}
