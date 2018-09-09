import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthenticationService} from '../../shared/authentication.service';

@Component({
  selector: 'app-patient-table',
  templateUrl: './patient-table.component.html',
  styleUrls: ['./patient-table.component.css']
})
export class PatientTableComponent implements OnInit {
  @Input() patients;
  @Output() changeEvent = new EventEmitter();
  @Output() removeEvent = new EventEmitter();

  constructor(
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
  }

}
