package com.idea.subway.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AccountPriceUtil {
    /**
     * @description 计算票价
     * @param kilometres
     * @return double
     */
    public double accountPrice(double kilometres){
       double price = 2;
        if (kilometres <= 4) {
            return 2;
        } else if (kilometres > 4 && kilometres <= 12) {
           return price + Math.ceil((kilometres - 4) / 4);
        } else if (kilometres > 12 && kilometres <= 24) {
            return price + Math.ceil((kilometres - 12) / 6) + 2;
        } else if (kilometres > 24 && kilometres <= 32) {
            return  price + Math.ceil((kilometres - 24) / 8) + 4;
        } else if (kilometres > 32 && kilometres <= 40) {
            return price + (kilometres - 32) / 8 + 6;
        } else {
            return price + ((kilometres - 40) / 8) + 6;
        }
    }
    /**
     * @description 判断当前时间是否在发车时间内
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return boolean
     */
    public boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        return date.after(begin) && date.before(end);
    }
    /**
     * @description 计算车到达时间
     * @param tt
     * @return String
     */
    public String cal(int tt){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE,-tt);
        int minute= cal.get(Calendar.MINUTE);
        int dd = (int)Math.ceil(minute*1.0/5);
        cal.add(Calendar.MINUTE,dd*5-minute+tt);
        Date time = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(time);
    }
}
