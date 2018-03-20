
package src.edu;

public class CountPass extends SkiPass {

    private int rides;

    public int getRides() {
        return rides;
    }



    public static CountPass newWeekdayPass(int rides) {
        CountPass pass = new CountPass();

        pass.setType(Type.Weekday);
        pass.rides = (rides < 0) ? 0 : rides;
        return (pass);
    }

    public static CountPass newWeekendPass(int rides) {
		CountPass pass = new CountPass();

        pass.setType(Type.Weekend);
        pass.rides = (rides < 0) ? 0 : rides;
        return (pass);
    }



	public void decRides() {
		--rides;
	}

	@Override

	public boolean pass() {
    	if (rides > 0) {
    		this.decRides();
    		return (true);
		}
		else
			return (false);
	}
}
