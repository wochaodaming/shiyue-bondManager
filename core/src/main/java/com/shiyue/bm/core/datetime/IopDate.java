package com.shiyue.bm.core.datetime;

import java.text.ParseException;
import java.util.Date;

/**
 * 定制化的日期类
 * <p>
 * Created by lishenghao01 on 16/5/9.
 */
public class IopDate extends Date {

    public IopDate() {

    }

    public IopDate(long date) {
        super(date);
    }

    public IopDate(Date date) {
        super(date.getTime());
    }

    public IopDate(String yyyyMmDdHhMmSs) throws ParseException {
        this(IopDateUtil.yyyy_MM_dd_HH_mm_ss.parse(yyyyMmDdHhMmSs));
    }

    public String yyyyMMddHHmmss() {
        return IopDateUtil.yyyy_MM_dd_HH_mm_ss.format(this);
    }

    @Override
    public String toString() {
        return this.yyyyMMddHHmmss();
    }
}
