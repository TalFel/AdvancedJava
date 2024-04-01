import java.time.Month;
import java.util.*;
//a class that implements all the calendar utilities needed.
public class CalendarHelper {
    public static final int DAYS_IN_WEEK = 7;//no of days in week
    public static final int WEEKS_IN_MONTH = 6;//no of weeks displayed in a month
    private TreeMap<String,String> map;//TreeMap of the text for edited days.
    private Calendar cal;//the calendar object.
    private final String[] DAYS = {"sun", "mon", "tus", "wed", "thu", "fri", "sat"};//names of the days in a week.
    private final String[] MONTHS = {"January","February","March","April","May","June","July",
            "August","September","October","November","December"};//name of the months
    private int[][] month;//represents the month dates.

    /**
     * constructor for CalendarHelper.
     */
    public CalendarHelper(){
        map = new TreeMap<String,String>();
        cal = Calendar.getInstance();
        createMonth();
    }

    /**
     * creates a new month by the current month and year info from the calendar.
     */
    public void createMonth(){
        cal.set(Calendar.DAY_OF_MONTH, 1);
        month = new int[DAYS_IN_WEEK][WEEKS_IN_MONTH];
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        for(int j = 0; j < WEEKS_IN_MONTH; j++){
            for(int i = 0; i < DAYS_IN_WEEK; i++){
                month[i][j] = -1;
                int current = i + j * DAYS_IN_WEEK + 1;
                if(current < firstDay || current - firstDay + 1 > daysInMonth){
                    month[i][j] = -1;
                }
                else{
                    month[i][j] = current - firstDay + 1;
                }
            }
        }
    }

    /**
     * updates the month and year accordingly for the next month.
     */
    public void nextMonth(){
        if(cal.get(Calendar.MONTH) == 12){
            cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + 1);
            cal.set(Calendar.MONTH, 1);
        }
        else{
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
        }
        createMonth();
    }

    /**
     * updates the month and year accordingly for the prev month.
     */
    public void prevMonth(){
        if(cal.get(Calendar.MONTH) == 1){
            cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 1);
            cal.set(Calendar.MONTH, 12);
        }
        else{
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
        }
        createMonth();
    }

    /**
     * @return a string representation of the current month and year.
     */
    public String getMonthYear(){
        return MONTHS[cal.get(Calendar.MONTH)] + ", " + cal.get(Calendar.YEAR);
    }

    /**
     * @param i the number of the day
     * @return the name of the day
     */
    public String getDay(int i){
        return DAYS[i];
    }

    /**
     * @param i row
     * @param j col
     * @return the date of the month in this specific row and col.
     */
    public int getLabel(int i, int j){
        return month[i][j];
    }

    /**
     * @param day the required date
     * @return the text of the map for the current date.
     */
    public String getTextFromMap(int day){
        return map.get(day + ", " + getMonthYear());
    }

    /**
     * @param day the day to update
     * @param message the text to update for the date.
     */
    public void updateMap(int day, String message) {
        map.put(day + ", " + getMonthYear(), message);
    }
}
