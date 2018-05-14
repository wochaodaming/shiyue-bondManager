package com.shiyue.bm.core.basestruct;

/**
 * Operator的线程局部变量
 * <br/>
 * Created on 16/10/26.
 *
 * @auther lishenghao01
 */
public class OperatorThreadLocal {
    /**
     * Operator的线程局部变量
     */
    private static final ThreadLocal<Operator> operatorThreadLocal = new ThreadLocal<>();


    public static final ThreadLocal<Operator> getOperatorThreadLocal() {
        return operatorThreadLocal;
    }
}
