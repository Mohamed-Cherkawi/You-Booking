import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";
import {RegisterRequest} from "../../models/auth/register-request.model";
import {Role} from "../../utils/role.util";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  hide: boolean = false;
  isUsernameUsed: boolean = false;
  registerRequest: RegisterRequest = new RegisterRequest();
  registerForm: FormGroup = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(5)]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    name: this.fb.group({
      firstName: ['' , [Validators.required , Validators.minLength(1)]],
      lastName: ['' , [Validators.required , Validators.minLength(1)]],
    }) ,
    phone: ['' , [Validators.required , Validators.minLength(10)]],
    role: ['' , Validators.required]
  });
  roles: Role[] = [
    {value: 'client', viewValue: 'Client'},
    {value: 'hotel-owner', viewValue: 'Hotel Owner'}
  ]
  constructor(
    private fb: FormBuilder ,
    private router: Router ,
    private authService: AuthenticationService) { }

  ngOnInit(): void {}

  public onRegister() {
    if(!this.registerForm.valid)
      return;

    this.handleFormButton();
    console.log(this.registerForm.value)

  }

  private handleFormButton(): void {
    const button = document.querySelector("button");
    button!.disabled = true;
    button!.style.opacity = "0.5";

    setTimeout(function() {
      button!.disabled = false;
      button!.style.opacity = "1";
    }, 1000);
  }
}
