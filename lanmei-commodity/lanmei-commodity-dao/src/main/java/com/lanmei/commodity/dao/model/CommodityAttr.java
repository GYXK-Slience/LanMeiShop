package com.lanmei.commodity.dao.model;

public class CommodityAttr {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity_attr.attr_id
     *
     * @mbggenerated
     */
    private Integer attrId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity_attr.commodity_id
     *
     * @mbggenerated
     */
    private Integer commodityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity_attr.category
     *
     * @mbggenerated
     */
    private String category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity_attr.attr_name
     *
     * @mbggenerated
     */
    private String attrName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity_attr.attr_val
     *
     * @mbggenerated
     */
    private String attrVal;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity_attr.attr_id
     *
     * @return the value of commodity_attr.attr_id
     *
     * @mbggenerated
     */
    public Integer getAttrId() {
        return attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity_attr.attr_id
     *
     * @param attrId the value for commodity_attr.attr_id
     *
     * @mbggenerated
     */
    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity_attr.commodity_id
     *
     * @return the value of commodity_attr.commodity_id
     *
     * @mbggenerated
     */
    public Integer getCommodityId() {
        return commodityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity_attr.commodity_id
     *
     * @param commodityId the value for commodity_attr.commodity_id
     *
     * @mbggenerated
     */
    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity_attr.category
     *
     * @return the value of commodity_attr.category
     *
     * @mbggenerated
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity_attr.category
     *
     * @param category the value for commodity_attr.category
     *
     * @mbggenerated
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity_attr.attr_name
     *
     * @return the value of commodity_attr.attr_name
     *
     * @mbggenerated
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity_attr.attr_name
     *
     * @param attrName the value for commodity_attr.attr_name
     *
     * @mbggenerated
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity_attr.attr_val
     *
     * @return the value of commodity_attr.attr_val
     *
     * @mbggenerated
     */
    public String getAttrVal() {
        return attrVal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity_attr.attr_val
     *
     * @param attrVal the value for commodity_attr.attr_val
     *
     * @mbggenerated
     */
    public void setAttrVal(String attrVal) {
        this.attrVal = attrVal;
    }
}