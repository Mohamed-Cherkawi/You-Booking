import { Component, OnInit } from '@angular/core';
import {FormGroup, Validators, FormBuilder} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";
import {AuthenticationRequest} from "../../models/auth/authentication-request.model";
import {HttpErrorResponse} from "@angular/common/http";
import {AuthenticationResponse} from "../../models/auth/authentication-response.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  hide: boolean = false;
  credentialsError: boolean = false;
  loginForm: FormGroup = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(5)]],
    password: ['', [Validators.required, Validators.minLength(6)]]
  })

  constructor(
    private fb: FormBuilder ,
    private router: Router ,
    private authService: AuthenticationService) { }


  public ngOnInit(): void {}

  public onLogin(){
    if (!this.loginForm.valid) {
      return;
    }
    this.handleFormButton();

    this.authService.authenticate(new AuthenticationRequest(this.loginForm.value.username,this.loginForm.value.password))
      .subscribe(
       {
       next:
         (response: AuthenticationResponse | string) => {
         this.credentialsError = false;
         console.log(response);
         this.redirectToHome();
         },
       error:
         (error : HttpErrorResponse) => {
           this.credentialsError = true;
         }
     });
  }
  private redirectToHome(){
    this.router.navigate(['/register']);
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
