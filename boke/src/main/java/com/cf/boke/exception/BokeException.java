package com.cf.boke.exception;
/*
 * @author  AmbitionJingH
 * @date  2023/12/2 22:41
 * @version 1.0
 */

import com.cf.boke.result.ResultCodeEnum;

public class BokeException extends RuntimeException{
    private Integer code;//状态码
    private String msg;//描述信息

    public BokeException(Integer code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public BokeException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
