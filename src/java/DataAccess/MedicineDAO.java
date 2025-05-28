/**
 *
 * @author thiet . Date: 26/05/2025
 */
package DataAccess;

import Entity.Medicine;
import Utility.DBContext;

import java.sql.*;
import java.util.*;
import java.math.BigDecimal;

public class MedicineDAO extends DBContext {

    public List<Medicine> getAllMedicines() {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Medicine med = new Medicine(
                        rs.getString("medicine_id"),
                        rs.getString("image"),
                        rs.getString("medicine_name"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("price"),
                        rs.getDate("expiry_date")
                );
                list.add(med);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Medicine> findMedicinesByName(String name) {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine WHERE LOWER(medicine_name) LIKE LOWER(?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Medicine med = new Medicine(
                            rs.getString("medicine_id"),
                            rs.getString("image"),
                            rs.getString("medicine_name"),
                            rs.getInt("quantity"),
                            rs.getBigDecimal("price"),
                            rs.getDate("expiry_date")
                    );
                    list.add(med);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertMedicine(Medicine medicine) {
        String sql = "INSERT INTO Medicine(medicine_id, image, medicine_name, quantity, price, expiry_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, medicine.getMedicineId());
            ps.setString(2, medicine.getImage());
            ps.setString(3, medicine.getMedicineName());
            ps.setInt(4, medicine.getQuantity());
            ps.setBigDecimal(5, medicine.getPrice());
            ps.setDate(6, new java.sql.Date(medicine.getExpiryDate().getTime()));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String generateNextMedicineId() {
        String sql = "SELECT TOP 1 medicine_id FROM Medicine ORDER BY medicine_id DESC";
        try (PreparedStatement ptm = connection.prepareStatement(sql); ResultSet rs = ptm.executeQuery()) {
            if (rs.next()) {
                String lastId = rs.getString("medicine_id"); // ví dụ "MED012"
                int num = Integer.parseInt(lastId.substring(3)); // bỏ 3 ký tự đầu "MED"
                num++; // tăng lên
                return String.format("MED%03d", num); // ví dụ "MED013"
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "MED001"; // Nếu chưa có gì trong DB
    }

    public boolean updateMedicine(Medicine medicine) {
        String sql = "UPDATE Medicine SET medicine_name=?, image=?, quantity=?, price=?, expiry_date=? WHERE medicine_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, medicine.getMedicineName());
            ps.setString(2, medicine.getImage());
            ps.setInt(3, medicine.getQuantity());
            ps.setBigDecimal(4, medicine.getPrice());
            ps.setDate(5, new java.sql.Date(medicine.getExpiryDate().getTime()));
            ps.setString(6, medicine.getMedicineId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteMedicine(String medicineId) {
        String sql = "DELETE FROM Medicine WHERE medicine_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, medicineId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Medicine> getExpiredSoon() {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine WHERE expiry_date BETWEEN CAST(GETDATE() AS DATE) AND DATEADD(DAY, 30, CAST(GETDATE() AS DATE))";
        try (
                PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medicine med = new Medicine(
                        rs.getString("medicine_id"),
                        rs.getString("image"),
                        rs.getString("medicine_name"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("price"),
                        rs.getDate("expiry_date")
                );
                list.add(med);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Medicine> getOverDate() {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine WHERE expiry_date < CAST(GETDATE() AS DATE)";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medicine med = new Medicine(
                        rs.getString("medicine_id"),
                        rs.getString("image"),
                        rs.getString("medicine_name"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("price"),
                        rs.getDate("expiry_date")
                );
                list.add(med);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Medicine> getSortedByName() {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine ORDER BY medicine_name ASC";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medicine med = new Medicine(
                        rs.getString("medicine_id"),
                        rs.getString("image"),
                        rs.getString("medicine_name"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("price"),
                        rs.getDate("expiry_date")
                );
                list.add(med);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Medicine> getSortedByPrice() {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine ORDER BY price ASC";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medicine med = new Medicine(
                        rs.getString("medicine_id"),
                        rs.getString("image"),
                        rs.getString("medicine_name"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("price"),
                        rs.getDate("expiry_date")
                );
                list.add(med);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Medicine> getSortedByQuantity() {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine ORDER BY quantity ASC";  // Sắp xếp theo quantity tăng dần
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medicine med = new Medicine(
                        rs.getString("medicine_id"),
                        rs.getString("image"),
                        rs.getString("medicine_name"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("price"),
                        rs.getDate("expiry_date")
                );
                list.add(med);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean reduceMedicineQuantity(String medicineId, int amount) {
        String selectSql = "SELECT quantity FROM Medicine WHERE medicine_id = ?";
        String updateSql = "UPDATE Medicine SET quantity = quantity - ? WHERE medicine_id = ?";

        try {
            PreparedStatement psSelect = connection.prepareStatement(selectSql);
            psSelect.setString(1, medicineId);
            ResultSet rs = psSelect.executeQuery();

            if (!rs.next()) {
                rs.close();
                psSelect.close();
                return false; // Thuốc không tồn tại
            }

            int currentQuantity = rs.getInt("quantity");
            rs.close();
            psSelect.close();

            if (currentQuantity < amount) {
                return false; // Không đủ thuốc
            }

            PreparedStatement psUpdate = connection.prepareStatement(updateSql);
            psUpdate.setInt(1, amount);
            psUpdate.setString(2, medicineId);
            int updatedRows = psUpdate.executeUpdate();
            psUpdate.close();

            return updatedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
