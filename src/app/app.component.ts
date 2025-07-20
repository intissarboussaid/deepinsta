import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { NavbarComponent } from "./navbar/navbar.component";
import { FooterComponent } from "./footer/footer.component";
import { HttpClientModule } from '@angular/common/http';
import { NgIf } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-root',
  imports: [
    ReactiveFormsModule,
    RouterOutlet,
    FormsModule,
    MatDialogModule,
    MatButtonModule,
    // NavbarComponent,
    // FooterComponent,
    HttpClientModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'deepshop';
  showLayout = true;
  constructor(private router: Router) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // Adjust this condition to match your activate-account route
        const hiddenRoutes = ['/activate-account'];
        this.showLayout = !hiddenRoutes.includes(event.urlAfterRedirects);
      }
    });
  }
}
