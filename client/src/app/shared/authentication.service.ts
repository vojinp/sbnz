import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';
import {JwtHelper} from 'angular2-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private jwtHelper: JwtHelper = new JwtHelper();
  statusChanged: Subject<string[]>;
  private authenticated;

  constructor() {
    this.authenticated = this.getToken() != null ? true : false;
    this.statusChanged = new Subject<string[]>();
  }

  getUsername() {
    return this.jwtHelper.decodeToken(this.getToken()).sub;
  }

  getId() {
    return this.jwtHelper.decodeToken(this.getToken()).id;
  }

  isExpired() {
    if (this.getToken() == null) {
      return true;
    }
    return this.jwtHelper.isTokenExpired(this.getToken());
  }

  saveToken(token) {
    localStorage.setItem('Authorization', token);
    this.authenticated = true;
    this.statusChanged.next(this.getType());
  }

  getToken() {
    return localStorage.getItem('Authorization');
  }

  removeToken() {
    localStorage.removeItem('Authorization');
    this.statusChanged.next([]);
    this.authenticated = false;
  }

  getType() {
    if (this.getToken()) {
      return this.jwtHelper.decodeToken(this.getToken()).authorities;
    }
    return null;
  }

  isAuthenticated() {
    return this.authenticated;
  }
}
