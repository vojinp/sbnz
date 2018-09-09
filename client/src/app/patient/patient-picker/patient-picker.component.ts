import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {PatientService} from '../shared/patient.service';

@Component({
  selector: 'app-patient-picker',
  templateUrl: './patient-picker.component.html',
  styleUrls: ['./patient-picker.component.css']
})
export class PatientPickerComponent implements OnInit {
  @Output() patientEvent = new EventEmitter();
  patients;
  toStr = JSON.stringify;
  toJson = JSON.parse;
  constructor(
    private patientService: PatientService
  ) { }

  ngOnInit() {
    this.patientService.getAll('/api/patient').subscribe(res => {
      console.log(res);
      this.patients = res;
      this.patientEvent.emit(res[0]);
    });
  }

}
