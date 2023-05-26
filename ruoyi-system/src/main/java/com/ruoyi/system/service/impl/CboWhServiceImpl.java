package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CboWhMapper;
import com.ruoyi.system.domain.CboWh;
import com.ruoyi.system.service.ICboWhService;

/**
 * 存储地点查询Service业务层处理
 *
 * @author ruoyi
 * @date 2023-05-26
 */
@Service
public class CboWhServiceImpl implements ICboWhService
{
    @Autowired
    private CboWhMapper cboWhMapper;

    /**
     * 查询存储地点查询
     *
     * @param id 存储地点查询主键
     * @return 存储地点查询
     */
    @Override
    public CboWh selectCboWhById(Long id)
    {
        return cboWhMapper.selectCboWhById(id);
    }

    /**
     * 查询存储地点查询列表
     *
     * @param cboWh 存储地点查询
     * @return 存储地点查询
     */
    @Override
    public List<CboWh> selectCboWhList(CboWh cboWh)
    {
        return cboWhMapper.selectCboWhList(cboWh);
    }

    /**
     * 新增存储地点查询
     *
     * @param cboWh 存储地点查询
     * @return 结果
     */
    @Override
    public int insertCboWh(CboWh cboWh)
    {
        return cboWhMapper.insertCboWh(cboWh);
    }

    /**
     * 修改存储地点查询
     *
     * @param cboWh 存储地点查询
     * @return 结果
     */
    @Override
    public int updateCboWh(CboWh cboWh)
    {
        return cboWhMapper.updateCboWh(cboWh);
    }

    /**
     * 批量删除存储地点查询
     *
     * @param ids 需要删除的存储地点查询主键
     * @return 结果
     */
    @Override
    public int deleteCboWhByIds(Long[] ids)
    {
        return cboWhMapper.deleteCboWhByIds(ids);
    }

    /**
     * 删除存储地点查询信息
     *
     * @param id 存储地点查询主键
     * @return 结果
     */
    @Override
    public int deleteCboWhById(Long id)
    {
        return cboWhMapper.deleteCboWhById(id);
    }
}
