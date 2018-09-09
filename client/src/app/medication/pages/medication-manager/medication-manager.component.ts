import { Component, OnInit } from '@angular/core';
import {MedicationModalComponent} from '../../../medication/medication-modal/medication-modal.component';
import {MedicationService} from '../../../medication/shared/medication.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Medication} from '../../../medication/shared/medication.model';

@Component({
  selector: 'app-medication-manager',
  templateUrl: './medication-manager.component.html',
  styleUrls: ['./medication-manager.component.css']
})
export class MedicationManagerComponent implements OnInit {
  medications;
  constructor(
    private medicationService: MedicationService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.medicationService.getAll('/api/medication').subscribe(res => {
      this.medications = res;
      console.log(res);
    });
  }

  open(medication: Medication, option) {
    const modalRef = this.modalService.open(MedicationModalComponent);
    modalRef.componentInstance.medication = JSON.parse(JSON.stringify(medication));
    modalRef.result.then((result) => {
      if (option === 'add')
        this.addMedication(result);
      else if (option === 'change')
        this.changeMedication(result);
    }, reason => {

    });
  }

  addMedication(medication) {
    this.medicationService.post('/api/medication', medication).subscribe(res => {
      console.log(res);
      this.medications.push(res);
    });
  }

  changeMedication(medication) {
    this.medicationService.put('/api/medication', medication).subscribe(res => {
      console.log(res);
      for (let i in this.medications)
        if(this.medications[i].id === medication.id)
          this.medications[i] = res;
    });
  }

  removeMedication(medication) {
    this.medicationService.delete(`/api/medication/${medication.id}`).subscribe(res => {
      console.log(res);
      for (let i in this.medications)
        if(this.medications[i].id === medication.id)
          this.medications.splice(i, 1);
    });
  }

}

