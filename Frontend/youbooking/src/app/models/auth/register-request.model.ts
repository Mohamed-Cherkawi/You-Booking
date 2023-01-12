import {RoleEnum} from "../../enums/role.enum";

export class RegisterRequest {
   username!: string;
   password!: string;
   name!: string;
   phone!: string;
   role!: RoleEnum;
}
