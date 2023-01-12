import {HotelStateEnum} from "../enums/hotel-state.enum";
import {AppUser} from "./user.model";
import {BedRoom} from "./bed-room.model";
import {Address} from "./address.model";
import {Attachment} from "./attachment.model";

export class Hotel {
  id: number;
  name: string;
  bedRooms: BedRoom[];
  address: Address;
  attachments: Attachment[] ;
  status: HotelStateEnum;
  isApproved: boolean;
  owner: AppUser;

  constructor(id: number, name: string, bedRooms: BedRoom[], address: Address, attachments: Attachment[] , status: HotelStateEnum, isApproved: boolean, owner: AppUser) {
    this.id = id;
    this.name = name;
    this.bedRooms = bedRooms;
    this.address = address;
    this.attachments = attachments;
    this.status = status;
    this.isApproved = isApproved;
    this.owner = owner;
  }
}
