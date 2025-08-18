package com.notice.daily.briefings.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.notice.daily.briefings.entity.OilPrice;
import com.notice.daily.briefings.mapper.OilPriceMapper;
import com.notice.daily.briefings.service.OilPriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 油价服务实现类
 */
@Service
public class OilPriceServiceImpl extends ServiceImpl<OilPriceMapper, OilPrice> implements OilPriceService {
    
    @Override
    public List<OilPrice> getByDateAndProvince(LocalDate date, String province) {
        return baseMapper.selectByDateAndProvince(date, province);
    }
    
    @Override
    public List<OilPrice> getByDate(LocalDate date) {
        return baseMapper.selectByDate(date);
    }
    
    @Override
    public List<OilPrice> getLatestByProvince(String province) {
        return baseMapper.selectLatestByProvince(province);
    }
    
    @Override
    public List<OilPrice> getLatestByOilType(String oilType) {
        return baseMapper.selectLatestByOilType(oilType);
    }
    
    @Override
    @Transactional
    public boolean saveOrUpdateOilPrice(OilPrice oilPrice) {
        try {
            if (oilPrice.getId() == null) {
                // 新增时设置创建时间
                oilPrice.setCreateTime(LocalDateTime.now());
                oilPrice.setUpdateTime(LocalDateTime.now());
                return save(oilPrice);
            } else {
                // 更新时设置更新时间
                oilPrice.setUpdateTime(LocalDateTime.now());
                return updateById(oilPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    @Transactional
    public boolean batchSaveOilPrices(List<OilPrice> oilPrices) {
        try {
            LocalDateTime now = LocalDateTime.now();
            for (OilPrice oilPrice : oilPrices) {
                if (oilPrice.getCreateTime() == null) {
                    oilPrice.setCreateTime(now);
                }
                if (oilPrice.getUpdateTime() == null) {
                    oilPrice.setUpdateTime(now);
                }
            }
            return saveBatch(oilPrices);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
