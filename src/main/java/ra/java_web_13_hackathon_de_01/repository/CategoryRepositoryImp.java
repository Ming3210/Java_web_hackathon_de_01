package ra.java_web_13_hackathon_de_01.repository;

import org.springframework.stereotype.Repository;
import ra.java_web_13_hackathon_de_01.model.Category;
import ra.java_web_13_hackathon_de_01.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryRepositoryImp implements CategoryRepository{
    @Override
    public List<Category> findAll() {
        Connection conn = null;
        List<Category> categoryList = new ArrayList<>();
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call find_all_category()}";
            callableStatement = conn.prepareCall(sql);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setDescription(resultSet.getString("description"));
                category.setStatus(resultSet.getBoolean("status"));
                categoryList.add(category);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn, callableStatement);
        }
        return categoryList;
    }

    @Override
    public Category findById(int id) {
        Connection conn = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        Category category = new Category();
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call find_category_by_id(?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, id);
            resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setDescription(resultSet.getString("description"));
                category.setStatus(resultSet.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, callableStatement);
        }
        return category;
    }

    @Override
    public boolean addCategory(Category category) {
        Connection conn = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call add_category(?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, category.getCategoryName());
            callableStatement.setString(2, category.getDescription());
            callableStatement.setBoolean(3, category.isStatus());
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, callableStatement);
        }

    }

    @Override
    public boolean deleteCategory(int id) {
        Connection conn = null;
        CallableStatement callableStatement = null;
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call delete_category(?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, id);
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, callableStatement);
        }
    }

    @Override
    public boolean updateCategory(Category category) {
        Connection conn = null;
        CallableStatement callableStatement = null;
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call update_category(?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, category.getCategoryId());
            callableStatement.setString(2, category.getCategoryName());
            callableStatement.setString(3, category.getDescription());
            callableStatement.setBoolean(4, category.isStatus());
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, callableStatement);
        }
    }
}
