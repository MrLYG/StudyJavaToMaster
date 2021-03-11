import Util.DruidUtil;

import java.sql.*;


public class DruidTest {
    public static void main(String[] args) throws SQLException {
        Connection con  = DruidUtil.getConnection();
        String sql = "select * from worker where workerid > ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,10);
        ResultSet resultSet = ps.executeQuery();

        ResultSetMetaData metaData = ps.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount() ; i++) {
            System.out.println(metaData.getColumnName(i));
            System.out.println(metaData.getColumnTypeName(i));

            System.out.println("---------------------------------");
        }
        System.out.println();
        while (resultSet.next()){
            int id = resultSet.getInt("workerid");
            String workername = resultSet.getString("workername");
            System.out.println(workername);
        }


    }
}
