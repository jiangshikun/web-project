package com.hiwan.common;

/**
 * Java返回结果封装，SpringBoot返回结果封装
 * 定义http请求返回的最外层对象，封装返回数据的统一格式
 * @Description: 当后面需要返回json结果给前端时，往往要写很多代码，不利于代码重用，
 * 所以封装一个返回结果的bean，直接调用，这样方便简洁、高效率、代码统一美观。
 * @ClassFullName: com.hiwan.common.Result
 * @Author: jiangshikun
 * @CreateTime: 2021/2/27
 * -------------------------------------------------------
 * If you can NOT explain it simply, you do NOT understand it well enough
 * -------------------------------------------------------
 **/
public class Result<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private  T data;

    public <T>Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /**封装返回结果类型 **/
    /**
     * 操作成功，无数据返回给前端
     * @return Result
     */
    public static <T> Result ok() {
        return new Result(new Result<>(ReturnCode.SUCCESS.getCode(),ReturnCode.SUCCESS.getMsg()));
    }

    /**
     * 操作成功，有数据返回给前端
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result ok(T data) {
        return new Result(ReturnCode.SUCCESS.getCode(),ReturnCode.SUCCESS.getMsg(),data);
    }

    /**
     * 操作失败，无数据返回给前端
     * @param <T>
     * @return
     */
    public static <T> Result fail() {
        return new Result<>(ReturnCode.FAIL.getCode(),ReturnCode.FAIL.getMsg());
    }

    /**
     * 操作失败，有数据返回给前端
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result fail(T data) {
        Result result = new Result();
        result.setCode(ReturnCode.FAIL.getCode());
        result.setMsg(ReturnCode.FAIL.getMsg());
        result.setData(data);
        return new Result(ReturnCode.FAIL.getCode(),ReturnCode.FAIL.getMsg(),data);
    }

    /**
     * 操作成功，无数据返回给前端
     * @return Result
     */
    public static <T> Result other(Integer code, String msg) {
        return new Result<>(code, msg);
    }

    /**
     * 操作成功，有数据返回给前端
     * @param data
     * @param <T>
     * @return
     */
    public static <T>Result other(Integer code, String msg, T data){
        return new Result(code, msg,data);
    }

}
