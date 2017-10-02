
/**
 * The ClockDisplay class implements a digital clock display for a
 * 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 11:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Lucita Fortes
 * @version 2017.10.01
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 12:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12,12);
        minutes = new NumberDisplay(60,0);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(12,12);
        minutes = new NumberDisplay(60,0);
        updateDisplay();
        setTime(hour, minute); 
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if (hours.getValue() == 0) {
                hours.setHourValue(12);
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        if ((hour <= 12) && (minute < 60)) 
            {
            hours.setHourValue(hour);
            minutes.setValue(minute);
            updateDisplay();
            }
        else if (hour > 12)
            System.out.println("Hour should be <= 12");
        else
            System.out.println("Minutes should be < 60");   
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}
