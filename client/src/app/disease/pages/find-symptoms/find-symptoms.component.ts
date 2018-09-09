import { Component, OnInit } from '@angular/core';
import {DiseaseService} from '../../shared/disease.service';

@Component({
  selector: 'app-find-symptoms',
  templateUrl: './find-symptoms.component.html',
  styleUrls: ['./find-symptoms.component.css']
})
export class FindSymptomsComponent implements OnInit {
  diseases;
  diseaseName;
  symptoms;
  constructor(
    private diseaseService: DiseaseService
  ) { }

  ngOnInit() {
    this.diseaseService.getAll('/api/disease').subscribe(res => {
      this.diseases = res;
      this.diseaseName = this.diseases[0].name;
    });
  }

  findSymptoms() {
    console.log(this.diseaseName);
    this.diseaseService.getAll(`/api/symptom/for-disease/${this.diseaseName}`).subscribe(res => {
      this.symptoms = res;
    });
  }

  setDisease($event: any) {
    this.diseaseName = $event;
  }
}
