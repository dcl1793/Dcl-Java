package hs.dcl.test.model.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author dacl30868
 * @description: 嵌套校验
 * @date 2020/7/16 16:56
 */
@Data
public class PropREQ implements Serializable {

        @NotNull(message = "pid不能为空")
        @Min(value = 1, message = "pid必须为正整数")
        private Long pid;

        @NotNull(message = "vid不能为空")
        @Min(value = 1, message = "vid必须为正整数")
        private Long vid;

        @NotBlank(message = "pidName不能为空")
        private String pidName;

        @NotBlank(message = "vidName不能为空")
        private String vidName;
}
