import work.www.lagou.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.*;

public class DBUtilTest {
    public static void main(String[] args) throws SQLException {
        //提供数据源（连接池），DBUtils底层自动维护连接connection
        QueryRunner queryRunner = new QueryRunner(DruidUtil.dataSource);

        //更新
        String sql = "insert into worker values(?,?,?,?,?,?)";
        Object[] param = {null,"张百万","待执行",10000,0, 10000};

        queryRunner.update(sql,param);



        //查询
        sql = "select * from worker where workerid > ?";
        List<Object[]> query = queryRunner.query(sql, new ArrayListHandler(), 5);

        //4.遍历集合获取数据
        for (Object[] objects : query) {
            System.out.println(Arrays.toString(objects));
        }

        List<Map<String, Object>> queryMap = queryRunner.query(sql, new MapListHandler(), 5);

        Iterator it = queryMap.iterator();
        while(it.hasNext()){
            Map<String, Object> m = (Map<String, Object>) it.next();
            Set<Map.Entry<String, Object>> entries = m.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                //打印结果
                System.out.println(entry.getKey() +" = " +entry.getValue());
            }
        }

    }
}
