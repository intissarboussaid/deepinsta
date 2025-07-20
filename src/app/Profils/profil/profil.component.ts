import { Component } from '@angular/core';
import { AdminService } from '../../Services/adminService/admin.service';
import { AuthentificationService } from '../../authentification/authentification.service';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';
import { UserService } from '../../Services/useServicer/user.service';
import { ProductManagerService } from '../../Services/productMangerService/product-manager.service';
import { DomSanitizer } from '@angular/platform-browser';
import { FormsModule, NgForm } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-profil',
  imports: [NgIf,FormsModule, HttpClientModule],
  templateUrl: './profil.component.html',
  styleUrl: './profil.component.css'
})
export class ProfilComponent {
  phone = '';
  nom = '';
  prenom = '';
  adresse = '';
  local = '';
  date_naissance = '';
  site = '';
  sexe = '';
  nationality = '';
  instagramme = '';
  facebook = '';
  tiktok = '';
  img: any;
  photo: any;
  email: any;
  description = '';
  isModalOpen = false;
  isModalEditPhotoOpen = false;
  isModalEditProfilOpen = false;
  selectedFile: File | null = null;

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
  }
  openEditPhotoModal() {
    this.isModalEditPhotoOpen = true;
  }

  closeEditPhotoModal() {
    this.isModalEditPhotoOpen = false;
  }

  openEditProfilModal() {
    this.isModalEditProfilOpen = true;
  }
  closeEditProfilModal() {
    this.isModalEditProfilOpen = false;
  }

  constructor(private admin: AdminService, private auth: AuthentificationService, private router: Router, private userService: UserService, private productManagerService: ProductManagerService, private sanitizer: DomSanitizer) {

  }
  ngOnInit(): void {
    if (localStorage.getItem('id_admin')) {
      this.admin.getAdmin(localStorage.getItem('id_admin')).subscribe({
        next: (res) => {
          console.log("admin: ", res);
          this.phone = res.phone;
          this.nom = res.nom;
          this.prenom = res.prenom;
          this.adresse = res.adresse;
          this.local = res.local;
          this.date_naissance = res.date_naissance;
          this.site = res.site;
          this.sexe = res.sexe;
          this.nationality = res.nationnalité;
          this.instagramme = res.instagramme;
          this.facebook = res.facebook;
          this.tiktok = res.tiktok;
          this.img = res.photo;
          this.description = res.description
          this.email = localStorage.getItem('email')
          if (this.img != null) {
            this.admin.getPhotoAdmin(localStorage.getItem('id_admin')).subscribe(blob => {
              const objectURL = URL.createObjectURL(blob);
              console.log("content blob", blob)
              this.img = objectURL;
            });

          } else {
            this.img = '../../../assets/img/photo_profil.jpg'
          }
        },
        error: (err) => {
          console.error('Error find admin :', err);
        }
      })
    }
    else if (localStorage.getItem('id_user')) {
      this.userService.getUser(localStorage.getItem('id_user')).subscribe({
        next: (res) => {
          this.phone = res.phone;
          this.nom = res.nom;
          this.prenom = res.prenom;
          this.adresse = res.adresse;
          this.local = res.local;
          this.date_naissance = res.date_naissance;
          this.site = res.site;
          this.sexe = res.sexe;
          this.nationality = res.nationnalité;
          this.instagramme = res.instagramme;
          this.facebook = res.facebook;
          this.tiktok = res.tiktok;
          this.img = res.photo;
          this.description = res.description
          this.email = localStorage.getItem('email')
          if (this.img != null) {
            this.userService.getPhotoUser(localStorage.getItem('id_user')).subscribe(blob => {
              const objectURL = URL.createObjectURL(blob);
              console.log("content blob", blob)
              this.img = objectURL;
            });

          } else {
            this.img = '../../../assets/img/photo_profil.jpg'
          }
        },
        error: (err) => {
          console.error('Error find User :', err);
        }
      })


    }
    else if (localStorage.getItem('id_pm')) {
      this.productManagerService.getPM(localStorage.getItem('id_pm')).subscribe({
        next: (res) => {
          this.phone = res.phone;
          this.nom = res.nom;
          this.prenom = res.prenom;
          this.adresse = res.adresse;
          this.local = res.local;
          this.date_naissance = res.date_naissance;
          this.site = res.site;
          this.sexe = res.sexe;
          this.nationality = res.nationnalité;
          this.instagramme = res.instagramme;
          this.facebook = res.facebook;
          this.tiktok = res.tiktok;
          this.description = res.description
          this.img = res.photo;
          this.email = localStorage.getItem('email')
          if (this.img != null) {
            this.productManagerService.getPhotoPm(localStorage.getItem('id_pm')).subscribe(blob => {
              const objectURL = URL.createObjectURL(blob);
              console.log("content blob", blob)
              this.img = objectURL;
            });

          } else {
            this.img = '../../../assets/img/photo_profil.jpg'
          }
        },
        error: (err) => {

        }
      })
    }
  }
  onSubmitt(form: NgForm) {
        if (form.valid) {
    const adminBody = {

      nom: this.nom,
      prenom: this.prenom,
      phone: this.phone,
      adresse: this.adresse,
      local: this.local,
      date_naissance: this.date_naissance,
      site: this.site,
      sexe: this.sexe,
      nationnalité: this.nationality,
      instagramme: this.instagramme,
      facebook: this.facebook,
      tiktok: this.tiktok,
     description:this.description
    }
    const admin = localStorage.getItem('id_admin');
    const user = localStorage.getItem('id_user');
    const productManger = localStorage.getItem('id_pm');

    if (admin !=null) {
      this.admin.updateInformations(localStorage.getItem('id_admin'), adminBody).subscribe({
        next: (res) => {
          console.log('admin', res)
          this.img = res.photo;
          console.log('photo admin', res.photo)

        }, error: (err) => {
          console.log('error ', err)
        }
      })
    }
    if (user!=null) {
      this.admin.updateInformations(localStorage.getItem('id_user'), adminBody).subscribe({
        next: (res) => {
          console.log('User', res)
          this.img = res.photo;
          console.log('User photo', res.photo)

        }, error: (err) => {
          console.log('error ', err)
        }
      })
    }
    if (productManger!=null) {
            this.admin.updateInformations(localStorage.getItem('id_pm'), adminBody).subscribe({
        next: (res) => {
          console.log('product manager', res)
          this.img = res.photo;
          console.log('photo PM', res.photo)

        }, error: (err) => {
          console.log('error ', err)
        }
      })

    }else {
      console.log('form invalid');
    }
  }
  }
  favorite() {
    this.router.navigate(['/favorite']);
  }
  history() {
    this.router.navigate(['/history']);
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/login'])
    console.log("Logged out");
  }
  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
  }

  uploadPhoto(): void {
    if (this.selectedFile) {
      if (localStorage.getItem('id_admin')) {
        this.admin.updateAdminPhoto(1, this.selectedFile).subscribe({
          next: (response) => console.log('Upload successful:', response),
          error: (err) => console.error('Upload error:', err)
        });
      }

      else if (localStorage.getItem('id_user')) {
        this.userService.updateUserPhoto(1, this.selectedFile).subscribe({
          next: (response) => console.log('Upload successful:', response),
          error: (err) => console.error('Upload error:', err)
        });
      }

      else if (localStorage.getItem('id_pm')) {
        this.productManagerService.updatePMPhoto(1, this.selectedFile).subscribe({
          next: (response) => console.log('Upload successful:', response),
          error: (err) => console.error('Upload error:', err)
        });
      }

    }
  }

 onSubmit() {

    const adminBody = {

      nom: this.nom,
      prenom: this.prenom,
      phone: this.phone,
      adresse: this.adresse,
      local: this.local,
      date_naissance: this.date_naissance,
      site: this.site,
      sexe: this.sexe,
      nationnalité: this.nationality,
      instagramme: this.instagramme,
      facebook: this.facebook,
      tiktok: this.tiktok,
     description:this.description
    }
    const admin = localStorage.getItem('id_admin');
    const user = localStorage.getItem('id_user');
    const productManger = localStorage.getItem('id_pm');

    if (admin !=null) {
      this.admin.updateInformations(localStorage.getItem('id_admin'), adminBody).subscribe({
        next: (res) => {
          console.log('admin', res)

        }, error: (err) => {
          console.log('error ', err)
        }
      })
    }
    if (user!=null) {
      this.admin.updateInformations(localStorage.getItem('id_user'), adminBody).subscribe({
        next: (res) => {
          console.log('User', res)

        }, error: (err) => {
          console.log('error ', err)
        }
      })
    }
    if (productManger!=null) {
            this.admin.updateInformations(localStorage.getItem('id_pm'), adminBody).subscribe({
        next: (res) => {
          console.log('product manager', res)

        }, error: (err) => {
          console.log('error ', err)
        }
      })

  }
  }
}
