import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CategoryDAO;
import com.niit.Model.Category;


@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/category")
	public String showCategoryPage(Model m)
	{
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/InsertCategory", method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catname") String categoryName, @RequestParam("catDesc") String categoryDesc, Model m)
	{
		
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(category);
		
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
	
		
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryID}")
	public String deleteCategory(@PathVariable("categoryID") int categoryId, Model m)
	{
		
		Category category = categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
		
		
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryID}")
	public String editCategory(@PathVariable("categoryID") int categoryId, Model m)
	{
		
		Category category = categoryDAO.getCategory(categoryId);
		m.addAttribute("categoryData",category);
		return "Category";
	}
}
