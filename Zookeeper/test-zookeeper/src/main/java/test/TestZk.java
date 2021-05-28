package test;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author: Ken
 * @Date: 2021/5/28 22:17
 */
public class TestZk {
    // 集群ip
    private String connStr = "192.168.233.148:2181,192.168.233.149:2181,192.168.233.150:2181";
    /*session超时 60秒：一定不能太少，因为连接zookeeper和加载集群环境会因为性能原因延迟略高
    如果时间太少，还没有创建好客户端，就开始操作节点，会报错的 */
    private int sessionTimeout = 60000;

    private ZooKeeper zkCilent;

    @Before
    public void init() throws IOException {
        // 创建监听器
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("得到监听反馈，在进行业务处理代码！");
                System.out.println(watchedEvent.getType());
            }
        };
        // 创建zookeeper客户端
        zkCilent = new ZooKeeper(connStr, sessionTimeout, watcher);
    }

    @Test
    public void createNode() throws Exception {
        String nodeCreated = zkCilent.create("/lagou", "liyuangang".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // 参数1：要创建的节点的路径
        // 参数2：节点数据
        // 参数3：节点权限
        // 参数4：节点的类型
        System.out.println("nodeCreated = " + nodeCreated);
    }

    @Test
    public void find() throws Exception {
        byte[] bs = zkCilent.getData("/lagou", false, new Stat());
        // 路径不存在时会报错
        String data = new String(bs);
        System.out.println("查询到数据：" + data);
    }

    @Test
    public void update() throws Exception {
        Stat stat = zkCilent.setData("/lagou", "ken".getBytes(), 0);
        //先查看节点详 情，获得dataVersion = 0
        System.out.println(stat);
    }

    @Test
    public void delete() throws Exception {
        zkCilent.delete("/lagou", 1);
        // 先查看节点详情，获得dataVersion = 1
        System.out.println("删除成功！");
    }

    @Test
    public void getChildren() throws Exception {
        List<String> children = zkCilent.getChildren("/", false);
        // false:不监听
        for (String child : children) {
            System.out.println(child);
        }
    }

    @Test
    public void watchNode() throws Exception {
        List<String> list = zkCilent.getChildren("/", true);
        // false:不监听
        for (String child : list) {
            System.out.println(child);
        }
        System.in.read();
    }

    @Test
    public void exist() throws Exception {
        Stat stat = zkCilent.exists("/lagou", false);
        System.out.println(stat == null ? "不存在" : "存在");
    }
}
