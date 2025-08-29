/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.ui.manager;

import com.mycompany.projectone.dao.impl.OrderDAOImpl;
import com.mycompany.projectone.dao.impl.OrderDetailDAOImpl;
import com.mycompany.projectone.entity.Order;
import com.mycompany.projectone.entity.OrderDetail;
import com.mycompany.projectone.util.XDialog;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class InvoicePreviewDialog extends JDialog {
    private Order order;
    private JTable tblDetails;
    private DefaultTableModel model;
    private OrderDAOImpl orderDao = new OrderDAOImpl();
    private OrderDetailDAOImpl odDao = new OrderDetailDAOImpl();

    public InvoicePreviewDialog(Frame parent, Order order) {
        super(parent, "Xem trước hóa đơn", true);
        this.order = order;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Panel thông tin hóa đơn
        JPanel pnlInfo = new JPanel(new GridLayout(0, 2, 10, 5));
        pnlInfo.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        pnlInfo.add(new JLabel("Mã hóa đơn:"));
        pnlInfo.add(new JLabel(String.valueOf(order.getOrderID())));

        pnlInfo.add(new JLabel("Nhân viên:"));
        pnlInfo.add(new JLabel(String.valueOf(order.getEmployeeID())));

        pnlInfo.add(new JLabel("Khách hàng:"));
        pnlInfo.add(new JLabel(String.valueOf(order.getCustomerID())));

        pnlInfo.add(new JLabel("Ngày lập:"));
        pnlInfo.add(new JLabel(String.valueOf(order.getOrderDate())));

        pnlInfo.add(new JLabel("Khuyến mãi:"));
        pnlInfo.add(new JLabel(String.valueOf(order.getPromotionID())));

        add(pnlInfo, BorderLayout.NORTH);

        // Bảng chi tiết hóa đơn
        model = new DefaultTableModel(new Object[]{"Mã sách", "Số lượng"}, 0);
        for (OrderDetail od : order.getOrderDetails()) {
            model.addRow(new Object[]{od.getBookID(), od.getQuantity()});
        }
        tblDetails = new JTable(model);
        add(new JScrollPane(tblDetails), BorderLayout.CENTER);

        // Nút điều khiển
        JPanel pnlButtons = new JPanel();
        JButton btnPay = new JButton("Thanh toán");
        JButton btnCancel = new JButton("Hủy");

        btnPay.addActionListener(e -> {
            // Lưu xuống DB
            saveInvoiceToDB();
            XDialog.alert("Xuất hóa đơn thành công!");
            dispose();
        });

        btnCancel.addActionListener(e -> dispose());

        pnlButtons.add(btnPay);
        pnlButtons.add(btnCancel);
        add(pnlButtons, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(getParent());
    }

    private void saveInvoiceToDB() {
        // Lưu hóa đơn tổng
        orderDao.create(order);
        // Lưu từng chi tiết hóa đơn
        for (OrderDetail od : order.getOrderDetails()) {
            odDao.create(od);
        }
    }
}
