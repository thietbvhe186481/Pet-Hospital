/*
 * Thiet. Date 26/05/2025
 * 
 */
package BusinessLogic;

import DataAccess.MedicineDAO;
import Entity.Medicine;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author quang
 */
@WebServlet(name = "MedicineBL", urlPatterns = {"/MedicineManagement"})
public class MedicineBL extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String service = request.getParameter("service");

        if ("search".equals(service)) {
            String keyword = request.getParameter("keyword").trim();

            MedicineDAO dao = new MedicineDAO(); // hoặc dùng DAO đã có
            List<Medicine> resultList = new ArrayList<>();

            // Nếu nhập đúng ID (ví dụ: M001) thì ưu tiên tìm theo ID
            Medicine medicine = dao.findMedicineById(keyword);
            if (medicine != null) {
                resultList.add(medicine);
            } else {
                // Nếu không tìm thấy theo ID, tìm theo tên gần đúng
                resultList = dao.findMedicinesByName(keyword);
            }

            request.setAttribute("medicineList", resultList);
            request.getRequestDispatcher("Presentation/Medicine.jsp").forward(request, response);

        }

        if ("addMedicine".equals(service)) {
            String id = request.getParameter("medicineId");
            String name = request.getParameter("medicineName");
            String image = request.getParameter("image");
            String quantityStr = request.getParameter("quantity");
            String priceStr = request.getParameter("price");
            String expiryDateStr = request.getParameter("expiryDate");

            try {
                int quantity = Integer.parseInt(quantityStr);
                BigDecimal price = new BigDecimal(priceStr);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date parsed = sdf.parse(expiryDateStr); // java.util.Date
                java.sql.Date expiryDate = new java.sql.Date(parsed.getTime());

                Medicine medicine = new Medicine(id, image, name, quantity, price, expiryDate);
                MedicineDAO dao = new MedicineDAO();
                dao.insertMedicine(medicine);
                response.sendRedirect("Presentation/Medicine.jsp");

            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Lỗi khi thêm thuốc: " + e.getMessage());
            }
        }

        if ("updateMedicine".equals(service)) {
            String id = request.getParameter("medicineId");
            String name = request.getParameter("medicineName");
            String image = request.getParameter("image");
            String quantityStr = request.getParameter("quantity");
            String priceStr = request.getParameter("price");
            String expiryDateStr = request.getParameter("expiryDate"); // định dạng yyyy-MM-dd

            try {
                int quantity = Integer.parseInt(quantityStr);
                BigDecimal price = new BigDecimal(priceStr);

                // parse ngày yyyy-MM-dd
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date parsed = sdf.parse(expiryDateStr);
                java.sql.Date expiryDate = new java.sql.Date(parsed.getTime());

                Medicine medicine = new Medicine(id, image, name, quantity, price, expiryDate);

                MedicineDAO dao = new MedicineDAO();
                boolean success = dao.updateMedicine(medicine);
                if (success) {
                    response.sendRedirect("Presentation/Medicine.jsp"); // trang sau khi update thành công
                } else {
                    response.getWriter().println("Lỗi khi cập nhật thuốc.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Lỗi khi cập nhật thuốc: " + e.getMessage());
            }
        }

        if ("deleteMedicine".equals(service)) {
            String medicineId = request.getParameter("medicineId");
            boolean deleted = false;
            if (medicineId != null && !medicineId.isEmpty()) {
                MedicineDAO dao = new MedicineDAO();
                deleted = dao.deleteMedicine(medicineId);
            }

            if (deleted) {
                request.setAttribute("message", "Deleted successfully");
            } else {
                request.setAttribute("message", "Delete failed");
            }
            response.sendRedirect("Presentation/Medicine.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
