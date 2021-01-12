import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.Model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/product")
	public String showProductPage(Model m)
	{
		Product product = new Product();
		m.addAttribute(product);
		m.addAttribute("categoryList", this.getCategory());
		m.addAttribute("productList",productDAO.listProducts());
		return "ManageProduct";
	}
	
	@RequestMapping("/totalProductInfo/{productId}")
	public String showTotalProductDisplay(@PathVariable("productId") int productId, Model m)
	{
		Product product = productDAO.getProduct(productId);
		m.addAttribute("product",product);
		m.addAttribute("categoryName", categoryDAO.getCategory(product.getCategoryId()).getCategoryName());
		return "TotalProductDisplay";
	}
	
	@RequestMapping("/ProductDisplay")
	public String displayAllProducts(Model m)
	{
		m.addAttribute("productList",productDAO.listProducts());
		return "ProductDisplay";
	}
	
	@RequestMapping(value="/ProductInsert", method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product,@RequestParam("pimage") MultipartFile imageFile, Model m)
	{
		productDAO.addProduct(product);
		m.addAttribute("categoryList", this.getCategory());		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		String path = "C:\\Users\\admin\\eclipse-workspace\\MyBazarFrontEnd\\src\\main\\resources\\Images\\";
		path = path+String.valueOf(product1.getProductId())+".jpg";
		
		File file = new File(path);
		
		if(!imageFile.isEmpty())
		{
			try {
				byte[] buffer=imageFile.getBytes();
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();				
			}
			catch(Exception e)
			{
				System.out.println("Exception Arose: " + e);
			}
		}
		else
		{
			m.addAttribute("ErrorInfo", "There is a system problem. No Image insertion");
		}
		
		
		Product prdt = new Product();
		m.addAttribute(prdt);
		m.addAttribute("productList",productDAO.listProducts());		
		System.out.println("Product Added");
		return "ManageProduct";
	}
}
