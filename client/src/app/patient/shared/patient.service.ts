import { Injectable } from '@angular/core';
import {AuthenticationService} from '../../shared/authentication.service';
import {AbstractRestService} from '../../shared/abstract-rest.service';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PatientService extends AbstractRestService {

  constructor(
    httpClient: HttpClient,
    authenticationService: AuthenticationService
  ) { super(httpClient, authenticationService); }
}
