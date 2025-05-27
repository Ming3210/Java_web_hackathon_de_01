package ra.java_web_13_hackathon_de_01.repository;

import org.springframework.stereotype.Repository;
import ra.java_web_13_hackathon_de_01.model.Category;
import ra.java_web_13_hackathon_de_01.model.Product;
import ra.java_web_13_hackathon_de_01.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepositoryImp implements ProductRepository{

    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call find_all_products()}";
            callableStatement = conn.prepareCall(sql);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setImageUrl(resultSet.getString("image_url"));
                product.setStatus(resultSet.getBoolean("status"));
                product.setCreateDate(resultSet.getDate("created_at"));
                product.setCategoryId(resultSet.getInt("category_id"));
                productList.add(product);
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callableStatement);
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement callableStatement = null;
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call add_product(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, product.getProductName());
            callableStatement.setString(2, product.getDescription());
            callableStatement.setDouble(3, product.getPrice());
            callableStatement.setString(4, product.getImageUrl());
            callableStatement.setBoolean(5, product.isStatus());
            callableStatement.setInt(6, product.getCategoryId());
            return callableStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callableStatement);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callableStatement = null;
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call delete_product(?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, id);
            return callableStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn, callableStatement);
        }
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callableStatement = null;
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call update_product(?,?,?,?,?,?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, product.getProductId());
            callableStatement.setString(2, product.getProductName());
            callableStatement.setString(3, product.getDescription());
            callableStatement.setDouble(4, product.getPrice());
            callableStatement.setString(5, product.getImageUrl());
            callableStatement.setBoolean(6, product.isStatus());
            return callableStatement.executeUpdate() > 0;
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn, callableStatement);

        }
    }

    @Override
    public Product findById(int id) {
        Connection conn = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        Product product = new Product();
        try {
            conn = ConnectionDB.openConnection(conn);
            String sql = "{call find_product_by_id(?)}";
            callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, id);
            resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setImageUrl(resultSet.getString("image_url"));
                product.setStatus(resultSet.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, callableStatement);
        }
        return product;
    }


}
