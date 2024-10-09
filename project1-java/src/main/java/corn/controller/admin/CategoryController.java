package corn.controller.admin;

import java.io.IOException;
import java.util.List;

import corn.entity.CategoryEntity;
import corn.service.ICategoryService;
import corn.service.Impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/admin/categories")
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ICategoryService iCategoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryEntity> list = iCategoryService.findAll();
		//sau khi nhan list thi se day ra view
		req.setAttribute("listcate", list);
		// đẩy
		req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
	}
}
