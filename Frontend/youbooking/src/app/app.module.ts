import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LoginComponent } from './modules/login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from "@angular/material/card";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {RouterOutlet} from "@angular/router";
import {MatIconModule} from "@angular/material/icon";
import {AppRoutingModule} from "./app-routing.module";
import { RegisterComponent } from './modules/register/register.component';
import {TokenInterceptor} from "./requests/token.interceptor";
import {MatSelectModule} from "@angular/material/select";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        BrowserAnimationsModule,
        MatCardModule,
        MatInputModule,
        MatButtonModule,
        ReactiveFormsModule,
        RouterOutlet,
        MatIconModule,
        AppRoutingModule,
        MatSelectModule
    ],
  providers: [
    {
      // First request interceptor
      provide: HTTP_INTERCEPTORS, // tells Angular to use the TokenInterceptor class as an HTTP interceptor
      useClass: TokenInterceptor, // tells Angular that there might be multiple interceptors and this one should be added to the list of interceptors.
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
