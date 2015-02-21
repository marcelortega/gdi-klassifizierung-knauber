package dateCorrect;

import static gdi.MakeItSimple.*;

import java.util.GregorianCalendar;

import date.Date;
import date.Weekday;



public class DateImpl implements Date {
	private int day, month, year;
	private GregorianCalendar date = null;
	
	private static GregorianCalendar toGregCal ( int day, int month, int year ) {
		return new GregorianCalendar(year, month-1, day);
	}
	
	public DateImpl() {
		this.day = -1;
		this.month = -1;
		this.year = -1;
	}
	
	public DateImpl ( int day, int month, int year ) {
		this.day = day;
		this.month = month;
		this.year = year;
		if (isValid()) {
			date = toGregCal( day, month, year );
		} else {
			this.day = -1;
			this.month = -1;
			this.year = -1;
		}
	}
	
	public boolean isValid() {
		if (day<=0 | month<=0 | month>12)
			return false;
		else if (year<1582 | (year==1582 & month<10) | (year==1582 & month==10 & day<15))
			return false;
		else {
			GregorianCalendar gc = toGregCal(1, month, year);
			int maxDay = gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			return day<=maxDay;
		}
	}
	
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	
//	public boolean equals( Date d2 ) {
//		return this.date.equals(((DateImpl) d2).date);
//	}

	public boolean isLaterThan( Date d2 ) {
		return this.date.after(((DateImpl) d2).date);
	}

//	public boolean isEarlierThan( Date d2 ) {
//		return this.date.before(((DateImpl) d2).date);
//	}

	public Weekday getWeekday() {
		switch (this.date.get(GregorianCalendar.DAY_OF_WEEK)) {
			case 1:  return Weekday.SUNDAY;
			case 2:  return Weekday.MONDAY;
			case 3:  return Weekday.TUESDAY;
			case 4:  return Weekday.WEDNESDAY;
			case 5:  return Weekday.THURSDAY;
			case 6:  return Weekday.FRIDAY;
			case 7:  return Weekday.SATURDAY;
			default: return null;
		}
	}

	public int subtract( Date d2 ) {
		if (this.date.before(((DateImpl) d2).date))
			return -1;
		else {
			int days = 0;
			while (((DateImpl) d2).date.before(this.date)) {
				((DateImpl) d2).date.add(GregorianCalendar.DAY_OF_MONTH, 1);
				days++;
			}
			return days;
		}
	}

	public void loadFromFile( Object file ) {
		day = readInt(file);
		month = readInt(file);
		year = readInt(file);
		readLine(file);
		if (isValid())
			date = toGregCal( day, month, year );
	}

	public void saveToFile( Object file ) {
		println(file, day + " " + month + " " + year);
	}

//	public DateImpl add( int days ) {
//		if (days < 0)
//			return new DateImpl(-1, 1, 1); // ungueltiges Datum
//		else {
//			GregorianCalendar gc = toGregCal(getDay()+days, getMonth(), getYear());
//			return new DateImpl(gc.get(GregorianCalendar.DAY_OF_MONTH), gc.get(GregorianCalendar.MONTH)+1, gc.get(GregorianCalendar.YEAR));
//		}
//	}
	
}
