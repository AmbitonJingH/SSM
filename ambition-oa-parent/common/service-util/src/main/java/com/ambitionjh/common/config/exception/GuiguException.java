package com.ambitionjh.common.config.exception;
/*
 * @author  AmbitionJingH
 * @date  2023/9/25 19:56
 * @version 1.0
 */

import com.ambitionjh.common.result.ResultCodeEnum;
import lombok.Data;

@Data
public class GuiguException extends RuntimeException{
    private Integer code;//状态码
    private String msg;//描述信息

    public GuiguException(Integer code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public GuiguException(ResultCodeEnum resultCodeEnum) {
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
