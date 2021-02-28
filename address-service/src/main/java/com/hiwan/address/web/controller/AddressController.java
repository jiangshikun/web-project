package com.hiwan.address.web.controller;

import com.github.pagehelper.PageInfo;
import com.hiwan.address.entity.Address;
import com.hiwan.address.service.AddressService;
import com.hiwan.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller类
 *
 * @Description: 地址信息控制器类
 * @ClassName:AddressController
 * @Author: jiangshikun
 * @CreateTime: 2021/2/28
 * -------------------------------------------------------
 * If you can NOT explain it simply, you do NOT understand it well enough
 * -------------------------------------------------------
 **/
@Slf4j
@RestController
//@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 根据上一级地址编码查询地址信息
     * http://localhost:8080/address/findByParentId?parentCode=0
     * @param address 查询条件
     * @return
     */
    @RequestMapping("findByParentId")
    public Result getAddresByparentId(Address address){
        log.info("getAddresByparentId is start , " + address);
        if(address == null || address.getParentCode() == null){
            return Result.fail();
        }
        try {
            List<Address> addresses = addressService.queryByParentId(address);
            return  Result.ok(addresses);
        }catch (Exception ex){
            log.error("findByParentId is error ," +  ex.getStackTrace());
            return  Result.fail();
        }
    }

    /**
     * 分页查询地址信息
     * http://localhost:8080/address/findPges?parentCode=0&pageNum=1&pageSize=10
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @param address 查询条件
     * @return
     */
    @RequestMapping("findPges")
    public Result getAddresPage(Integer pageNum,Integer pageSize, Address address) {
        log.info("getAddresByparentId is start , pageNum = " + pageNum + ",pageSize =" + pageNum + ", " + address);
        if(address == null || address.getParentCode() == null){
            return Result.fail();
        }
        try{
            PageInfo<Address> addressPageInfo = addressService.queryAddressPage(pageNum,pageSize,address);
            return Result.ok(addressPageInfo);
        }catch (Exception ex){
            log.error("findPges is error ," +  ex.getStackTrace());
            return  Result.fail();
        }
    }
}
