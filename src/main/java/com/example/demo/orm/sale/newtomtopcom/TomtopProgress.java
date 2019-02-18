package com.example.demo.orm.sale.newtomtopcom;

/**
 * <p>@Author tangtaiming</p>
 * <p>@Date 2018-12-21</p>
 * <p>@Version 1.0</p>
 **/
/**
 * 状态变化
 * @author tomtop2159
 *
 */
public class TomtopProgress {

    private Long id;

    /**
     * 查询条件 json字符串
     */
    private String query;

    /**
     * 0 待处理，1 处理中，100 处理成功
     */
    private Integer status;

    /**
     * 状态
     */
    private Double progress;

    /**
     * 文件名称
     */
    private String fileName;

    private String createDate;

    private String updateDate;

    private Integer creater;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

}
