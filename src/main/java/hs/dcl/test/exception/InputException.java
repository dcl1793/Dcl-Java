package hs.dcl.test.exception;

import lombok.Getter;

/**
 * 描述：
 *
 * @Description: 说明
 * @ProductName: Hundsun HEP
 * @ProjectName: iwin-stockincentive
 * @Package: org.iwin.stockincentive.api.common.exception
 * @Author: zhangbro
 * @CreateDate: 2020/6/30 14:07
 * @UpdateUser: zhangbro
 * @UpdateDate: 2020/6/30 14:07
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/

public class InputException extends RuntimeException {
    @Getter
    private String msg;
    
    public InputException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
