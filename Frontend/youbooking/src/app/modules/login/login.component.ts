import { Component, OnInit } from '@angular/core';
import {FormGroup, Validators, FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  hide: boolean = false;

  constructor(private fb: FormBuilder) { }

  loginForm: FormGroup = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(5)]],
    password: ['', [Validators.required, Validators.minLength(6)]]
  })
  ngOnInit(): void {}

  onLogin(){
    if (!this.loginForm.valid) {
      return;
    }
    this.handleFormButton();

    console.log(this.loginForm.value.password);
  }

  handleFormButton(): void {
    const button = document.querySelector("button");
    button!.disabled = true;
    button!.style.opacity = "0.5";

    setTimeout(function () {
      button!.disabled = false;
      button!.style.opacity = "1";
    }, 1000);
  }
}
