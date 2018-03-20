package src.edu;

import java.util.*;

public class SkiPass {

	public enum Type { Weekday, Weekend, Season }

	private int id;
	private Type type;
	private boolean isBlocked;

	public int getID() {
		return id;
	}

	public void setID(PassSystem system) {
		id = system.getPassCounter();
	}

	public Type getType() {
		return (type);
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isBlocked() {
		return isBlocked;
	}



	public static SkiPass newSeasonPass() {
		SkiPass pass = new SkiPass();

		pass.type = Type.Season;
		return (pass);
	}



	public void block() {
		isBlocked = true;
	}

	public void unblock() {
		isBlocked = false;
	}

	public static boolean isRightDay(Type type, Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		return ((type == Type.Weekday) == (calendar.get(Calendar.DAY_OF_WEEK) > 1 &&
				calendar.get(Calendar.DAY_OF_WEEK) < 7));
	}

	public boolean pass() {
		return (false);
	}
}
