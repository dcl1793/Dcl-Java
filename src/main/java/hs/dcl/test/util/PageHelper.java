package hs.dcl.test.util;

import java.io.Serializable;

public class PageHelper implements Serializable {


    private Integer page = 1;

    private Integer rows = 10;

    private Integer totalCount;

    private Integer totalPage = 1;

    private Object dataInfo;

    public PageHelper(Integer page, Integer rows) {
        if (page > 0 && rows > 0) {
            this.page = page;
            this.rows = rows;
        }
    }

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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalCount % rows > 0 ? totalCount / rows + 1 : totalCount / rows;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Object getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(Object dataInfo) {
        this.dataInfo = dataInfo;
    }
}
