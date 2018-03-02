package src.edu;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PassSystem {
	private LocalTime DayStart;
	private LocalTime DayEnd;

	public LocalTime getDayStart() {
		return DayStart;
	}

	public LocalTime getDayEnd() {
		return DayEnd;
	}

	public PassSystem(LocalTime dayStart, LocalTime dayEnd) {
		DayStart = dayStart;
		DayEnd = dayEnd;
	}

	private static Boolean isWorkingHours(LocalTime dayStart,
										  LocalTime dayEnd) {
		return (LocalTime.now().isAfter(dayStart) &&
				LocalTime.now().isBefore(dayEnd));
	}

	private static Boolean isRightDayOfWeek(SkiPass.Types type) {
		if (type == SkiPass.Types.Weekday)
			return (LocalDateTime.now().getDayOfWeek().ordinal() < 5);
		else
			return (LocalDateTime.now().getDayOfWeek().ordinal() > 4);
	}

	public Boolean pass(SkiPass skiPass) {
		switch (skiPass.Type) {
			case Season:
				return (isWorkingHours(DayStart, DayEnd));

			case Weekday:
			case Weekend:
				if (!isWorkingHours(DayStart, DayEnd) ||
						!isRightDayOfWeek(skiPass.Type))
					return (false);
				if (skiPass.getDateTill() != null)
					return (LocalTime.now().isBefore(skiPass.getDateTill().toLocalTime()));
				else if (skiPass.getRides() > 0) {
					skiPass.decRides();
					return (true);
				}
				else
					return (false);
		}
		return (false);
	}
}
