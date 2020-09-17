package hs.dcl.test.controller;

import hs.dcl.test.model.dto.Validate7DTO;
import hs.dcl.test.model.req.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author dacl30868
 * @description: 入参校验测试
 * @date 2020/7/16 10:09
 */
@Slf4j
@RestController
@RequestMapping(value = "/validated")
public class ValidatedController {

    /**
     * 什么是Validator
     * Spring Validation验证框架对参数的验证机制提供了@Validated（Spring's JSR-303规范，是标准JSR-303的一个变种），
     * javax提供了@Valid（标准JSR-303规范），配合BindingResult可以直接提供参数验证结果。
     *
     * @Validated是@Valid的一次封装，不是规范。
     *
     * 在检验Controller的入参是否符合规范时，使用@Validated或者@Valid在基本验证功能上没有太多区别。
     * 但是在分组、注解地方、嵌套验证等功能上两个有所不同：
     *
     * 分组：
     * @Validated：提供了一个分组功能，可以在入参验证时，根据不同的分组采用不同的验证机制
     *
     * @Valid：作为标准JSR-303规范，还没有吸收分组的功能。

     */
    /**
     * 限制	说明
     * @Null 限制只能为null
     * @NotNull 限制必须不为null
     * @AssertFalse 限制必须为false
     * @AssertTrue 限制必须为true
     * @DecimalMax(value) 限制必须为一个不大于指定值的数字
     * @DecimalMin(value) 限制必须为一个不小于指定值的数字
     * @Digits(integer,fraction) 限制必须为一个小数，且整数部分的位数不能超过integer，小数部分的位数不能超过fraction
     * @Future 限制必须是一个将来的日期
     * @Max(value) 限制必须为一个不大于指定值的数字
     * @Min(value) 限制必须为一个不小于指定值的数字
     * @Past 限制必须是一个过去的日期
     * @Pattern(value) 限制必须符合指定的正则表达式
     * @Size(max,min) 限制字符长度必须在min到max之间
     * @Past 验证注解的元素值（日期类型）比当前时间早
     * @NotEmpty 验证注解的元素值不为null且不为空（字符串长度不为0、集合大小不为0）(可以是空格)
     * @NotBlank 验证注解的元素值不为空（不为null、去除首位空格后长度为0），(不能是空格)
     * 不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格
     * @Email 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
     */
    /**
     * 注解地方：
     *
     * @Validated：可以用在类、方法和方法参数上。
     * @Valid：可以用在方法、构造函数、方法参数和成员属性（字段）上
     * 嵌套验证：
     * 嵌套验证就是类嵌套类的验证，
     * 比如我要在集合上加一个@notnull的注解，要求该集合中的每一个对象都被验证，
     * 如果只用@Validated与@Valid是不会验证的。我们要用@Validated配合@Valid来进行验证。
     */

    /**
     * 对象/DTO对象校验
     * @param
     */
    @RequestMapping(value = "/validate1", method = RequestMethod.GET)
    public void validate1(@Validated ValidatedREQ validatedREQ){

        String name = validatedREQ.getName();
        String remarks = validatedREQ.getEmail();
        System.out.println(name);
        System.out.println(remarks);
    }

    /**
     * 方法参数校验
     */
    @RequestMapping(value = "/validate2", method = RequestMethod.GET)
    public String validate2(
            @Size(min = 1,max = 10,message = "姓名长度必须为1到10")@RequestParam("name") String name,
            @Min(value = 10,message = "年龄最小为10")@Max(value = 100,message = "年龄最大为100") @RequestParam("age") Integer age) {
        System.out.println(name);
        System.out.println(age);
        return "validTest2";
    }

    /**
     * 嵌套校验
     */
    @RequestMapping(value = "/validate3", method = RequestMethod.POST)
    public void validate3(@RequestBody @Validated ItemREQ itemREQ ) {

        List<PropREQ> props = itemREQ.getProps();
        props.forEach(item -> System.out.println(item.getPid()+""+item.getPidName()));
    }

    /**
     * 使用Defaul分组进行验证
     * @param resume
     * @return
     */
    @PostMapping("/validate4")
    public String validate4(@Validated(value = ResumeREQ.Default.class) @RequestBody ResumeREQ resume) {
        return "validate4";
    }

    /**
     * 使用Default、Update分组进行验证
     * @param resume
     * @return
     */
    @PutMapping("/validate5")
    public String validate5(@Validated(value = {ResumeREQ.Update.class, ResumeREQ.Default.class}) @RequestBody ResumeREQ resume) {
        return "validate5";
    }

    /**
     * 自定义校验
     */
    @RequestMapping(value = "/validate6", method = RequestMethod.GET)
    public void validate6(@Validated FlagValidat FlagValidat ) {
        FlagValidat.getFlag();
    }

    /**
     * 自定义校验
     */
    @RequestMapping(value = "/validate7", method = RequestMethod.POST)
    public void validate7(@Validated @RequestBody Validate7REQ validate7REQ ) {

        String grantPrice = validate7REQ.getGrantPrice();
        String times = validate7REQ.getTimes();
        String totalNum = validate7REQ.getTotalNum();
        String totalPerson = validate7REQ.getTotalPerson();

        Validate7DTO validate7DTO = new Validate7DTO();
        validate7DTO.setGrantPrice(new BigDecimal(grantPrice));
        validate7DTO.setTotalNum(new BigDecimal(totalNum));
        validate7DTO.setTimes(Integer.valueOf(times).intValue());
        validate7DTO.setTotalPerson(Integer.valueOf(totalPerson).intValue());

        System.out.println(validate7DTO);
    }
}
