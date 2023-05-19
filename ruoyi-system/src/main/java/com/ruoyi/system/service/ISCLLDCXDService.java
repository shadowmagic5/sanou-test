package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SCLLDCXD;

/**
 * 生产领料单查询DService接口
 *
 * @author ruoyi
 * @date 2023-05-19
 */
public interface ISCLLDCXDService
{
    /**
     * 查询生产领料单查询D
     *
     * @param name 生产领料单查询D主键
     * @return 生产领料单查询D
     */
    public SCLLDCXD selectSCLLDCXDByName(String name);

    /**
     * 查询生产领料单查询D列表
     *
     * @param sCLLDCXD 生产领料单查询D
     * @return 生产领料单查询D集合
     */
    public List<SCLLDCXD> selectSCLLDCXDList(SCLLDCXD sCLLDCXD);

}
