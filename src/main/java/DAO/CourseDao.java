package DAO;/**
 * Created by Hatsune Mona on 2020/4/10. 初音萌奈什喵的最可爱了喵！
 */

import DBUtil.SQLConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.CourseinfoEntity;

/**
 * @program: JavaWeb
 * @description: 对courseinfo数据库的操作
 * @author: Created by Hatsune Mona. 初音萌奈什喵的最可爱了喵！
 * @create: 2020-04-10 21:12
 **/
public class CourseDao {
  
  static public int InsertCourse(CourseinfoEntity courseInfo) {
    Connection connection = SQLConnect.getConnection();//打开数据库连接
    PreparedStatement pstmt = null;
    String insertSQL = "INSERT INTO courseinfo VALUES(?,?,?,?,?)";
    int flag = 0;
    try {
      pstmt = connection.prepareStatement(insertSQL);
      pstmt.setInt(1, courseInfo.getCourseNo());
      pstmt.setString(2, courseInfo.getCourseName());
      pstmt.setInt(3, courseInfo.getFirstClass());
      pstmt.setInt(4, courseInfo.getCourseCredit());
      pstmt.setInt(5, courseInfo.getTeacher());
      flag = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return flag;
  }
}