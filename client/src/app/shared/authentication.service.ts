import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';
import {JwtHelper} from 'angular2-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private jwtHelper: JwtHelper = new JwtHelper();

  private authenticated;

  constructor() {
    this.authenticated = this.getToken() != null ? true : false;
  }

  getUsername() {
    return this.jwtHelper.decodeToken(this.getToken()).sub;
  }

  getRole() {
    return localStorage.getItem('Role');
  }

  saveRole(role) {
    localStorage.setItem('Role', role);
  }

  getDecoded() {
    return this.jwtHelper.decodeToken(this.getToken());
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
  }

  getToken() {
    return localStorage.getItem('Authorization');
  }

  removeToken() {
    localStorage.removeItem('Authorization');
    localStorage.removeItem('Role');
    this.authenticated = false;
  }

  isAuthenticated() {
    return this.authenticated;
  }
}
