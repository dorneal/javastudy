package is.mynote.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author neal
 */
public class BuildSqlTest {
    /**
     * 用参数替换sql的特殊标记，如果标记对应的参数存在，则直接替换，
     * 如果不存在，要把对应的一段条件去掉，
     * 最后得出一个能用于查询的sql语句，返回能用于查询的sql语句。
     *
     * @param labelSql 带有标记的sql语句
     * @param param    参数集合
     * @return 能用于查询的sql
     */
    private static String getRunnableSql(String labelSql, Map<String, Object> param) {
        //转成字符数组
        char[] sqlChar = labelSql.toCharArray();
        //遍历字符数组
        for (int i = 0; i < sqlChar.length; i++) {
            //如果有:，取的:后面的两个字母
            if (':' == sqlChar[i]) {
                int count = i;
                //：后面的两个字母，返回一个String
                String sqlParam = String.valueOf(sqlChar[count] + sqlChar[++count]);
                //根据String,得到value
                Object object = param.get(sqlParam);
                //如果取不到，则把这个表达式删除掉
                if (object == null) {
                    System.out.println("没这个值");
                } else {
                    //如果有，就替换掉
                    System.out.println(object.toString());
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String sql = "select * from user where a=:aa and ab=:dd";
        Map<String, Object> map = new HashMap<>(16);
        map.put("aa", "jack");
        map.put("bb", "jack");
        System.out.println(getRunnableSql(sql, map));
    }
}
