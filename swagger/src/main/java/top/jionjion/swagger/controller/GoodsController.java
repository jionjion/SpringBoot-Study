package top.jionjion.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import top.jionjion.swagger.dto.ResponseCode;
import top.jionjion.swagger.dto.ResultDto;
import top.jionjion.swagger.pojo.Goods;

import java.math.BigDecimal;
import java.util.Map;

/**
 *  商品
 * @author Jion
 */
@Api(tags = "商品信息管理接口")
@RestController
@RequestMapping("/goods")
public class GoodsController {

    /** 使用 3.0 版本的 */
    @Operation(summary = "商品详情,针对得到单个商品的信息")
    @GetMapping("/one")
    public ResultDto<Goods> one(@Parameter(description = "商品id,正整数") @RequestParam(value="goodsid",required = false,defaultValue = "0") Integer goodsid) {
        Goods good = new Goods();
        good.setGoodsId(Long.valueOf(goodsid));
        good.setGoodsName("电子书");
        good.setSubject("学python,学ai");
        good.setPrice(new BigDecimal(60));
        good.setStock(10);
        ResultDto<Goods> result = new ResultDto<>();
        return result.success(good);
    }

    /** 使用 2.0 版本的 */
    @ApiOperation(value = "商品详情,通过路径表达式查询")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @GetMapping("/{id}/good")
    public ResultDto<Goods> findById(@Parameter(description = "商品id,正整数") @PathVariable(value="id") Integer goodsid) {
        Goods good = new Goods();
        good.setGoodsId(Long.valueOf(goodsid));
        good.setGoodsName("教程");
        good.setSubject("学习Java");
        good.setPrice(new BigDecimal(80));
        good.setStock(10);
        ResultDto<Goods> result = new ResultDto<>();
        return result.success(good);
    }

    @ApiOperation(value = "提交订单")
    @ApiImplicitParams({
        @ApiImplicitParam(name="userid",value="用户id",dataTypeClass = Long.class, paramType = "form",example="12345"),
        @ApiImplicitParam(name="goodsid",value="商品id",dataTypeClass = Integer.class, paramType = "form",example="12345"),
        @ApiImplicitParam(name="mobile",value="手机号",dataTypeClass = String.class, paramType = "form",example="13866668888"),
        @ApiImplicitParam(name="comment",value="发货备注",dataTypeClass = String.class, paramType = "form",example="请在情人节当天送到")
    })
    @PostMapping("/order")
    public ResultDto<?> order(@ApiIgnore @RequestParam Map<String,String> params) {
        System.out.println(params);
        return ResultDto.success(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
    }
}