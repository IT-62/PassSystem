
package src.edu;

import java.util.Calendar;
import java.util.Date;

public class DatePass extends SkiPass {

    private Date activationDate;
    private Date expirationDate;

    public Date getActivationDate() {
        return activationDate;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }

	private void setExpirationDate(double days) {
		expirationDate = (Date)activationDate.clone();
		double i = -1;

		days = (days < 0) ? 0 : days;
		while (++i < days) {
			while (!isRightDay(this.getType(), expirationDate))
				expirationDate.setTime(expirationDate.getTime() + 24 * 60 * 60 * 1000);
			expirationDate.setTime(expirationDate.getTime() + 24 * 60 * 60 * 1000);
		}
		expirationDate.setTime(
				(long)(expirationDate.getTime() + (days - i) * 24 * 60 * 60 * 1000));
	}



	public static DatePass newWeekdayPass(Date activationDate, double days) {
		DatePass pass = new DatePass();

		pass.setType(Type.Weekday);
		pass.activationDate = activationDate;
		pass.setExpirationDate(days);
		return (pass);
	}

	public static DatePass newWeekendPass(Date activationDate, double days) {
		DatePass pass = new DatePass();

		pass.setType(Type.Weekend);
		pass.activationDate = activationDate;
		pass.setExpirationDate(days);
		return (pass);
	}

	@Override

	public boolean pass() {
    	Date now = new Date();

    	return (activationDate.before(now) && expirationDate.after(now));
	}
}
