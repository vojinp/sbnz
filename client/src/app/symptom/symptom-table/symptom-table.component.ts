import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthenticationService} from '../../shared/authentication.service';

@Component({
  selector: 'app-symptom-table',
  templateUrl: './symptom-table.component.html',
  styleUrls: ['./symptom-table.component.css']
})
export class SymptomTableComponent implements OnInit {
  @Input() symptoms;
  @Output() checkChange = new EventEmitter();
  @Output() changeEvent = new EventEmitter();
  @Output() removeEvent = new EventEmitter();
  constructor(
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
    console.log(this.symptoms);
  }
}
