package com.hiwan.common;

/**
 * 枚举类用于存储代码和返回的Message
 *
 * @Description: 全局统一返回状态信息枚举类
 * @ClassFullName: com.hiwan.common.ReturnCode
 * @Author: jiangshikun
 * @CreateTime: 2021/2/27
 * -------------------------------------------------------
 * If you can NOT explain it simply, you do NOT understand it well enough
 * -------------------------------------------------------
 **/
public enum ReturnCode {

    /** 操作成功 */
    SUCCESS(200, "操作成功"),
    /** 操作失败 */
    FAIL(400, "操作失败"),


    /* 系统错误：401-999 */
    /** 空指针异常 */
    NULL_POINTER_EXCEPTION(401, "空指针异常"),
    /** 自定义异常之返回值为空 */
    NULL_RESPONSE_EXCEPTION(402, "自定义异常之返回值为空"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),

    /* 用户错误：20001-29999*/
    NOT_LOGGED_IN(20001, "用户未登录"),
    LOGIN_ERROR(20002, "账号不存在或密码错误"),
    ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),

    /* 业务错误：30001-39999 */
    QUESTIONED_NOT_EXIST(30001, "某业务出现问题"),

    /* 系统错误：40001-49999 */
    SYSTEM_ERROR(40001, "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    RESULE_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),

    /* 接口错误：60001-69999 */
    INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    FORBID_VISIT(60003, "该接口禁止访问"),
    ADDRESS_INVALID(60004, "接口地址无效"),
    REQUEST_TIMEOUT(60005, "接口请求超时"),
    EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    NO_ACCESS(70001, "无访问权限");

    private Integer code;
    private String msg;

    ReturnCode() {
    }

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
