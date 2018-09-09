import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-disease-modal',
  templateUrl: './disease-modal.component.html',
  styleUrls: ['./disease-modal.component.css']
})
export class DiseaseModalComponent implements OnInit {
  @Input() disease;

  constructor(public activeModal: NgbActiveModal) {
  }

  ngOnInit() {
  }
}
