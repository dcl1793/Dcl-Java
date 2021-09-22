package hs.dcl.test.model.dto;

import lombok.Data;

@Data
public class GraphDTO {

    private String devId;

    /**
     * 图片数据 base64编码后的字符串
     */
    private String thumbnail;

    /**
     * 流地址
     */
    private String rtmpAddr;

    /**
     * 最后更新时间 格式2021-02-05 01:45:52
     */
    private String lastUpdate;
}
