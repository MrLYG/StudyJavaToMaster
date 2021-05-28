package meituan;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: test-zookeeper
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-22 15:32
 * @Description: 客户消费者
 */
public class Customers {

    private String connectString = "192.168.233.148:2181,192.168.233.149:2181,192.168.233.150:2181";
    private int sessionTimeout = 60 * 1000;

    private ZooKeeper zkClient;

    //创建客户端，连接到zookeeper
    public void connect() throws Exception {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    // 再次获取商家列表
                    getShopList();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    //获取子节点列表（获取商家列表）
    private void getShopList() throws Exception {
        //1.获取服务器的子节点信息，并且对父节点进行监听
        List<String> shops = zkClient.getChildren("/meituan", true);
        //2.声明存储服务器信息的集合
        List<String> shopList = new ArrayList<String>();
//        System.out.println(shops);
//        for(String shop : shops){
//            byte[] bytes = zkClient.getData("/meituan/" + shop, false, new Stat());
//            shopList.add(bytes.toString());
//        }

        System.out.println( "目前正在营业的商家："+shops );
    }

    public static void main(String[] args) throws Exception {
        Customers client = new Customers();
        // 1.获得zookeeper的连接 （用户打开美团APP）
        client.connect();
        // 2.获取meituan下的所有子节点列表（获取商家列表）
        client.getShopList();
        // 3.业务逻辑处理（对比商家，下单点餐）
        client.business();
    }

    private void business() throws Exception {
        System.out.println("用户正在浏览商家。。。");
        System.in.read();
    }


}
