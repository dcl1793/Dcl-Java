package hs.dcl.test.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hs.dcl.test.config.CustomJsonDeserializer;
import hs.dcl.test.config.CustomJsonSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dacl30868
 * @description: 日期入参格式测试
 * @date 2020/7/13 16:00
 */
@Data
public class DateParamVO implements Serializable {

    /**
     * 开始时间
     */
    private String startTime;


    /**
     * 结束时间
     */
    private String endTime;
}
