import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-medication-modal',
  templateUrl: './medication-modal.component.html',
  styleUrls: ['./medication-modal.component.css']
})
export class MedicationModalComponent implements OnInit {
  @Input() disease;

  constructor(public activeModal: NgbActiveModal) {
  }

  ngOnInit() {
  }

}
