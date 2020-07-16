package hs.dcl.test.model.req;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import hs.dcl.test.common.Constant;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author dacl30868
 * @description: 入参--入参校验测试
 * @date 2020/7/16 11:12
 */
@Data
public class ValidatedREQ implements Serializable {


    @NotBlank(message = "id集合必填")//message注解只作用在字符串上
    @Pattern(regexp = "(\\d+)(\\,\\d+)*", message = "多个id使用英文逗号分割")
    private String ids;

    @Size(min = 1,max = 10,message = "姓名长度必须为1到10")
    @NotEmpty(message = "名称必填")//(可以是空格)
    private String name;

    @Min(value = 10,message = "年龄最小为10")@Max(value = 100,message = "年龄最大为100")
    private Integer age;

    @Email(message = "邮箱格式错误")
    private  String email;

    @NotBlank(message = "手机号不能为空")//(不能是空格)
    private String mobile;

    private String remarks;

    @Pattern(regexp = "[0123]|\\s*", message = "员工属性：0员工、1高管、2大股东、3一致行动人")
    private String employeeType;

    @Pattern(regexp = "[012]", message = "发送渠道: 0 短信和APP、1 短信、2 APP")
    private String sendWay;

    @Pattern(regexp = "[0123]", message = "审核状态：0待审核、1待发送、2已发送、3不通过")
    private String status;

    @Pattern(regexp = Constant.REGEXP_NULLABLE_DATE_TIME, message = "创建时间格式不正确")
    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
