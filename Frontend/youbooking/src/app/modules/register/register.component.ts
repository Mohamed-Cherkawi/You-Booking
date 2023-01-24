import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";
import {RegisterRequest} from "../../models/auth/register-request.model";
import {Role} from "../../utils/role.util";
import {AuthenticationResponse} from "../../models/auth/authentication-response.model";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  hide: boolean = false;
  isUsernameUsed: boolean = false;
  registerRequest: RegisterRequest = new RegisterRequest();
  registerForm!: FormGroup ;
  roles: Role[] = [
    {value: 'CLIENT', viewValue: 'Client'},
    {value: 'OWNER', viewValue: 'Hotel Owner'}
  ];

  constructor(
    private fb: FormBuilder ,
    private router: Router ,
    private authService: AuthenticationService) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(5)]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      name: this.fb.group({
        firstName: ['' , [Validators.required , Validators.minLength(1)]],
        lastName: ['' , [Validators.required , Validators.minLength(1)]],
      }) ,
      phone: ['' , [Validators.required , Validators.minLength(10)]],
      role: ['' , Validators.required]
    });
  }

  public onRegister() {
    localStorage.removeItem('token');

    if(!this.registerForm.valid)
      return;

    this.handleFormButton();
    this.registerRequest.setUsername(this.registerForm.value.username);
    this.registerRequest.setPassword(this.registerForm.value.password);
    this.registerRequest.setRole(this.registerForm.value.role);
    this.registerRequest.setPhone(this.registerForm.value.phone);
    this.registerRequest.setName(
      this.registerForm.value.name.firstName + ' ' +
      this.registerForm.value.name.lastName);

    this.authService.register(this.registerRequest)
      .subscribe(
        {
          next:
            (response: AuthenticationResponse) => {
              console.log(response);
              localStorage.setItem('token',response.token);
              this.redirectToHome();
            },
          error:
            (error : HttpErrorResponse) => {
              this.isUsernameUsed = true;
            }
        });
  }
  private redirectToHome(){
    this.router.navigate(['/home']);
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
