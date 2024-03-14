import { Component, OnDestroy, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Subject, takeUntil } from 'rxjs';
import { selectUserData } from '../../../store/user/user.selectors';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.scss',
})
export class HomePageComponent implements OnInit, OnDestroy {
  private readonly store: Store = inject(Store);
  private ngDestroyed$ = new Subject<void>();
  welcome: string = "";
  ngOnInit(): void {
    this.store
      .select(selectUserData)
      .pipe(takeUntil(this.ngDestroyed$))
      .subscribe((user) => {
        this.welcome = "Bienvenido " + user?.roles[0]+ "   "+ user?.name +"   "+ user?.lastname 
      });
  }
  ngOnDestroy(): void {
    this.ngDestroyed$.next();
    this.ngDestroyed$.complete();
  }
}
