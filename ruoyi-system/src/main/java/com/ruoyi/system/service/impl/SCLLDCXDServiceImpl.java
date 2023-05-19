package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SCLLDCXDMapper;
import com.ruoyi.system.domain.SCLLDCXD;
import com.ruoyi.system.service.ISCLLDCXDService;

/**
 * 生产领料单查询DService业务层处理
 *
 * @author ruoyi
 * @date 2023-05-19
 */
@Service
public class SCLLDCXDServiceImpl implements ISCLLDCXDService
{
    @Autowired
    private SCLLDCXDMapper sCLLDCXDMapper;

    /**
     * 查询生产领料单查询D
     *
     * @param name 生产领料单查询D主键
     * @return 生产领料单查询D
     */
    @Override
    public SCLLDCXD selectSCLLDCXDByName(String name)
    {
        return sCLLDCXDMapper.selectSCLLDCXDByName(name);
    }

    /**
     * 查询生产领料单查询D列表
     *
     * @param sCLLDCXD 生产领料单查询D
     * @return 生产领料单查询D
     */
    @Override
    public List<SCLLDCXD> selectSCLLDCXDList(SCLLDCXD sCLLDCXD)
    {
        return sCLLDCXDMapper.selectSCLLDCXDList(sCLLDCXD);
    }

}
