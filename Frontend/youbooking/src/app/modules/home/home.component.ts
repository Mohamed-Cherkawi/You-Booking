import { Component, OnInit } from '@angular/core';
import {Hotel} from "../../models/hotel.model";
import {AdminService} from "../../services/amdin.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  hotels!: Hotel[];
  hotelDetails!: Hotel;

  constructor(private adminService: AdminService , private router: Router ,
  ) { }

  ngOnInit(): void {
    this.getHotels();
  }

  public getHotels(): void{
    this.adminService.getAllCreatedHotelsApi()
      .subscribe({
        next:
          (response: Hotel[] | null) => {
          if (Array.isArray(response)) {
            this.hotels = response;
            console.log(response)
          }
            else
            console.log('This no hotels !');
          },
        error:
          (error : HttpErrorResponse) => {
            alert(error.message);
          }
      });
  }
  private countHotelsRooms(Hotels: Hotel[]): void {

  }
  public showHotelDetails(hotelId: number): void{
    this.adminService.getCreatedHotelByOwnerByIdApi(hotelId)
      .subscribe({
        next:
          (response: Hotel | string) => {
            if (typeof response == 'object') {
              console.log(response)
              this.hotelDetails = response;
            }
            else
              console.log(`This no hotels with the id : ${hotelId}!`);

          },
        error:
          (error : HttpErrorResponse) => {
            alert(error.message);
          }
      });
  }
}
