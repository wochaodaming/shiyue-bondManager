/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.shiyue.bm.core.util;

import com.shiyue.bm.core.log.CoreLog;
import org.slf4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Xinyu LI<lixinyu01@baidu.com>
 * Date: 2015/7/14
 * Time: 10:55
 */
public class IpUtils {
    private static final Logger LOG = CoreLog.getLogger();

    public static int ipStringToInt(String ipString) {
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName(ipString);
        } catch (Exception e) {
            return 0;
        }
        int ipInt;
        byte[] addrBytes = inetAddress.getAddress();
        ipInt = ((addrBytes[0] & 0xff) << 24)
                | ((addrBytes[1] & 0xff) << 16)
                | ((addrBytes[2] & 0xff) << 8)
                | (addrBytes[3] & 0xff);
        return ipInt;
    }

    public static String getLocalHostAddress() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            LOG.error("SystemTools: Can't get local ip。", e);
            return "";
        }
    }
}
