import { Component, OnInit } from '@angular/core';
import {ReportService} from '../../shared/report.service';

@Component({
  selector: 'app-chronic-report',
  templateUrl: './chronic-report.component.html',
  styleUrls: ['./chronic-report.component.css']
})
export class ChronicReportComponent implements OnInit {
  patients;
  constructor(
    private reportService: ReportService
  ) { }

  ngOnInit() {
    this.reportService.getAll('/api/patient/chronic').subscribe(res => {
      this.patients = res;
    });
  }

}
