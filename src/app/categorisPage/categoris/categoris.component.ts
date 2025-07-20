import { NgFor } from '@angular/common';
import { Component, ElementRef, Input, ViewChild } from '@angular/core';

@Component({
  selector: 'app-categoris',
  imports: [NgFor],
  templateUrl: './categoris.component.html',
  styleUrl: './categoris.component.css'
})
export class CategorisComponent {

 @ViewChild('viewport') viewport!: ElementRef;

  items = ['Women', 'Men', 'Kids', 'Footerwear', 'Bags & Accessories', 'Eyewear', 'Sportswear', 'Brands'];

  @Input() items_categoris = ['Women', 'Men', 'Kids', 'Footerwear', 'Bags & Accessories', 'Eyewear', 'Sportswear', 'Brands'];
  @Input() items_card: { src: string; name: string }[]= [
    {
      src:'../../../assets/img/header.png',name:"frist"
    },
    {
      src:'../../../assets/img/header.png',name:"frist"
    },
    {
      src:'../../../assets/img/header.png',name:"frist"
    },
    {
      src:'../../../assets/img/header.png',name:"frist"
    },
    {
      src:'../../../assets/img/header.png',name:"frist"
    },
  ];
  isDragging = false;
  startX = 0;
  scrollLeft = 0;

  startDrag(event: MouseEvent) {
    this.isDragging = true;
    this.startX = event.pageX - this.viewport.nativeElement.offsetLeft;
    console.log('start draggin :start x:', this.startX);
    console.log('start draggin :event page  x:', event.pageX);
    console.log('start draggin :this.viewport.nativeElement.offsetLeft', this.viewport.nativeElement.offsetLeft);
    this.scrollLeft = this.viewport.nativeElement.scrollLeft;
  }
  onDrag(event: MouseEvent) {
    if (!this.isDragging) return;
    event.preventDefault();
    const x = event.pageX - this.viewport.nativeElement.offsetLeft;
    const walk = (x - this.startX) * 1; // Adjust scroll speed with multiplier
    console.log('this.scrollLeft - walk', this.scrollLeft - walk);

    this.viewport.nativeElement.scrollLeft = this.scrollLeft - walk;
  }

  endDrag() {
    this.isDragging = false;
  }
}

