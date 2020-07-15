package hs.dcl.test.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hs.dcl.test.config.CustomJsonDeserializer;
import hs.dcl.test.config.CustomJsonSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    //入参使用(类型转化，将json类型转换为LocalDateTime，而不是将日期格式化)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//(表单)
    @JsonDeserialize(using = CustomJsonDeserializer.DateSort.class)//(json使用)
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @JsonSerialize(using = CustomJsonSerializer.DateShort.class)//出参使用（格式化日期）
    private String endTime;
}
