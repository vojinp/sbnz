import { Component, OnInit } from '@angular/core';
import {PatientModalComponent} from '../../../patient/patient-modal/patient-modal.component';
import {Patient} from '../../../patient/shared/patient.model';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {PatientService} from '../../../patient/shared/patient.service';

@Component({
  selector: 'app-patient-manager',
  templateUrl: './patient-manager.component.html',
  styleUrls: ['./patient-manager.component.css']
})
export class PatientManagerComponent implements OnInit {
  patients;
  constructor(
    private patientService: PatientService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.patientService.getAll('/api/patient').subscribe(res => {
      this.patients = res;
      console.log(res);
    });
  }
  open(patient: Patient, option) {
    const modalRef = this.modalService.open(PatientModalComponent);
    modalRef.componentInstance.patient = JSON.parse(JSON.stringify(patient));
    modalRef.result.then((result) => {
      if (option === 'add')
        this.addPatient(result);
      else
        this.changePatient(result);
    });
  }

  addPatient(patient) {
    this.patientService.post('/api/patient', patient).subscribe(res => {
      console.log(res);
      this.patients.push(res);
    });
  }

  changePatient(patient) {
    this.patientService.put('/api/patient', patient).subscribe(res => {
      console.log(res);
      for (let i in this.patients)
        if(this.patients[i].id === patient.id)
          this.patients[i] = res;
    });
  }

  removePatient(patient) {
    this.patientService.delete(`/api/patient/${patient.id}`).subscribe(res => {
      console.log(res);
      for (let i in this.patients)
        if(this.patients[i].id === patient.id)
          this.patients.splice(i, 1);
    });
  }

}
