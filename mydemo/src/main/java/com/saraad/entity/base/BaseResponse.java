package com.saraad.entity.base;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: BaseRespose
 * @Package:com.saraad.entity.base
 * @Description:
 * @author: bin.peng
 * @date: 2018/11/718:20
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */

public class BaseResponse<T> {
    /**
     * 状态码
     */
    private String code;

    /**
     * 信息
     */
    private String message;

    /**
     * 版本
     */
    private String version;

    /**
     * 业务类
     */
    private T result;

    public BaseResponse() {}

    public BaseResponse(String version, String code, String message) {
        this.code = code;
        this.message = message;
        this.version = version;
    }

    public BaseResponse(String version, String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.version = version;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
