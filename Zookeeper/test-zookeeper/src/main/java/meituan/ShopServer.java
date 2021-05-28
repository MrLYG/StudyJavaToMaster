package meituan;

import org.apache.zookeeper.*;

/**
 * @BelongsProject: test-zookeeper
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-22 15:21
 * @Description: 商家服务类
 */
public class ShopServer {

    private String connectString = "192.168.204.141:2181,192.168.204.142:2181,192.168.204.143:2181";
    private int sessionTimeout = 60 * 1000;

    private ZooKeeper zkClient;

    //创建客户端，连接到zookeeper
    public void conntect() throws  Exception{
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    //注册到zookeeper
    public void register( String shopName )throws  Exception{
        //一定要创建EPHEMERAL_SEQUENTIAL 临时有序的节点（营业）
        // 一来可以自动编号，而来断开时，节点自动删除（打样）
        String s = zkClient.create("/meituan/shop", shopName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("【"+shopName+"】开始营业了！"+ s);
    }

    public static void main(String[] args) throws  Exception{
        //1.我要开一个饭店
        ShopServer shop = new ShopServer();

        //2. 连接zookeeper集群（和美团取得联系）
        shop.conntect();

        //3.将服务节点注册到zookeeper（入住美团）
        shop.register(args[0]);

        //4.业务逻辑处理（做生意）
        shop.business(args[0]);
    }

    //做买卖
    private void business(String shopName) throws  Exception{
        System.out.println("【"+shopName+"】正在火爆营业中！");
        System.in.read();
    }
}
