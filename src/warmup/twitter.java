package warmup;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

public class twitter {
    public static String dateparse(String s){
        SimpleDateFormat ForMatter = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm");
        ForMatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.US);
        Date date = new Date();
        String res = new String();
        try{
            date = formatter.parse(s);
            res = ForMatter.format(date);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(dateparse("08/Sep/2015:10:55:15 +0000"));
        System.out.println(dateparse("31/Nov/2012:05:00:18 +0300"));
    }
}
