package com.mycompany.projectone.util;

//import com.mycompany.cafe.entity.User;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Lớp tiện ích hỗ trợ làm việc với CSDL quan hệ
 *
 * @author NghiemN
 * @version 1.0
 */
public class XJdbc {

    private static Connection connection;

    /**
     * Mở kết nối nếu chưa mở hoặc đã đóng
     *
     * @return Kết nối đã sẵn sàng
     */
   public static Connection openConnection() {
    var driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    var dburl = "jdbc:sqlserver://localhost:1433;database=ProjectOneJava;encrypt=true;trustServerCertificate=true;";
    var user = "sa"; 
    var password = "123";
    try {       
        if (!XJdbc.isReady()) {
            System.out.println("Da ket noi den CSDL");
            Class.forName(driver);
            connection = DriverManager.getConnection(dburl, user, password); 
        }
    } catch (ClassNotFoundException | SQLException e) {
        throw new RuntimeException(e);
    }
    return connection;
}

    /**
     * Đóng kết nối
     */
    public static void closeConnection() {
        try {
            if (XJdbc.isReady()) {
                System.out.println("Da dong  CSDL");
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Kiểm tra kết nối đã sẵn sàng hay chưa
     * @return true nếu kết nối đã được mở
     */
    public static boolean isReady() {
        try {
            System.out.println("Kiem tra CSDL");
            return (connection != null && !connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Thao tác dữ liệu
     *
     * @param sql câu lệnh SQL (INSERT, UPDATE, DELETE)
     * @param values các giá trị cung cấp cho các tham số trong SQL
     * @return số lượng bản ghi đã thực hiện
     * @throws RuntimeException không thực thi được câu lệnh SQL
     */
    
    
    public static int executeUpdate(String sql, Object... values) {
        try {
            var stmt = XJdbc.getStmt(sql, values);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Truy vấn dữ liệu
     *
     * @param sql câu lệnh SQL (SELECT)
     * @param values các giá trị cung cấp cho các tham số trong SQL
     * @return tập kết quả truy vấn
     * @throws RuntimeException không thực thi được câu lệnh SQL
     */
    
    public static ResultSet executeQuery(String sql, Object... values) {
        try {
            var stmt = XJdbc.getStmt(sql, values);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


// sửa code này sau khi tạo đủ các entity và form, này là code tui dùng ở Dự Án mẫu -)  
//    @Builder
//public static Account checklogin(String user, String password) throws SQLException {
//    String sql = "SELECT Username, Password, Manager, Fullname, Photo FROM Users WHERE Username = ? AND Password = ?";
//    try (Connection con = openConnection(); 
//         PreparedStatement ps = con.prepareStatement(sql)) {
//        ps.setString(1, user);
//        ps.setString(2, password);
//        try (ResultSet rs = ps.executeQuery()) {
//            if (rs.next()) {
//                return Account.builder()
//                        .username(rs.getString("Username"))
//                        .password(rs.getString("Password"))
//                        .manager(rs.getBoolean("Manager"))
//                        .fullname(rs.getString("Fullname"))
//                        .photo(rs.getString("Photo"))
//                        .build();
//            }
//        }
//        return null;
//    }
//}

    /**
     * Truy vấn một giá trị
     *
     * @param <T> kiểu dữ liệu kết quả
     * @param sql câu lệnh SQL (SELECT)
     * @param type
     * @param values các giá trị cung cấp cho các tham số trong SQL
     * @return giá trị truy vấn hoặc null
     * @throws RuntimeException không thực thi được câu lệnh SQL
     */
public static <T> T getValue(String sql, Class<T> type, Object... values) {
    try {
        var resultSet = XJdbc.executeQuery(sql, values);
        if (resultSet.next()) {
            Object value = resultSet.getObject(1);
            return type.cast(value); 
        }
        return null;
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}

    /**
     * Tạo PreparedStatement từ câu lệnh SQL/PROC
     *  
     * @param sql câu lệnh SQL/PROC
     * @param values các giá trị cung cấp cho các tham số trong SQL/PROC
     * @return đối tượng đã tạo
     * @throws SQLException không tạo được PreparedStatement
     */



    private static PreparedStatement getStmt(String sql, Object... values) throws SQLException {
        var conn = XJdbc.openConnection();
        var stmt = sql.trim().startsWith("{") ? conn.prepareCall(sql) : conn.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            stmt.setObject(i + 1, values[i]);
        }
        return stmt;
    }
    

    public static void main(String[] args) throws SQLException {
       try {
        openConnection();
        if (XJdbc.isReady()) {
            System.out.println("Ket noi den database thanh cong");
        } else {
            System.out.println("Ket noi that bai.");
        }
       
    } catch (RuntimeException e) {
        System.out.println("Ket noi that bai do loi  + " + e.getMessage());
    } finally {
        XJdbc.closeConnection(); 
    }
    }



}
