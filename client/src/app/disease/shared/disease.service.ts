import { Injectable } from '@angular/core';
import {AbstractRestService} from '../../shared/abstract-rest.service';
import {AuthenticationService} from '../../shared/authentication.service';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DiseaseService extends AbstractRestService {

  constructor(
    httpClient: HttpClient,
    authenticationService: AuthenticationService
  ) { super(httpClient, authenticationService); }
}
