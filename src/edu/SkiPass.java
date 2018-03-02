package src.edu;

import java.lang.reflect.Type;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

public class SkiPass {
	public static HashMap<Types, HashMap> SkiPasses;
	public enum Types { Weekday, Weekend, Season }

	static {
		SkiPasses = new HashMap<Types, HashMap>(3);
		SkiPasses.put(Types.Weekday, new HashMap<UUID, SkiPass>(5000));
		SkiPasses.put(Types.Weekend, new HashMap<UUID, SkiPass>(5000));
		SkiPasses.put(Types.Season, new HashMap<UUID, SkiPass>(5000));
	}

	private UUID ID = UUID.randomUUID();
	private LocalDateTime DateFrom;
	private LocalDateTime DateTill;
	private int Rides;

	public Types Type;

	public UUID getID() {
		return ID;
	}

	public LocalDateTime getDateFrom() {
		return DateFrom;
	}

	public LocalDateTime getDateTill() {
		return DateTill;
	}

	public int getRides() {
		return Rides;
	}

	public void decRides() {
		--Rides;
	}

	public SkiPass(Types type) {
		Type = type;
		SkiPasses.get(type).put(ID, this);
	}

	public SkiPass(Types type, LocalDateTime dateFrom, int days) {
		// Available values for 'days': 0(for half of a day), 1, 2, 5
		DayOfWeek day;

		Type = type;
		DateFrom = dateFrom;
		DateTill = DateFrom;
		if (days == 0)
			DateTill = DateTill.plusHours(4);
		while (days != 0) {
			day = DateTill.getDayOfWeek();
			if ((type == Types.Weekday) ?
					(day.ordinal() > 4) : (day.ordinal() < 5))
				++days;
			--days;
			DateTill = DateTill.plusDays(1);
		}
		SkiPasses.get(type).put(ID, this);
	}

	public SkiPass(Types type, int rides) {
		Type = type;
		Rides = rides;
		SkiPasses.get(type).put(ID, this);
	}
}
