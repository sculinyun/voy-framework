package cn.com.mw.app.framework.common.util.geo;

import java.text.DecimalFormat;

/**
 * @author : ly
 * @date : 2022-10-14 14:02
 **/
public class GeoUtil {
    private static double EARTH_RADIUS = 6378.137;
    private static String DF = "0.00";

    private static double rad(double d) {
        return (d * Math.PI) / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 距离
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                (Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(
                        b / 2), 2))));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;

        return s;
    }

    /**
     * 显示2位小数公里
     * @param d
     * @return
     */
    public static String kmLength(double d){
        DecimalFormat df=new DecimalFormat(DF);
        return df.format(d/1000);
    }

}
