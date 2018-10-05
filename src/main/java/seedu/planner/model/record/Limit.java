package seedu.planner.model.record;

import static seedu.planner.commons.util.CollectionUtil.requireAllNonNull;

    /*
    * Limit used to offer a function as a reminder to user about their money usage.
    * */
    public class Limit {

    public static final String LIMIT_FORMAT= "%s %s %s";
    private Date date_start;
    private Date date_end;
    private MoneyFlow limit_money;




    public Limit (Date date_start , Date date_end, MoneyFlow limit_money) {
      requireAllNonNull(date_end, date_start, limit_money );
      this.date_start= date_start;
      this.date_end= date_end;
      this.limit_money= limit_money;
  }

  @Override
    public String toString () { return String.format("LIMIT_FORMAT", date_start, date_end, limit_money);}


  public Date getDate_start (){ return date_start;}

  public Date getDate_end (){ return date_end;}

  public MoneyFlow getLimit_money() { return limit_money; }
}