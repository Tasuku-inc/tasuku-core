package ru.mephi.tasuku.sprint;

import java.time.LocalDate;
import java.util.List;

import ru.mephi.tasuku.sprint.service.object.Sprint;

public class SprintUtils {
    private static final int COUNT_OF_DAYS_PER_WEEK = 7;
    private static final int ONE_DAY = 1;

    public static Sprint getActual() {
        LocalDate now = LocalDate.now();
        LocalDate fromDate = now.minusDays(now.getDayOfWeek().getValue() - ONE_DAY);
        LocalDate toDate = now.plusDays(COUNT_OF_DAYS_PER_WEEK - now.getDayOfWeek().getValue());
        return Sprint.builder()
                .fromDate(fromDate)
                .toDate(toDate)
                .build();
    }

    public static Sprint getLast(List<Sprint> sprints) {
        return sprints.get(sprints.size() - 1);
    }
}
