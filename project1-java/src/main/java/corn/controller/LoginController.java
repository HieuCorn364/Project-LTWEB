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

@WebServlet({ "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -3154067093097443927L;
	private IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/dangnhap.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tenDangNhap = req.getParameter("username");
		String matKhau = req.getParameter("password");

		boolean isLogin = userService.checkLogin(tenDangNhap, matKhau);
		String url = "";
		if (isLogin) {
			url = "/views/Success.jsp";
		} else {
			url = "/views/Error.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(req, resp);
	}
}

