package mapper;

import models.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: zk_product
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-23 13:05
 * @Description: 订单操作类
 */
@Mapper
@Component
public interface ProductMapper {

    //查询商品（目的查询库存）
    @Select("select * from product where id = #{id}")
    Product getProduct(@Param("id") int id);

    //减库存
    @Update("update product set stock = stock-1 where id = #{id}")
    int reduceStock(@Param("id") int id);
}
