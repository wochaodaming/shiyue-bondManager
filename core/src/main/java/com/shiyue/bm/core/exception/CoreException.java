/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.shiyue.bm.core.exception;


import com.shiyue.bm.core.exception.base.RootException;

/**
 * ClassName: CoreException <br>
 * Description: Level模块的异常 <br>
 * Date: 2015年11月24日 下午9:14:36 <br>
 *
 * @author lishenghao01(邮箱)
 */
public class CoreException extends RootException {
    public CoreException(ErrKey errKey) {
        super(String.valueOf(errKey.getCode()), errKey.getMsg());
    }

    public CoreException(ErrKey errKey, Throwable t) {
        super(String.valueOf(errKey.getCode()), errKey.getMsg(), t);
    }

    public CoreException(ErrKey errKey, String errMsg) {
        super(String.valueOf(errKey.getCode()), errMsg);
    }

    public CoreException(ErrKey errKey, String errMsg, Throwable t) {
        super(String.valueOf(errKey.getCode()), errMsg, t);
    }


}
