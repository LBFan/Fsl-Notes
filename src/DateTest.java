import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/01/02.
 */

public class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date newDate = simpleDateFormat.parse("2019-12-31 23:59:59");
        System.out.println(newDate);

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        Date newDate2 = simpleDateFormat.parse("2019-12-31 23:59:59");
        System.out.println(newDate2);


        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("YYYY-MM-DD");
        Date newDate4 = simpleDateFormat.parse("2020-01-01");
        System.out.println(newDate4);
    }
}

