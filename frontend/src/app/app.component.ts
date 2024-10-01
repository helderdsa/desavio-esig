import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { MainComponent } from './main/main.component';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, MainComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  constructor(private router: Router) {}
  title = 'frontend';

  goTo(route: String): void {
    this.router.navigate([route])
  }
}
