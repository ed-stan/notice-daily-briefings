package com.notice.daily.briefings.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.notice.daily.briefings.entity.OilPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * 油价数据访问层
 */
@Mapper
public interface OilPriceMapper extends BaseMapper<OilPrice> {
    
    /**
     * 根据日期和省份查询油价
     * @param date 日期
     * @param province 省份
     * @return 油价列表
     */
    @Select("SELECT * FROM ndb_oil_prices WHERE date = #{date} AND province = #{province}")
    List<OilPrice> selectByDateAndProvince(@Param("date") LocalDate date, @Param("province") String province);
    
    /**
     * 根据日期查询油价
     * @param date 日期
     * @return 油价列表
     */
    @Select("SELECT * FROM ndb_oil_prices WHERE date = #{date}")
    List<OilPrice> selectByDate(@Param("date") LocalDate date);
    
    /**
     * 根据省份查询最新油价
     * @param province 省份
     * @return 油价列表
     */
    @Select("SELECT * FROM ndb_oil_prices WHERE province = #{province} ORDER BY date DESC LIMIT 10")
    List<OilPrice> selectLatestByProvince(@Param("province") String province);
    
    /**
     * 根据油品类型查询最新油价
     * @param oilType 油品类型
     * @return 油价列表
     */
    @Select("SELECT * FROM ndb_oil_prices WHERE oil_type = #{oilType} ORDER BY date DESC LIMIT 20")
    List<OilPrice> selectLatestByOilType(@Param("oilType") String oilType);
}
