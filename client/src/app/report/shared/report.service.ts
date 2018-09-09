import { Injectable } from '@angular/core';
import {AbstractRestService} from '../../shared/abstract-rest.service';
import {HttpClient} from '@angular/common/http';
import {AuthenticationService} from '../../shared/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class ReportService extends AbstractRestService {

  constructor(httpClient: HttpClient,
              authenticationService: AuthenticationService) {
    super(httpClient, authenticationService);
  }
}
