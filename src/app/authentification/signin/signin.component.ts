import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from '../authentification.service';
import { FormGroup, FormsModule, NgForm, NgModel } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-signin',
  imports: [FormsModule, HttpClientModule, NgIf],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.css'
})
export class SigninComponent implements OnInit {
  // credentials = { email: '', password: '' };
  email = '';
  psw = '';
  errorMessage = '';
  isLoading = false;
  // useForm: any;
  loginError = '';
  messageRest = '';
  messageResterror = '';
  isModalOpen = false;

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
  }
  constructor(private router: Router, private authentification: AuthentificationService) { }
  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    console.log('page login is loading');
  }
  toSignUp() {
    console.log("signup page called");
    this.router.navigate(['signUp']);
  }

  // onSubmit() {
  //   this.isLoading = true;
  //   this.errorMessage = '';

  //   this.authentification.login({ email: this.email, password: this.password }).subscribe(
  //     (response: any) => {
  //       console.log('response', response);
  //       //  localStorage.setItem('access_token', res.token);
  //       this.router.navigate(['']);
  //       this.isLoading = false;
  //     },
  //     (error: any) => {
  //       this.errorMessage = 'Invalid username or password';
  //       this.isLoading = false;
  //       console.error('Login error:', error);
  //     }
  //   );
  // }
  onSubmit(form: NgForm) {
    if (form.valid) {
      const credentials = {
        email: this.email,
        psw: this.psw,
      };

      this.authentification.getEmail(credentials.email).subscribe({
        next: (res) => {
          if (res.is_enable === true) {
            console.log("account", res);
            this.authentification.login(credentials).subscribe({

              next: (res) => {
                console.log('Login response:', res);
                const token = res?.body?.account?.token;
                const account = res?.body?.account;
                if (token && account) {
                  localStorage.setItem('email', res.email);
                  localStorage.setItem('id_account', res.id_account);
                  localStorage.setItem('token', res.token);
                }
                if (res.user) {
                  localStorage.setItem('id_user', res.user.id_user);
                } else if (res.admin) {
                  localStorage.setItem('id_admin', res.admin.id_admin)
                }
              },
              error: (err) => {
                console.error('Login failed:', err.error);
                this.loginError = "There's an error. Please try again";
                console.log("email", this.email);
                console.log("password", this.psw);
              }
            });
            this.router.navigate(['/categoris']);
            console.log("id_account", res.id_account);
            localStorage.setItem("id_account", res.id_account);
            localStorage.setItem('email', res.email);
          } else {
            console.log("id_account", res.id_account);
            localStorage.setItem("id_account", res.id_account);
            console.log("id_account", res.id_account);
            localStorage.setItem('email', res.email);
            this.loginError = "This account isn't activated. Please activate it through the email we sent you";
          }
          if (res.admin) {
            localStorage.setItem("id_admin", res.admin.id_admin);
          } else if (res.user) {
            localStorage.setItem("id_user", res.user.id_user);
          } else {
            localStorage.setItem("id_pm", res.product_manager.id_);
          }
        },
        error: (err) => {
          console.log('error account', err);
          this.loginError = "Email does not exist!";
        }
      })


    } else {
      console.log('form invalid')
      this.loginError = "There's something missing! Please try again";
    }
  }
  onsendEmail(form: NgForm) {
    if (form.valid) {
      const email = this.email
      this.authentification.sendEmailRP(email).subscribe({
        next: (res) => {
          console.log('token:', res);

          if (res != null) {
            localStorage.setItem('email', res.email);
            localStorage.setItem('id_account', res.id_account);
            localStorage.setItem('token', res.token);
            this.messageRest = "We've sent a verification code and a password reset link to your email. Please check your inbox to proceed.";
          } else {
            this.messageResterror = "Email does not exist!";
          }
          setTimeout(() => {
            this.messageRest = '';
          }, 9000);
          setTimeout(() => {
            this.messageResterror = '';
          }, 9000);
          // this.router.navigate(['/forgot-password']);
        },
        error: (err) => {
          console.error('Login failed:', err.error);
          this.messageResterror = "Email does not exist!";
        }
      });
    }

  }
}

