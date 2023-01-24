import {HotelStateEnum} from "../enums/hotel-state.enum";
import {AppUser} from "./user.model";
import {BedRoom} from "./bed-room.model";
import {Address} from "./address.model";
import {Attachment} from "./attachment.model";

export class Hotel {
  id!: number;
  name!: string;
  bedRooms!: BedRoom[];
  address!: Address;
  attachments!: Attachment[] ;
  status!: HotelStateEnum;
  isApproved!: boolean;
  owner!: AppUser;
  numOfRooms!: number;

}
