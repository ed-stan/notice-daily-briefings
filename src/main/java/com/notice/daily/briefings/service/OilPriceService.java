package com.notice.daily.briefings.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.notice.daily.briefings.entity.OilPrice;

import java.time.LocalDate;
import java.util.List;

/**
 * 油价服务接口
 */
public interface OilPriceService extends IService<OilPrice> {
    
    /**
     * 根据日期和省份查询油价
     * @param date 日期
     * @param province 省份
     * @return 油价列表
     */
    List<OilPrice> getByDateAndProvince(LocalDate date, String province);
    
    /**
     * 根据日期查询油价
     * @param date 日期
     * @return 油价列表
     */
    List<OilPrice> getByDate(LocalDate date);
    
    /**
     * 根据省份查询最新油价
     * @param province 省份
     * @return 油价列表
     */
    List<OilPrice> getLatestByProvince(String province);
    
    /**
     * 根据油品类型查询最新油价
     * @param oilType 油品类型
     * @return 油价列表
     */
    List<OilPrice> getLatestByOilType(String oilType);
    
    /**
     * 保存或更新油价信息
     * @param oilPrice 油价信息
     * @return 是否成功
     */
    boolean saveOrUpdateOilPrice(OilPrice oilPrice);
    
    /**
     * 批量保存油价信息
     * @param oilPrices 油价信息列表
     * @return 是否成功
     */
    boolean batchSaveOilPrices(List<OilPrice> oilPrices);
}
