package hs.dcl.test.model.req;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author dacl30868
 * @description: 自定义校验
 * @date 2020/7/27 13:45
 */
@Data
public class Validate7REQ implements Serializable {

    /**
     * 总人数
     */
    @NotNull
    @Min(value = 0, message = "总人数最小是0！")
    @Max(value = 10000000, message = "总人数最大是10000000！")
    @Pattern(regexp = "[1-9]\\d*|0", message = "总人数必须是非负整数！")
    private String totalPerson;

    /**
     * 总数量
     */
    @NotNull
    @Pattern(regexp = "^(([1-9]\\d*|0)|([0]{1}))(\\.(\\d){0,4})?$", message = "总数量必须是非负数！")
    @Min(value = 0, message = "总数量最小是0！")
    @Digits(message = "总数量整数位最多10位,小数位最多4位！", integer = 10, fraction = 4)
    private String totalNum;

    /**
     * 授予价格
     */
    @NotNull
    @Pattern(regexp = "^(([1-9]\\d*|0)|([0]{1}))(\\.(\\d){0,2})?$", message = "授予价格必须是非负数！")
    @Min(value = 0, message = "授予价格最小是0！")
    @Digits(message = "授予价格整数位最多10位，小数位最多2位！", integer = 10, fraction = 2)
    private String grantPrice;

    /**
     * 期数
     */
    @NotNull
    @Pattern(regexp = "^[1-9]d*$", message = "期数必须是正整数！")
    @Min(value = 1, message = "期数最小是1！")
    @Max(value = 100, message = "期数最大是100！")
    private String times;

}
