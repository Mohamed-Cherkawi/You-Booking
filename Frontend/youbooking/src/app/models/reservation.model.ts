import {BedRoom} from "./bed-room.model";
import {AppUser} from "./user.model";
import {AcceptanceStateEnum} from "../enums/acceptance-state.enum";

export class Reservation {
  id!: number;
  reservedBedRooms!: BedRoom[];
  totalPrice!: number;
  startDate!: string;
  endDate!: string;
  status!: AcceptanceStateEnum;
  reservedBy!: AppUser;
}
