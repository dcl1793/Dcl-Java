package hs.dcl.test.controller;

import hs.dcl.test.model.Person;
import hs.dcl.test.util.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/excel")
public class ExceleTestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 导出
     * @param response
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person personVo = new Person();
            personVo.setName("张三" + i);
            personVo.setAge(18);
            personList.add(personVo);
        }
        StringBuffer sheetName = new StringBuffer("员工信息");
        String fileName = new String(sheetName);
        ExcelUtils.exportExcel(personList, "员工信息表", "员工信息", Person.class, fileName, response);
        logger.info("导出excel所花时间：" + (System.currentTimeMillis() - start));
    }

    /**
     * 导入
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        long start = System.currentTimeMillis();
        List<Person> personVoList = ExcelUtils.importExcel(file, 1,1,Person.class);
        logger.debug(personVoList.toString());
        System.out.println(personVoList);
        logger.info("导入excel所花时间：" + (System.currentTimeMillis() - start));
        return ( "导入成功");
    }
}
