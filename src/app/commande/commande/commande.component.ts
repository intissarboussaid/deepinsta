import { Component } from '@angular/core';
import { NavbarComponent } from "../../navbar/navbar.component";
import { CommandeService } from '../../Services/CommandeService/commande.service';
import { PhotoService } from '../../Services/photo.service';
import { FooterComponent } from "../../footer/footer.component";
import { Location } from '@angular/common';

@Component({
  selector: 'app-commande',
  imports: [NavbarComponent, FooterComponent],
  templateUrl: './commande.component.html',
  styleUrl: './commande.component.css'
})
export class CommandeComponent {

  currentIndexes: { [photoId: number]: number } = {};

  commande: any;
  cmdsAdded:any[] = [];
  cmdsAcceptedbyUser:any[] = [];
  isAccepted = false;
  price: any;
  total = 0;
  isModalOpen=false;
  allComandes: any[] = [];
  id_cmditem:any;
cmdsItem: any[] = [];
ConfirmedCommandeByUser:any[] = [];
ConfirmedCommandeByAdmin:any[] = [];
RefusedByAdmin:any[] = [];
  constructor(private location:Location,private commandeService: CommandeService, private photoService: PhotoService) { }
  ngOnInit() {

    //get Commande by user not confirmed
    this.commandeService.GetCommandesNotConfByUser(localStorage.getItem('id_user')).subscribe({
      next: (res) => {
        this.commande = res;
        if(this.commande!==null){
          this.cmdsItem=this.commande.cmd_item;
        console.log("user's commande not validated", this.commande)
        this.commande.cmd_item.forEach((item:any)=>{
          item.product.photos.forEach((photo: any) => {
            this.photoService.getPhoto(photo.id_photo).subscribe(
              blob => {
                const objectURL = URL.createObjectURL(blob);
                photo.filePath = objectURL;
              }
            )
          })
        })
        }
        
      }, error: (err) => {
        console.log("error commande", err);
      }
    })
    //get commande confirmed by user only 
    this.commandeService.GetCmdConfirmedByUser(localStorage.getItem('id_user')).subscribe({
      next:(res)=>{
        this.ConfirmedCommandeByUser=res;
        console.log(' commandes confirmed by user only ', this.ConfirmedCommandeByUser);
        this.ConfirmedCommandeByUser.forEach((commande:any)=>{          
          commande.cmd_item.forEach((cmdItem:any)=>{ 
            cmdItem.product.photos.forEach((photo: any) => {
            this.photoService.getPhoto(photo.id_photo).subscribe(
              blob => {
                const objectURL = URL.createObjectURL(blob);
                photo.filePath = objectURL;
              }
            )
          })
          })
          
        })
        console.log(' commandes confirmed by user only ', this.ConfirmedCommandeByUser);
      },error:(err)=>{
        console.log(' error commandes confirmed by user only ', err);
      }
    })
    //get commande confirmed by Admin 
    this.commandeService.GetCmdConfirmedByUserAndAdmin(localStorage.getItem('id_user')).subscribe({
      next:(res)=>{
        console.log(' commandes confirmed by admin ', res);
        this.ConfirmedCommandeByAdmin=res;
        this.ConfirmedCommandeByAdmin.forEach((commande:any)=>{
          commande.product.photos.forEach((photo:any)=>{
            this.photoService.getPhoto(photo.id_photo).subscribe(
              blob => {
                const objectURL = URL.createObjectURL(blob);
                photo.filePath = objectURL;
              }
            )
          })
        })
      },error:(err)=>{
        console.log(' error commandes confirmed by user and admin ', err);
      }
    })
        //get commande confirmed by Admin 
    this.commandeService.GetCmdRefusedByAdmin(localStorage.getItem('id_user')).subscribe({
      next:(res)=>{
        console.log(' commandes Refused by admin ', res);
        this.RefusedByAdmin=res;
        this.RefusedByAdmin.forEach((commande:any)=>{
          commande.product.photos.forEach((photo:any)=>{
            this.photoService.getPhoto(photo.id_photo).subscribe(
              blob => {
                const objectURL = URL.createObjectURL(blob);
                photo.filePath = objectURL;
              }
            )
          })
        })
      },error:(err)=>{
        console.log(' error commandes refused admin ', err);
      }
    })
  }
   openModal( id_cmditem:any) {
    this.id_cmditem=id_cmditem;
    this.isModalOpen = !this.isModalOpen;
  }
  closeModal(){
this.isModalOpen = false;
  }
  getCurrentIndex(photoId: number): number {
    return this.currentIndexes[photoId] ?? 0;
  }
  nextSlide(photoId: number, max: number): void {
    console.log("max", max)
    const current = this.getCurrentIndex(photoId);
    console.log("current", current)
    if (current < max) {
      this.currentIndexes[photoId] = current + 1;
      console.log("current2", this.currentIndexes[photoId])
    }
  }
  prevSlide(photoId: number): void {
    const current = this.getCurrentIndex(photoId);
    if (current > 0) {
      this.currentIndexes[photoId] = current - 1;
    }
  }
  deleteProductFronCmd(id_cmditem:any,id_cmd:any){
    this.commandeService.deleteProductFromCmd(id_cmditem,id_cmd,localStorage.getItem('id_user')).subscribe({
      next:(res)=>{
        console.log("delete product from commande", res);
        window.location.reload();

      },
      error:(err)=>{
        console.log("error delete product from commande", err)
      }
    })
  }
  ConfCommand(){
    this.commandeService.ConfCommandeByUser(localStorage.getItem('id_user')).subscribe({
      next:(res)=>{
        console.log("confirmed commande", res);
        window.location.reload();
      },
      error:(err)=>{
        console.log("confirmed commande", err)
      }
    })
  }
goBack() {
    this.location.back();
  }
}
