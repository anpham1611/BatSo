package com.apmv.batso.helper;

import java.util.Random;

public class Utils {

    public static int randomPort() {
        // Random port
        int min = 1000;
        int max = 9999;
        Random r = new Random();
        int i1 = r.nextInt(max - min + 1) + min;

        return i1;
    }

    public static long ipToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);

            // 1. 192 * 256^3
            // 2. 168 * 256^2
            // 3. 1 * 256^1
            // 4. 2 * 256^0
            result += ip * Math.pow(256, power);
        }
        return result;
    }

    public static String longToIp(long i) {
        return ((i >> 24) & 0xFF) +
                "." + ((i >> 16) & 0xFF) +
                "." + ((i >> 8) & 0xFF) +
                "." + (i & 0xFF);

    }

}
