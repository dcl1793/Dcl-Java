package hs.dcl.test.common;

import lombok.Data;
import lombok.ToString;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;

/**
 * 封装返回结果集
 *
 * @author dacl30868
 * @date 2020/6/19 13:31
 */
@Data
@ToString
public class ResultBody implements Serializable {

    private static final long serialVersionUID = -4896595993756406429L;
    private Long time;
    private Object data;
    private Integer code;
    private String message;

    public static ResultBody success(Object data) {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(200);
        resultBody.setMessage("success");
        resultBody.setTime(System.currentTimeMillis());
        resultBody.setData(data);
        return resultBody;
    }

    /**
     * 返回的data数据最好不是null，返回空串。
     * @return
     */
    public static ResultBody success() {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(200);
        resultBody.setMessage("success");
        resultBody.setTime(System.currentTimeMillis());
        resultBody.setData("");
        return resultBody;
    }

    /**
     * @param commonEnum 成功提示
     * @param msg       具体成功提示
     */
    public static ResultBody success(CommonEnum commonEnum, String msg) {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(commonEnum.code());
        resultBody.setMessage(commonEnum.msg() + " : " + msg);
        resultBody.setData("");
        resultBody.setTime(System.currentTimeMillis());
        return resultBody;
    }

    /**
     * @param commonEnum 失败原因
     * @param msg       具体失败原因 最好提示用户如何改正
     */
    public static ResultBody failed(CommonEnum commonEnum, String msg) {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(commonEnum.code());
        resultBody.setMessage(commonEnum.msg() + " : " + msg);
        resultBody.setData("");
        resultBody.setTime(System.currentTimeMillis());
        return resultBody;
    }
}