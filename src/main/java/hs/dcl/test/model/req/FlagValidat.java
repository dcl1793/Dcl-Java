package hs.dcl.test.model.req;

import hs.dcl.test.annotation.FlagValidator;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dacl30868
 * @description: 自定义校验入参
 * @date 2020/7/16 19:13
 */
@Data
public class FlagValidat implements Serializable {
        // 前端传入的flag值必须是1或2或3，否则校验失败
        @FlagValidator(values = "1,2,3")
        private String flag ;
}
