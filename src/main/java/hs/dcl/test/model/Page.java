package hs.dcl.test.model;

import java.io.Serializable;

/**
 * @author dacl30868
 * @date 2020/6/18 9:52
 */
public class Page implements Serializable {

    /**
     * 当前页
     */
    private Integer page = 1;

    /**
     * 每页显示数
     */
    private Integer rows = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
