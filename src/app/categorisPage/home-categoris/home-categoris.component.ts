import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { CategorisComponent } from "../categoris/categoris.component";
import { NavbarComponent } from "../../navbar/navbar.component";
import { FooterComponent } from "../../footer/footer.component";

@Component({
  selector: 'app-home-categoris',
  imports: [HeaderComponent, CategorisComponent, NavbarComponent, FooterComponent],
  templateUrl: './home-categoris.component.html',
  styleUrl: './home-categoris.component.css'
})
export class HomeCategorisComponent {

}
