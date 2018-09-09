import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AuthenticationService} from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AbstractRestService {


  jsonHeaders = new HttpHeaders({'Content-Type': 'application/json'});


  constructor(
    protected http: HttpClient,
    protected authenticationService: AuthenticationService
  ) {
    this.jsonHeaders = this.jsonHeaders.set('Authorization', this.authenticationService.getToken());
  }

  getOne(url) {
    return this.http.get(url, {headers: this.jsonHeaders});
  }

  getAll(url) {
    return this.http.get<Object[]>(url, {headers: this.jsonHeaders});
  }

  post(url, object) {
    console.log(this.jsonHeaders);
    return this.http.post(url, object, {headers: this.jsonHeaders});
  }

  put(url, object) {
    return this.http.put(url, object, {headers: this.jsonHeaders});
  }

  delete(url) {
    return this.http.delete(url, {headers: this.jsonHeaders});
  }
}
