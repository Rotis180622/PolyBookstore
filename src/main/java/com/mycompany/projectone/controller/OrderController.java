/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.controller;

import java.util.Date;


/**
 *
 * @author Gaudomun
 * @param <OrderDetailViewModel>
 *
 */
public interface OrderController<OrderDetailViewModel> {
   
    void exportInvoice();             // Xuất hóa đơn mới
    void updateInvoice();             // Cập nhật hóa đơn hiện tại
    void cancelInvoice();             // Hủy (xóa) hóa đơn
    void resetForm();                 // Làm mới các trường nhập liệu
    void saveForm();                  // Lưu thông tin tạm thời của hóa đơn chi tiết
    void setEditable(boolean editable);               // Vô hiệu hóa các trường nhập liệu khi ấn nút lưu 

    void navigateFirst();             // <<
    void navigatePrevious();          // <
    void navigateNext();              // >
    void navigateLast();              // >>
    void navigateTo(Integer index);
    
    void searchInvoice(String keyword); // Tìm kiếm theo ngày, mã phiếu
    void searchInvoiceByTimeRange(Date begin, Date end);
    void selectTimeRange();
    void calculateTotal();            // Tính tổng thành tiền hiển thị ở bảng
    
    void setForm(OrderDetailViewModel entity);
    void edit();
    OrderDetailViewModel getForm();                    //Lấy dữ liệu từ form để cập  nhật lên cơ sở dữ liệu
    
    void fillTable();                   // Load dữ liệu lên bảng
    
    void open();                        //Mở cửa sổ JDialog
    
    
}
