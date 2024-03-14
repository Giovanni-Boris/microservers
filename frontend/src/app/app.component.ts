import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { Store } from '@ngrx/store';
import { selectThemeMode } from './modules/store/theme/theme.selectors';
import { selectIsLogged } from './modules/store/user/user.selectors';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  private readonly store: Store = inject(Store);
  isLoggedIn$ = this.store.select(selectIsLogged)
  darkMode$ = this.store.select(selectThemeMode);
}
