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

@WebServlet("/forgot")
public class ForgotPassController extends HttpServlet {

	IUserService iUserService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("emailf");
		String passf = req.getParameter("passf");
		String usernamef = req.getParameter("usernamef");
		boolean isEmail = iUserService.checkEmail(email);
		String url = "";
		if (isEmail) {
			iUserService.changePass(passf, usernamef);
			url = "/views/dangnhap.jsp";
		} else {
			url = "/views/forgotpass.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rDispatcher = req.getRequestDispatcher("/views/forgotpass.jsp");
		rDispatcher.forward(req, resp);
	}
	
	
}
