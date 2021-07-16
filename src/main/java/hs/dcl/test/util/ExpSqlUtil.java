package hs.dcl.test.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpSqlUtil {

    public static List<Object> getTableInsertSql(Connection conn, String tableName , String where) throws Exception {
        ResultSet rs = null;
        Statement statement = null;
        List<Object> list=null;
        try {

            DatabaseMetaData metadata = conn.getMetaData();
            rs = metadata.getColumns(null, null, tableName, "%");    //得到表的字段列表

            String sql = "select 'insert into " + tableName + " values ( '";
            int count=0;
            int  counts=0;
            //获得列的总数
            while (rs.next()) {
                count++;

            }
            //重新获得列数据 整理成sql
            rs = metadata.getColumns(null, null, tableName, "%");    //得到表的字段列表
            while (rs.next()) {
                counts++;
                if(counts<=count)
                {
                    Object colName = rs.getObject("column_name");
                    sql += " ||'''' ||" + colName + "|| ''','";
                }
            }
            sql=sql.substring(0,sql.length()-2)+"'";
            sql += " || ' );' from " + tableName+ where;
            rs.close();

            // System.out.println("DEBUG: SQL="+sql);
            //执行
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            //将SQL语句放到List中
            list=new ArrayList<Object>();
            while (rs.next())
                list.add(rs.getObject(1));
            rs.close();

            //System.out.println(list.size());
        } finally {
            if (rs != null)
                rs.close();
            if (statement != null)
                statement.close();
        }
        return list;
    }

}
