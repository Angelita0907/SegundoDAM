import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '@core/services/auth.service';
import { StatisticsService, ReadingProgress, ComprehensionData } from '@core/services/statistics.service';
import { User, UserStats } from '@core/models/user.model';

@Component({
  selector: 'app-statistics',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  user = signal<User | null>(null);
  stats = signal<UserStats | null>(null);
  readingProgress = signal<ReadingProgress[]>([]);
  comprehensionTrend = signal<ComprehensionData[]>([]);
  weeklyActivity = signal<{ dia: string; activo: boolean }[]>([]);
  loading = signal(true);

  constructor(
    private authService: AuthService,
    private statisticsService: StatisticsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const currentUser = this.authService.currentUser();
    
    if (!currentUser) {
      this.router.navigate(['/auth/login']);
      return;
    }

    this.user.set(currentUser);
    this.loadStatistics(currentUser.id);
  }

  private loadStatistics(userId: string): void {
    this.loading.set(true);

    // Cargar todas las estadísticas en paralelo
    Promise.all([
      this.statisticsService.getUserStats(userId).toPromise(),
      this.statisticsService.getReadingProgress(userId, 7).toPromise(),
      this.statisticsService.getComprehensionTrend(userId).toPromise(),
      this.statisticsService.getWeeklyActivity(userId).toPromise()
    ]).then(([stats, progress, trend, activity]) => {
      if (stats) this.stats.set(stats);
      if (progress) this.readingProgress.set(progress);
      if (trend) this.comprehensionTrend.set(trend);
      if (activity) this.weeklyActivity.set(activity);
      this.loading.set(false);
    }).catch(error => {
      console.error('Error loading statistics:', error);
      this.loading.set(false);
    });
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/auth/login']);
  }

  getProgressBarWidth(value: number): string {
    return `${Math.min(value, 100)}%`;
  }

  getSpeedLevel(speed: number): string {
    if (speed < 200) return 'Principiante';
    if (speed < 300) return 'Intermedio';
    if (speed < 400) return 'Avanzado';
    return 'Experto';
  }

  getComprehensionLevel(comprehension: number): string {
    if (comprehension < 60) return 'En desarrollo';
    if (comprehension < 75) return 'Bueno';
    if (comprehension < 90) return 'Muy bueno';
    return 'Excelente';
  }

  formatMinutes(minutes: number): string {
    const hours = Math.floor(minutes / 60);
    const mins = minutes % 60;
    if (hours > 0) {
      return `${hours}h ${mins}m`;
    }
    return `${mins}m`;
  }
}
