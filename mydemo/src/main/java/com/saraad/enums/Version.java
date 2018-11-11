package com.saraad.enums;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: Version
 * @Package:com.saraad.enums
 * @Description:
 * @author: saraad
 * @date: 2018/11/8 7:55
 * @Copyright: 2018  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public enum Version {
    VERSION_1("1","version_1");

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    Version() {
    }

    Version(String code, String name) {
        this.name = name;
        this.code = code;
    }
}
