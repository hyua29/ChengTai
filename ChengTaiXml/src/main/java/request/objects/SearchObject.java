package request.objects;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchObject {

    private Boolean Empty;

    private String sourceHb;
    private String cOrPSelect;
    private String ctyOrPod;

    private Date dateFrom;
    private Date dateTo;

    public SearchObject() {
        this.Empty = true;
        this.sourceHb = "";
        this.cOrPSelect = "";
        this.ctyOrPod = "";
    }

    /**
     * This method parse string to Date object
     * @param date String of date in YYYY-MMM-DD format
     * @param startAtZero indicates whether 'time' should start from the beginning of the day
     * @return Date object
     */
    private Date parseDate(String date, Boolean startAtZero) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateObject = null;
        try {
            String time;
            if(startAtZero)
                time = "00:00:00";
            else
                time = "23:59:59";
            dateObject = format.parse(date + " " + time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateObject;

    }

    public String getSourceHb() {
        return sourceHb;
    }

    public void setSourceHb(String sourceHb) {
        if(!sourceHb.equals(""))
            this.Empty = false;
        this.sourceHb = sourceHb;
    }

    public String getcOrPSelect() {
        return cOrPSelect;
    }

    public void setcOrPSelect(String cOrPSelect) {
        if(!cOrPSelect.equals(""))
            this.Empty = false;
        this.cOrPSelect = cOrPSelect;
    }

    public String getCtyOrPod() {
        return ctyOrPod;
    }

    public void setCtyOrPod(String ctyOrPod) {
        this.ctyOrPod = ctyOrPod;
    }

    public void setDateFrom(String dateFrom) {
        if(dateFrom.equals("")) // show all records if timeFrom not specified
           this.dateFrom = parseDate("2016-01-01", true);
        else
            this.dateFrom = parseDate(dateFrom, true);
    }

    public void setDateTo(String dateTo) {
        if(dateTo.equals(""))  // show all records until now
            this.dateTo = new Date();
         else
            this.dateTo = parseDate(dateTo, false);
    }

    public Date getDateFrom() {
        return this.dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public Boolean isEmpty() {
        return Empty;
    }

    @Override
    public String toString() {
        return "SearchObject{" +
                "Empty=" + Empty +
                ", sourceHb='" + sourceHb + '\'' +
                ", cOrPSelect='" + cOrPSelect + '\'' +
                ", ctyOrPod='" + ctyOrPod + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }

}
