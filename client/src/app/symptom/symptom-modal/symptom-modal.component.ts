import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-symptom-modal',
  templateUrl: './symptom-modal.component.html',
  styleUrls: ['./symptom-modal.component.css']
})
export class SymptomModalComponent implements OnInit {
  @Input() symptom;

  constructor(public activeModal: NgbActiveModal) {
  }

  ngOnInit() {
  }
}
