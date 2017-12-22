package helpers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateToChoose {

    private List<String> yearList;
    private List<String> monthList;
    private List<String> dayList;

    public DateToChoose() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int endYear = Integer.parseInt(simpleDateFormat.format(date));

        int firstYear = 2017;
        int firstMonth = 1;
        int firstDay = 1;

        yearList = new ArrayList<String>();
        monthList = new ArrayList<String>();
        dayList = new ArrayList<String>();

        for(int startYear=firstYear;startYear<=endYear;startYear++) {
            yearList.add(String.valueOf(startYear));
        }

        for(int startMonth=firstMonth;startMonth<=12;startMonth++) {
            monthList.add(String.valueOf(startMonth));
        }

        for(int startDay=firstDay;startDay<=31;startDay++) {
            dayList.add(String.valueOf(startDay));
        }

    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<String> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
    }

    public List<String> getDayList() {
        return dayList;
    }

    public void setDayList(List<String> dayList) {
        this.dayList = dayList;
    }

}
