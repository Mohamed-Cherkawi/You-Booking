import {HotelOffer} from "./hotel-offer.model";
import {Hotel} from "./hotel.model";
import {Role} from "./role.model";

export class AppUser {
  id!: number;
  username!: string;
  password!: string;
  name!: string;
  phone!: string;
  cin!: string;
  role!: Role;
  hotelOffers?: HotelOffer;
  createdHotels?: Hotel[];
}
