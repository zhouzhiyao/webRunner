package com.chinaweal.webrun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by admin on 2016/8/6.
 */
@Entity
@Table(name = "TestCase")
public class TestCase implements java.io.Serializable {
    private String id;
    private String pageIndex;           //ҳ���Ψһ�Ա�ʶ
    private int inputOrder;        //ҳ����Ԫ�ز���˳��
    private String tagName;         //tagԪ�ص�����
    private String attributeType;        //���ڶ�λԪ�ص�����
    private String attributeValue;        //���ڶ�λԪ�ص�����
    private String inputValue;       //��������
    private String caseType;        //�������ͣ� 0 ·��������Ϣ��1 ҵ����Ϣ
    private String displayName;

    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Column(name = "PageIndex", length = 100)
    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Column(name = "InputOrder")
    public int getInputOrder() {
        return inputOrder;
    }

    public void setInputOrder(int inputOrder) {
        this.inputOrder = inputOrder;
    }

    @Column(name = "TagName", length = 10)
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Column(name = "AttributeType", length = 10)
    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    @Column(name = "AttributeValue", length = 200)
    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Column(name = "InputValue", length = 1000)
    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    @Column(name = "CaseType", length = 1)
    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    @Column(name = "DisplayName", length = 100)
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
