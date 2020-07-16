package hs.dcl.test.model.req;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author dacl30868
 * @description: 嵌套校验
 * @date 2020/7/16 16:55
 */
@Data
public class ItemREQ implements Serializable {

        @NotNull(message = "id不能为空")
        @Min(value = 1, message = "id必须为正整数")
        private Long id;

        @Valid // 嵌套验证必须用@Valid
        @NotNull(message = "props不能为空")
        @Size(min = 1, message = "props至少要有一个自定义属性")
        private List<PropREQ> props;
}
