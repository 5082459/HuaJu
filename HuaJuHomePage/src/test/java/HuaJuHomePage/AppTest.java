package HuaJuHomePage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("=====");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        try {
            Date date = simpleDateFormat.parse("2019-11-27 23:00:00");
//            System.out.println("date.getTime() = " + date.getTime() + "  " + currentDate.getTime());

            System.out.println(date.before(currentDate));

//            long toCurrent = (date.getTime() - currentDate.getTime())/(60*60*1000);
//            System.out.println("toCurrent = " + toCurrent);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
