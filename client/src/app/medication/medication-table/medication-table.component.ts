import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthenticationService} from '../../shared/authentication.service';

@Component({
  selector: 'app-medication-table',
  templateUrl: './medication-table.component.html',
  styleUrls: ['./medication-table.component.css']
})
export class MedicationTableComponent implements OnInit {
  @Input() medications;
  @Output() checkChange = new EventEmitter();
  @Output() changeEvent = new EventEmitter();
  @Output() removeEvent = new EventEmitter();
  constructor(
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
  }


}
