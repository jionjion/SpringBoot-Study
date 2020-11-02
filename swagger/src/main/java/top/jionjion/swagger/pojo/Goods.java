package top.jionjion.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author Jion
 */
@ApiModel("商品模型")
public class Goods {
    /** 商品id */
    @ApiModelProperty("商品id")
    Long goodsId;

    /** 商品名称 */
    @ApiModelProperty("商品名称")
    private String goodsName;

    /** 商品标题 */
    @ApiModelProperty("商品标题")
    private String subject;

    /** 商品价格 */
    @ApiModelProperty("商品价格")
    private BigDecimal price;

    /** 库存 */
    @ApiModelProperty("商品库存")
    int stock;

    public Long getGoodsId() {
        return this.goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return this.goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSubject() {
        return this.subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public BigDecimal getPrice() {
        return this.price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}