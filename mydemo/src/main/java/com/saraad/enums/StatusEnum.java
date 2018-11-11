package com.saraad.enums;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: StatusEnum
 * @Package:com.saraad.enums
 * @Description:
 * @author: saraad
 * @date: 2018/11/8 7:59
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public enum StatusEnum {

    STATUS_100("100","成功"),STATUS_101("101","失败"),STATUS_102("102","参数不合法");

    private String code;

    private String messsage;

    StatusEnum(String code, String messsage) {
        this.code = code;
        this.messsage = messsage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
