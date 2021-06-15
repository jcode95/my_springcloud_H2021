package org.zj.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

//@Data 生成getter,setter ,toString等函数
@NoArgsConstructor //生成无参构造函数
@AllArgsConstructor //生成全参数构造函数
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
