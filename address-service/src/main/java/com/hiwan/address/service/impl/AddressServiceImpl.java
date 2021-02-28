package com.hiwan.address.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hiwan.address.dao.AddressMapper;
import com.hiwan.address.entity.Address;
import com.hiwan.address.entity.AddressExample;
import com.hiwan.address.service.AddressService;
import com.hiwan.common.GlobalSystemConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地址信息service 接口实现类
 *
 * @Description: 接口实现类
 * @ClassName:AddressServiceImpl
 * @Author: jiangshikun
 * @CreateTime: 2021/2/28
 * -------------------------------------------------------
 * If you can NOT explain it simply, you do NOT understand it well enough
 * -------------------------------------------------------
 **/
@Slf4j
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;


    @Override
    public List<Address> queryByParentId(Address address) {
        log.info("queryByParentId is start , " + address);
        AddressExample example = new AddressExample();
        AddressExample.Criteria criteria = example.createCriteria();
        if(address != null && StringUtils.isNoneEmpty(address.getParentCode())){
            criteria.andParentCodeEqualTo(address.getParentCode());
        }
        return addressMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Address> queryAddressPage(Integer pageNum, Integer pageSize, Address address) {
        log.info("queryAddressPage is start, pageNum=" + pageNum + ", pageSize =" + pageSize + address);
        PageHelper.startPage(pageNum == null || pageNum <=0 ? GlobalSystemConstant.DEFAULT_CURRENT_PAGE : pageNum,
                pageSize == null || pageSize <= 0 ? GlobalSystemConstant.DEFAULT_PAGE_SIZE : pageSize);
        AddressExample example = new AddressExample();
        AddressExample.Criteria criteria = example.createCriteria();
        if(address != null && StringUtils.isNotEmpty(address.getParentCode())){
            criteria.andParentCodeEqualTo(address.getParentCode());
        }
        return new PageInfo<Address>(addressMapper.selectByExample(example));
    }
}
