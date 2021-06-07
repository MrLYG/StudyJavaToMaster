package service;

/**
 * @BelongsProject: dubbo-consumer
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-23 18:10
 * @Description: 服务方接口（声明而已，具体实现会远程调用dubbo-server的service实现类）
 */
public interface HelloService {

    String sayHello( String name );
    String sayNo();
}
