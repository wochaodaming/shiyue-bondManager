/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.shiyue.bm.core.exception;


import com.shiyue.bm.core.exception.base.RootRuntimeException;

/**
 * ClassName: CoreRuntimException <br>
 * Description: TODO <br>
 * Date: 2015年11月24日 下午9:14:40 <br>
 *
 * @author lishenghao01(邮箱)
 */
public class CoreRuntimException extends RootRuntimeException {
    public CoreRuntimException(ErrKey errKey) {
        super(String.valueOf(errKey.getCode()), errKey.getMsg());
    }

    public CoreRuntimException(ErrKey errKey, Throwable t) {
        super(String.valueOf(errKey.getCode()), errKey.getMsg(), t);
    }

    public CoreRuntimException(ErrKey errKey, String errMsg) {
        super(String.valueOf(errKey.getCode()), errMsg);
    }

    public CoreRuntimException(ErrKey errKey, String errMsg, Throwable t) {
        super(String.valueOf(errKey.getCode()), errMsg, t);
    }

}
