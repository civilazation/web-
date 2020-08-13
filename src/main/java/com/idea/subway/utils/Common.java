package com.idea.subway.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common {
    public String calculateTime(int tt){
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.MINUTE);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        int m=i%5;
        switch (m){
            case 0:
                if(tt==0&&m==0){
                    return sdf.format(new Date());
                }else if(tt >= 5){
                    return sdf.format(new Date().getTime()-5*60*1000+tt*60*1000);
                }else if(tt>0&&tt<=4){
                    return sdf.format(new Date().getTime()+tt*60*1000);
                }
            case 1:
                if(tt==1&&m==1){
                    return sdf.format(new Date());
                }else if(tt>=2){
                    return sdf.format(new Date().getTime()-60*1000+tt*60*1000);
                }else {
                    return sdf.format(new Date().getTime()+4*60*1000+tt*60*1000);
                }
            case 2:
                if(tt==2&&m==2){
                    return sdf.format(new Date());
                }else if(tt>=3){
                    return sdf.format(new Date().getTime()-2*60*1000+tt*60*1000);
                }
                else{
                    return sdf.format(new Date(date.getTime()+3*60*1000+tt*60*1000));}
            case 3:
                if(tt==3&&m==3){
                    return sdf.format(new Date());
                }else if(tt>=4){
                    return sdf.format(new Date().getTime()-3*60*1000+tt*60*1000);
                }
                else {
                    return sdf.format(new Date(date.getTime()+2*60*1000+tt*60*1000));}
            case 4:
                if(tt==4&&m==4){
                    return sdf.format(new Date());
                }else if(tt>=5){
                    return sdf.format(new Date().getTime()-4*60*1000+tt*60*1000);
                }
                else{
                    return sdf.format(new Date(date.getTime()+60*1000+tt*60*1000));
                }
            default:
        }
        return null;
    }
}
