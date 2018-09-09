import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../../authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(
    private authenticationService: AuthenticationService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  loggedIn() {
    return this.authenticationService.isAuthenticated();
  }

  logOut() {
    this.authenticationService.removeToken();
    this.router.navigateByUrl('');
  }
}
