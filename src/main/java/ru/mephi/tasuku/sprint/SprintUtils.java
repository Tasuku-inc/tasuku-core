package ru.mephi.tasuku.sprint;

import java.time.LocalDate;
import java.util.List;

import ru.mephi.tasuku.sprint.service.object.Sprint;

public class SprintUtils {

    public static Sprint getActual() {
        LocalDate now = LocalDate.now();
        LocalDate fromDate = now.minusDays(now.getDayOfWeek().getValue() - 1);
        LocalDate toDate = now.plusDays(7 - now.getDayOfWeek().getValue());
        return Sprint.builder()
                .fromDate(fromDate)
                .toDate(toDate)
                .build();
    }

    public static Sprint getLast(List<Sprint> sprints) {
        return sprints.get(sprints.size() - 1);
    }
}
