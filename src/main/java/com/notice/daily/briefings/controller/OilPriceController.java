package com.notice.daily.briefings.controller;

import com.notice.daily.briefings.entity.OilPrice;
import com.notice.daily.briefings.service.OilPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 油价控制器
 */
@RestController
@RequestMapping("/api/oil-prices")
@CrossOrigin(origins = "*")
public class OilPriceController {
    
    @Autowired
    private OilPriceService oilPriceService;
    
    /**
     * 查询所有油价信息
     * @return 油价列表
     */
    @GetMapping("/list")
    public ResponseEntity<List<OilPrice>> getAllOilPrices() {
        List<OilPrice> oilPrices = oilPriceService.list();
        return ResponseEntity.ok(oilPrices);
    }
    
    /**
     * 根据ID查询油价信息
     * @param id 主键ID
     * @return 油价信息
     */
    @GetMapping("/{id}")
    public ResponseEntity<OilPrice> getOilPriceById(@PathVariable Long id) {
        OilPrice oilPrice = oilPriceService.getById(id);
        if (oilPrice != null) {
            return ResponseEntity.ok(oilPrice);
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * 根据日期查询油价
     * @param date 日期
     * @return 油价列表
     */
    @GetMapping("/date/{date}")
    public ResponseEntity<List<OilPrice>> getOilPricesByDate(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        List<OilPrice> oilPrices = oilPriceService.getByDate(date);
        return ResponseEntity.ok(oilPrices);
    }
    
    /**
     * 根据日期和省份查询油价
     * @param date 日期
     * @param province 省份
     * @return 油价列表
     */
    @GetMapping("/date/{date}/province/{province}")
    public ResponseEntity<List<OilPrice>> getOilPricesByDateAndProvince(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            @PathVariable String province) {
        List<OilPrice> oilPrices = oilPriceService.getByDateAndProvince(date, province);
        return ResponseEntity.ok(oilPrices);
    }
    
    /**
     * 根据省份查询最新油价
     * @param province 省份
     * @return 油价列表
     */
    @GetMapping("/province/{province}/latest")
    public ResponseEntity<List<OilPrice>> getLatestOilPricesByProvince(@PathVariable String province) {
        List<OilPrice> oilPrices = oilPriceService.getLatestByProvince(province);
        return ResponseEntity.ok(oilPrices);
    }
    
    /**
     * 根据油品类型查询最新油价
     * @param oilType 油品类型
     * @return 油价列表
     */
    @GetMapping("/oil-type/{oilType}/latest")
    public ResponseEntity<List<OilPrice>> getLatestOilPricesByOilType(@PathVariable String oilType) {
        List<OilPrice> oilPrices = oilPriceService.getLatestByOilType(oilType);
        return ResponseEntity.ok(oilPrices);
    }
    
    /**
     * 新增油价信息
     * @param oilPrice 油价信息
     * @return 操作结果
     */
    @PostMapping("/add")
    public ResponseEntity<String> addOilPrice(@RequestBody OilPrice oilPrice) {
        boolean success = oilPriceService.saveOrUpdateOilPrice(oilPrice);
        if (success) {
            return ResponseEntity.ok("油价信息添加成功");
        }
        return ResponseEntity.badRequest().body("油价信息添加失败");
    }
    
    /**
     * 更新油价信息
     * @param id 主键ID
     * @param oilPrice 油价信息
     * @return 操作结果
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOilPrice(@PathVariable Long id, @RequestBody OilPrice oilPrice) {
        oilPrice.setId(id);
        boolean success = oilPriceService.saveOrUpdateOilPrice(oilPrice);
        if (success) {
            return ResponseEntity.ok("油价信息更新成功");
        }
        return ResponseEntity.badRequest().body("油价信息更新失败");
    }
    
    /**
     * 删除油价信息
     * @param id 主键ID
     * @return 操作结果
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOilPrice(@PathVariable Long id) {
        boolean success = oilPriceService.removeById(id);
        if (success) {
            return ResponseEntity.ok("油价信息删除成功");
        }
        return ResponseEntity.badRequest().body("油价信息删除失败");
    }
    
    /**
     * 批量添加油价信息
     * @param oilPrices 油价信息列表
     * @return 操作结果
     */
    @PostMapping("/batch-add")
    public ResponseEntity<String> batchAddOilPrices(@RequestBody List<OilPrice> oilPrices) {
        boolean success = oilPriceService.batchSaveOilPrices(oilPrices);
        if (success) {
            return ResponseEntity.ok("批量添加油价信息成功");
        }
        return ResponseEntity.badRequest().body("批量添加油价信息失败");
    }
}
