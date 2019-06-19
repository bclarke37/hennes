import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getDate {

      DateFormat dateFormat = new SimpleDateFormat("MMMMM dd (E) hh:mm a");
      Date date = new Date();
      
      public String date() {
         return "" + dateFormat.format(date);
      }
}