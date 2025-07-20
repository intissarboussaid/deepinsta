import { Component } from '@angular/core';
import { MatDialogRef, MatDialogContent, MatDialogActions } from '@angular/material/dialog';



@Component({
  selector: 'app-historique',
  imports: [MatDialogContent, MatDialogActions],
  templateUrl: './historique.component.html',
  styleUrl: './historique.component.css'
})
export class HistoriqueComponent {
   constructor(public dialogRef: MatDialogRef<HistoriqueComponent>) {}

  confirm() {
    this.dialogRef.close(true);
  }

  cancel() {
    this.dialogRef.close(false);
  }

}