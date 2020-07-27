package hs.dcl.test.model.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author dacl30868
 * @description:
 * @date 2020/7/27 15:15
 */
@Data
public class Validate7DTO implements Serializable {

    /**
     * 总人数
     */
    private Integer totalPerson;

    /**
     * 总数量
     */
    private BigDecimal totalNum;

    /**
     * 授予价格
     */
    private BigDecimal grantPrice;

    /**
     * 期数
     */
    private Integer times;

}
