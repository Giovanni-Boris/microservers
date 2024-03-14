import { Component, OnDestroy, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChartComponent } from '../../../shared/components/chart/chart.component';
import { TableComponent } from '../../../shared/components/table/table.component';
import { UserService } from '../../../shared/services/user.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../../../shared/interfaces/user.model';
import { Observable, Subject, map, switchAll, switchMap, takeUntil } from 'rxjs';
import { OrderService } from '../../../shared/services/order.service';
import { Order } from '../../../shared/interfaces/order.model';

@Component({
  selector: 'app-single-user-page',
  standalone: true,
  imports: [CommonModule, ChartComponent, TableComponent],
  templateUrl: './single-user-page.component.html',
  styleUrl: './single-user-page.component.scss',
})
export class SingleUserPageComponent implements OnInit, OnDestroy {
  private userService = inject(UserService);
  private route = inject(ActivatedRoute);
  private orderService = inject(OrderService);
  ordersUser$ : Observable<Order[]> | undefined;
  _actualUser: User | undefined;
  ngDestroy$ = new Subject<void>();
  set actualUser(user: User){
    this._actualUser = user;
    this.ordersUser$ = this.orderService.getOrdersUser(this._actualUser.id);
  }
  get actualUser(): User | undefined{
    return this._actualUser;
  }
  ngOnInit(): void {
    this.route.params
      .pipe(
        map((params) => params['userId']),
        switchMap((userId) => this.userService.getUserData(userId)),
        takeUntil(this.ngDestroy$)
      )
      .subscribe((user) => {
        this.actualUser = user;
      });
  }
  ngOnDestroy(): void {
    this.ngDestroy$.next();
    this.ngDestroy$.complete();
  }
}
