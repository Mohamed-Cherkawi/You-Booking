import {BedRoomStateEnum} from "../enums/bed-room-state.enum";
import {Bed} from "./bed.model";

export class BedRoom {
  id!: number;
  reference!: string;
  beds!: Bed[];
  price!: number;
  status!: BedRoomStateEnum;
}
