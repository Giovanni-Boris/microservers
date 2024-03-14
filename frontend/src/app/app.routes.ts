import { Routes } from '@angular/router';
import { AuthGuard } from './modules/shared/guards/auth.guard';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('./modules/dashboard/dashboard.routes').then(
        (mod) => mod.DASHBOARD_ROUTES
      ),
      canActivate: [AuthGuard.canActivate],
  },
  {
    path: 'auth',
    loadChildren: () =>
      import('./modules/auth/auth.routes').then((mod) => mod.AUTH_ROUTES),
  },
  { path: '**', redirectTo: '/auth/login', pathMatch: 'full' }
];
