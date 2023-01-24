import {NgModule} from "@angular/core";
import {Routes , RouterModule} from "@angular/router";
import {LoginComponent} from "./modules/login/login.component";
import {RegisterComponent} from "./modules/register/register.component";
import {HomeComponent} from "./modules/home/home.component";
import {TestComponent} from "./modules/test/test.component";

const routes: Routes = [
  { path: 'login' , component: LoginComponent },
  { path: 'register' , component: RegisterComponent},
  { path: 'home' , component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
