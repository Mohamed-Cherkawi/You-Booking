import {RoleEnum} from "../../enums/role.enum";

export class RegisterRequest {
   username!: string;
   password!: string;
   name!: string;
   phone!: string;
   role!: RoleEnum;

  constructor() {}


  setUsername(value: string) {
    this.username = value;
  }

  setPassword(value: string) {
    this.password = value;
  }

  setName(value: string) {
    this.name = value;
  }

  setPhone(value: string) {
    this.phone = value;
  }

  setRole(value: RoleEnum) {
    this.role = value;
  }
}
