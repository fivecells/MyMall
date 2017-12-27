package com.qianfeng.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Product;
import com.qianfeng.domain.User;
import com.qianfeng.service.ProductService;

@SuppressWarnings("serial")
public class PayServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String submit = request.getParameter("pay");
		if("删除".equals(submit)){
			request.getRequestDispatcher("/deleteCartServlet").forward(request, response);
		}else{
			ProductService service = new ProductService();
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			@SuppressWarnings("unchecked")
			Map<Product, Integer> cartMap = (Map<Product, Integer>) session.getAttribute("cartMap");
			Map<Product, Integer> orderMap = new HashMap<>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String str = sdf.format(new Date());
			int count = service.getOrdersCount();
			String oid = str+count;
			String[] orderPids = request.getParameterValues("orderPids");
			String total = request.getParameter("totalPrice");
			System.out.println(total);
			double totalPrice = Double.parseDouble(total);
			service.updateOrders(oid,totalPrice,user.getUid());
			if (orderPids!=null) {
				for (String pid : orderPids) {
					String proNum = request.getParameter("num_" + pid);
					int productNum = Integer.parseInt(proNum);
					Product product = service.getProductByPid(pid);
					System.out.println("产品"+product);
					System.out.println("数量"+productNum);
					totalPrice += productNum * product.getShop_price();
					orderMap.put(product, productNum);
					service.updateOrderItem(oid, pid, productNum);
					if (cartMap.containsKey(product)) {
						if (cartMap.get(product) == productNum) {
							cartMap.remove(product);
						}
					}
				} 
			}
			session.setAttribute("orderMap", orderMap);
			session.setAttribute("cartMap", cartMap);
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("oid", oid);
			request.getRequestDispatcher("/pay.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}