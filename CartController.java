import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CartDAO;
import com.niit.DAO.ProductDAO;
import com.niit.Model.CartItem;
import com.niit.Model.Product;

@Controller
public class CartController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping(value="/AddToCart/{productId}")
	public String addCartItem(@RequestParam("quantity") int quantity, @PathVariable("productId") int productId, Model m, HttpSession session)
	{
		Product product = productDAO.getProduct(productId);
		String username = (String)session.getAttribute("username");
		
		CartItem cartItem=new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setPrice(product.getPrice());
		cartItem.setUsername(username);
		cartItem.setStatus("NA");
		
		cartDAO.addCartItem(cartItem);
		
		List<CartItem> cartItems = cartDAO.showCartItems(username);
		
		m.addAttribute("cartItems", cartItems);
		m.addAttribute("totalPurchaseAmount",this.calcTotalPurchaseAmount(cartItems));
		
		
		return "Cart";
	}
	public int calcTotalPurchaseAmount(List<CartItem> cartItems)
	{
		int totalPurchaseAmount = 0;
		int count = 0;
		
		while(count<cartItems.size())
		{
			CartItem cartItem=cartItems.get(count);
			totalPurchaseAmount=totalPurchaseAmount+(cartItem.getQuantity()*cartItem.getPrice());
			count++;
		}
		return totalPurchaseAmount;
	}
	
	@RequestMapping(value="/updateCartItems/{cartItemId}")
	public String updateCartItem(@RequestParam("quantity") int quantity, @PathVariable("cartItemId") int cartItemId, Model m, HttpSession session)
	{
		CartItem cartItem=cartDAO.getCartItem(cartItemId);
		String username=(String)session.getAttribute("username");
		
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);
		cartItem.setUsername(username);
		
		return "Cart";
	}
	
	
	
}
