package com.hiwan.address.service;

import com.github.pagehelper.PageInfo;
import com.hiwan.address.entity.Address;

import java.util.List;

/**
 * 地址信息service接口类
 * @Description: 系统基础信息类，不对外提供变更操作。
 * @ClassName:AddressService
 * @Author: jiangshikun
 * @CreateTime: 2021/2/28
 * -------------------------------------------------------
 * If you can NOT explain it simply, you do NOT understand it well enough
 * -------------------------------------------------------
 **/
public interface AddressService {

    /**
     * 根据查询条件查询指定的地址信息
     * @param address 查询条件
     * @return
     */
    public List<Address> queryByParentId(Address address);

    /**
     * 根据查询条件分页查询指定的地址信息
     * @param pageNum
     * @param pageSize
     * @param address
     * @return
     */
    PageInfo<Address> queryAddressPage(Integer pageNum, Integer pageSize, Address address);
}
