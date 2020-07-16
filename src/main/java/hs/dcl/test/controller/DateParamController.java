package hs.dcl.test.controller;

import hs.dcl.test.model.vo.DateParamVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author dacl30868
 * @description: 日期出入参格式
 * @date 2020/7/13 15:57
 */
@RestController
@RequestMapping(value = "/date")
@Slf4j
public class DateParamController {

    /**
     * 日期测试
     */
    @RequestMapping(value = "/param", method = RequestMethod.GET)
    public DateParamVO exportExcel(DateParamVO dateParamVO){

        LocalDateTime startTime = dateParamVO.getStartTime();
        System.out.println(startTime);

        LocalDateTime now = LocalDateTime.now();
        dateParamVO.setEndTime(now);
        return dateParamVO;
    }
}
