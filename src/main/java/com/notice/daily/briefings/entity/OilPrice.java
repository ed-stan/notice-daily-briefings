package com.notice.daily.briefings.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 油价实体类
 * 对应表：ndb_oil_prices
 */
@TableName("ndb_oil_prices")
public class OilPrice {
    
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    /**
     * 油价日期
     */
    @TableField("date")
    private LocalDate date;
    
    /**
     * 省份
     */
    @TableField("province")
    private String province;
    
    /**
     * 油品类型: 92, 95, 98, 0
     */
    @TableField("oil_type")
    private String oilType;
    
    /**
     * 油价
     */
    @TableField("price")
    private BigDecimal price;
    
    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;
    
    // 无参构造函数
    public OilPrice() {}
    
    // 全参构造函数
    public OilPrice(Long id, LocalDate date, String province, String oilType, 
                   BigDecimal price, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.date = date;
        this.province = province;
        this.oilType = oilType;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    
    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public String getProvince() {
        return province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    public String getOilType() {
        return oilType;
    }
    
    public void setOilType(String oilType) {
        this.oilType = oilType;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public String toString() {
        return "OilPrice{" +
                "id=" + id +
                ", date=" + date +
                ", province='" + province + '\'' +
                ", oilType='" + oilType + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
