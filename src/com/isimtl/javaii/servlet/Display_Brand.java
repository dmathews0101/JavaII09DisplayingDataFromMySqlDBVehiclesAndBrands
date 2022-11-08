package com.isimtl.javaii.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isimtl.javaii.dao.BrandDAO;
import com.isimtl.javaii.dao.VehicleDAO;
import com.isimtl.javaii.model.Brands;
import com.isimtl.javaii.model.Vehicles;

/**
 * Servlet implementation class Display_Brand
 */
@WebServlet("/Display_Brand")
public class Display_Brand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display_Brand() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Displaying Results</title></head><body>");
		out.println("<table><tr><th>Brand Id</th><th>Brand Name</th><th>Select</th></tr>");
		BrandDAO brandDAO = new BrandDAO();
		
		List<Brands> brands;

		String vehicleSelectedString=" ";

		out.println("<form method='post' action='DisplaySelectedBrand'>");
		
		try {
			brands = brandDAO.getAllBrands();			
			for(Brands brand:brands)
			{
				out.println("<tr>");
				out.println("<td>"+brand.getBrand_id()+"</td><td>"+brand.getBrand_name()+"</td>");
				out.println("<td><input type='radio'  name='selectBrandId' value='"+ brand.getBrand_id() + "'></td>");				
				out.println("</tr>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.println("<td>");
		
		out.println("<input type='hidden' name='data' value='"+vehicleSelectedString+"' ></input>");
		out.println("<input type='submit' name='submit' value = 'Submit'></input>");
		out.println("</form>");
		
		out.println("</td>");
		out.println("</table>");
		out.println("</body></html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
