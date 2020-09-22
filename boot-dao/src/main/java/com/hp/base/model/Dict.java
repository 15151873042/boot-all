package com.hp.base.model;


public class Dict extends BaseModel {
    
    private static final long serialVersionUID = 1L;

    /**
     * 字典组关键字
     */
    private String groupKey;

    /**
     * 字典组描述
     */
    private String groupName;

    /**
     * 字典关键字
     */
    private String dictKey;

    /**
     * 字典值
     */
    private String dictValue;

    /**
     * 排序字段
     */
    private Integer seqNo;

    /**
     * 获取字典组关键字
     *
     * @return groupKey - 字典组关键字
     */
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * 设置字典组关键字
     *
     * @param groupKey 字典组关键字
     */
    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    /**
     * 获取字典组描述
     *
     * @return groupName - 字典组描述
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置字典组描述
     *
     * @param groupName 字典组描述
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取字典关键字
     *
     * @return dictKey - 字典关键字
     */
    public String getDictKey() {
        return dictKey;
    }

    /**
     * 设置字典关键字
     *
     * @param dictKey 字典关键字
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    /**
     * 获取字典值
     *
     * @return dictValue - 字典值
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * 设置字典值
     *
     * @param dictValue 字典值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * 获取排序字段
     *
     * @return seqNo - 排序字段
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     * 设置排序字段
     *
     * @param seqNo 排序字段
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }
}