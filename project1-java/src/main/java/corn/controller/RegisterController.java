package corn.controller;

import java.io.IOException;

import corn.service.IUserService;
import corn.service.Impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	private IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/dangky.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tenDangNhap = req.getParameter("tenDangNhap");
		String matKhau = req.getParameter("matKhau");
		String matKhauNhapLai = req.getParameter("matKhauNhapLai");
		String hoVaTen = req.getParameter("hoVaTen");
		String gioiTinh = req.getParameter("gioiTinh");
		String diaChi = req.getParameter("diaChiKhachHang");
		String dienThoai = req.getParameter("dienThoai");
		String email = req.getParameter("email");
		req.setAttribute("tenDangNhap", tenDangNhap);		
		req.setAttribute("hoVaTen", hoVaTen);
		req.setAttribute("gioiTinh", gioiTinh);
		req.setAttribute("diaChiKhachHang", diaChi);
		req.setAttribute("dienThoai", dienThoai);
		
		String url = "";
		
		String baoLoi = "";
		
		if(userService.checkTrungTenDangNhap(tenDangNhap)) {
			baoLoi +="Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/>";
		}
		
		if(!matKhau.equals(matKhauNhapLai)) {
			baoLoi +="Mẫu khẩu không khớp.<br/>";
		}
		
		req.setAttribute("baoLoi", baoLoi);
		
		if(baoLoi.length()>0) {
			url = "/views/dangky.jsp";
		}
		else {
			userService.taoTaoKhoanMoi(tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, dienThoai, email);
			url = "/views/dangnhap.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(req, resp);
		
	}
	
}
