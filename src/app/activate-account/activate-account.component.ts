import { Component } from '@angular/core';
import { AuthentificationService } from '../authentification/authentification.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-activate-account',
  imports: [],
  templateUrl: './activate-account.component.html',
  styleUrl: './activate-account.component.css'
})
export class ActivateAccountComponent {
  constructor(private auth:AuthentificationService, private router: Router){}
  activeAccount(){
    this.auth.activateAccount(localStorage.getItem('id_account')).subscribe({
      next: (res) => {
         console.log('account',res)
         this.router.navigate(['/login']);

      }
     
    })
  }

}
