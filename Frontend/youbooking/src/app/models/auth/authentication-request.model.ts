export class AuthenticationRequest {
   username!: string;
   password!: string;

  constructor() {}

  setUsername(value: string) {
    this.username = value;
  }

  setPassword(value: string) {
    this.password = value;
  }
}
