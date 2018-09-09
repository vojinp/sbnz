import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {AuthenticationService} from '../../shared/authentication.service';
import {LogInService} from './log-in.service';

@Component({
  selector: 'app-log-in-page',
  templateUrl: './log-in-page.component.html',
  styleUrls: ['./log-in-page.component.css']
})
export class LogInPageComponent implements OnInit {
  hide = true;
  loginForm;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private logInService: LogInService
  ) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      'username': new FormControl(),
      'password': new FormControl()
    });
  }

  onSubmit() {
    this.logInService.logIn(this.loginForm.value).subscribe(

      (res) => {
        this.authenticationService.saveToken(res.headers.get('Authorization'));
        this.authenticationService.saveRole(res.body);
        this.navigate();
      },
      (error) => {
        if (error.status === 401) {
          console.log('Invalid login credentials. Please try again.');
        }
      }
    );
  }

  navigate() {
    if (this.authenticationService.getRole() === 'DOCTOR')
      this.router.navigate(['/reasoner']);
    else
      this.router.navigate(['/admin']);

  }

}
