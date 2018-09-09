import { Component, OnInit } from '@angular/core';
import {SymptomModalComponent} from '../../../symptom/symptom-modal/symptom-modal.component';
import {SymptomService} from '../../../symptom/shared/symptom.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Symptom} from '../../../symptom/shared/symptom.model';

@Component({
  selector: 'app-symptom-manager',
  templateUrl: './symptom-manager.component.html',
  styleUrls: ['./symptom-manager.component.css']
})
export class SymptomManagerComponent implements OnInit {
  symptoms;
  constructor(
    private symptomService: SymptomService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.symptomService.getAll('/api/symptom').subscribe(res => {
      this.symptoms = res;
      console.log(res);
    });
  }

  open(symptom: Symptom, option) {
    const modalRef = this.modalService.open(SymptomModalComponent);
    modalRef.componentInstance.symptom = JSON.parse(JSON.stringify(symptom));
    modalRef.result.then((result) => {
      if (option === 'add')
        this.addSymptom(result);
      else if (option === 'change')
        this.changeSymptom(result);
    }, reason => {

    });
  }

  addSymptom(symptom) {
    this.symptomService.post('/api/symptom', symptom).subscribe(res => {
      console.log(res);
      this.symptoms.push(res);
    });
  }

  changeSymptom(symptom) {
    this.symptomService.put('/api/symptom', symptom).subscribe(res => {
      console.log(res);
      for (let i in this.symptoms)
        if(this.symptoms[i].id === symptom.id)
          this.symptoms[i] = res;
    });
  }

  removeSymptom(symptom) {
    this.symptomService.delete(`/api/symptom/${symptom.id}`).subscribe(res => {
      console.log(res);
      for (let i in this.symptoms)
        if(this.symptoms[i].id === symptom.id)
          this.symptoms.splice(i, 1);
    });
  }

}

