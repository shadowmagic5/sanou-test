package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CboWh;

/**
 * 存储地点查询Mapper接口
 *
 * @author ruoyi
 * @date 2023-05-26
 */
public interface CboWhMapper
{
    /**
     * 查询存储地点查询
     *
     * @param id 存储地点查询主键
     * @return 存储地点查询
     */
    public CboWh selectCboWhById(Long id);

    /**
     * 查询存储地点查询列表
     *
     * @param cboWh 存储地点查询
     * @return 存储地点查询集合
     */
    public List<CboWh> selectCboWhList(CboWh cboWh);

    /**
     * 新增存储地点查询
     *
     * @param cboWh 存储地点查询
     * @return 结果
     */
    public int insertCboWh(CboWh cboWh);

    /**
     * 修改存储地点查询
     *
     * @param cboWh 存储地点查询
     * @return 结果
     */
    public int updateCboWh(CboWh cboWh);

    /**
     * 删除存储地点查询
     *
     * @param id 存储地点查询主键
     * @return 结果
     */
    public int deleteCboWhById(Long id);

    /**
     * 批量删除存储地点查询
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCboWhByIds(Long[] ids);
}
