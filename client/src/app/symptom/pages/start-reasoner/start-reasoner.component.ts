import { Component, OnInit } from '@angular/core';
import {SymptomService} from '../../shared/symptom.service';

@Component({
  selector: 'app-start-reasoner',
  templateUrl: './start-reasoner.component.html',
  styleUrls: ['./start-reasoner.component.css']
})
export class StartReasonerComponent implements OnInit {
  symptoms;
  checkedSymptoms = [];
  diseases;
  patient;
  temp;
  constructor(
    private symptomService: SymptomService
  ) { }

  ngOnInit() {
    this.getSymptoms();
  }

  private getSymptoms() {
    this.symptomService.getAll('/api/symptom').subscribe(res => {
      this.symptoms = res;
    });
  }

  check(symptom) {
    let index;
    if ((index = this.checkedSymptoms.indexOf(symptom)) === -1)
      this.checkedSymptoms.push(symptom);
    else
      this.checkedSymptoms.splice(index, 1);
    console.log(this.checkedSymptoms);
  }

  startReasoner() {
    console.log(this.patient);
    console.log(this.temp);
    for (let s of this.checkedSymptoms)
      if (s.name === 'Povisena temperatura')
        s.value = this.temp;
    this.symptomService.post('/api/disease/probability', {'symptoms' : this.checkedSymptoms, 'patient': this.patient})
      .subscribe(res => {
      this.diseases = res;
      console.log(res);
      for(let d of this.diseases)
        if (d.probability > 100)
          d.probability = 100;
    });
  }

  setPatient($event: any) {
    console.log($event);
    this.patient = $event;
  }
}
