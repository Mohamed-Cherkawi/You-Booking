import {AvailabilityStateEnum} from "../enums/availability-state.enum";
import {Hotel} from "./hotel.model";

export class HotelOffer {
  id!: number;
  title!: string;
  description!: string;
  creationDate!: string;
  status!: AvailabilityStateEnum;
  hotel!: Hotel;
}
