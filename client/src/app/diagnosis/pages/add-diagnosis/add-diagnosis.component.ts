import { Component, OnInit } from '@angular/core';
import {DiagnosisService} from '../../shared/diagnosis.service';
import {AuthenticationService} from '../../../shared/authentication.service';
import { ToastrManager } from 'ng6-toastr-notifications';


@Component({
  selector: 'app-add-diagnosis',
  templateUrl: './add-diagnosis.component.html',
  styleUrls: ['./add-diagnosis.component.css']
})
export class AddDiagnosisComponent implements OnInit {
  diseases;
  diseaseName;
  patient;
  medications;
  checkedMedication = [];
  constructor(
    private diagnosisService: DiagnosisService,
    private authenticationService: AuthenticationService,
    private toastr: ToastrManager
  ) { }

  ngOnInit() {
    this.diagnosisService.getAll('/api/disease').subscribe(res => {
      this.diseases = res;
      this.diseaseName = this.diseases[0].name;
    });
    this.diagnosisService.getAll('/api/medication').subscribe(res => {
      this.medications = res;
    });
  }

  addDiagnosis() {
    console.log(this.authenticationService.getUsername());
    this.diagnosisService.post('/api/diagnosis', {'diseaseName': this.diseaseName,
      'doctorsUsername': this.authenticationService.getUsername(), 'patient': this.patient, 'medications': this.checkedMedication})
      .subscribe(res => {
        console.log(res);
    },
    error => {
      if (error.status === 400)
        this.toastr.errorToastr('Patient is allergic to some of the ingredients!', 'Oops!');
    });
  }

  setPatient($event) {
    this.patient = $event;
  }

  setDisease($event) {
    this.diseaseName = $event;
  }

  check(m) {
    let index;
    if ((index = this.checkedMedication.indexOf(m)) === -1)
      this.checkedMedication.push(m);
    else
      this.checkedMedication.splice(index, 1);
    console.log(this.checkedMedication);
  }
}
