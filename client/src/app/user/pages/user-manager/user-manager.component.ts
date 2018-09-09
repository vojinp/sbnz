import {Component, Input, OnInit} from '@angular/core';
import {UserService} from '../../shared/user.service';
import {NgbModal, NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {UserModalComponent} from '../../user-modal/user-modal.component';
import {User} from '../../shared/user.model';

@Component({
  selector: 'app-user-manager',
  templateUrl: './user-manager.component.html',
  styleUrls: ['./user-manager.component.css']
})
export class UserManagerComponent implements OnInit {
  users;
  constructor(
    private userService: UserService,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.userService.getAll('/api/user').subscribe(res => {
      this.users = res;
      console.log(res);
    });
  }

  open(user: User, option) {
    const modalRef = this.modalService.open(UserModalComponent);
    modalRef.componentInstance.user = JSON.parse(JSON.stringify(user));
    modalRef.result.then((result) => {
      if (option === 'add')
        this.addUser(result);
      else
        this.changeUser(result);
    });
  }

  addUser(user) {
    this.userService.post('/api/user', user).subscribe(res => {
      console.log(res);
      this.users.push(res);
    });
  }

  changeUser(user) {
    this.userService.put('/api/user', user).subscribe(res => {
      console.log(res);
      for (let i in this.users)
        if(this.users[i].id === user.id)
          this.users[i] = res;
    });
  }

  removeUser(user) {
    this.userService.delete(`/api/user/${user.id}`).subscribe(res => {
      console.log(res);
      for (let i in this.users)
        if(this.users[i].id === user.id)
          this.users.splice(i, 1);
    });
  }

}

