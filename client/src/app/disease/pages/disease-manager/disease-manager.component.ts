import { Component, OnInit } from '@angular/core';
import {DiseaseModalComponent} from '../../../disease/disease-modal/disease-modal.component';
import {Disease} from '../../../disease/shared/disease.model';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {DiseaseService} from '../../../disease/shared/disease.service';

@Component({
  selector: 'app-disease-manager',
  templateUrl: './disease-manager.component.html',
  styleUrls: ['./disease-manager.component.css']
})
export class DiseaseManagerComponent implements OnInit {
  diseases;
  constructor(
    private diseaseService: DiseaseService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.diseaseService.getAll('/api/disease').subscribe(res => {
      this.diseases = res;
      console.log(res);
    });
  }

  open(disease: Disease, option) {
    const modalRef = this.modalService.open(DiseaseModalComponent);
    modalRef.componentInstance.disease = JSON.parse(JSON.stringify(disease));
    modalRef.result.then((result) => {
      if (option === 'add')
        this.addDisease(result);
      else if (option === 'change')
        this.changeDisease(result);
    }, reason => {

    });
  }

  addDisease(disease) {
    this.diseaseService.post('/api/disease', disease).subscribe(res => {
      console.log(res);
      this.diseases.push(res);
    });
  }

  changeDisease(disease) {
    this.diseaseService.put('/api/disease', disease).subscribe(res => {
      console.log(res);
      for (let i in this.diseases)
        if(this.diseases[i].id === disease.id)
          this.diseases[i] = res;
    });
  }

  removeDisease(disease) {
    this.diseaseService.delete(`/api/disease/${disease.id}`).subscribe(res => {
      console.log(res);
      for (let i in this.diseases)
        if(this.diseases[i].id === disease.id)
          this.diseases.splice(i, 1);
    });
  }

}

