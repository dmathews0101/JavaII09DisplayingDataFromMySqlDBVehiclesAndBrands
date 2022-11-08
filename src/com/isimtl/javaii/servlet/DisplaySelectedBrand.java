package com.isimtl.javaii.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isimtl.javaii.dao.VehicleDAO;
import com.isimtl.javaii.model.Vehicles;


/**
 * Servlet implementation class DisplaySelectedBrand
 */
@WebServlet("/DisplaySelectedBrand")
public class DisplaySelectedBrand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	VehicleDAO vehicleDAO = new VehicleDAO();	
	List<Vehicles> vehicleSelected;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySelectedBrand() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			vehicleSelected = vehicleDAO.getSelectedVehicle(Integer.parseInt(request.getParameter("selectBrandId")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();				
		out.println("<html><head><title>Selected Brand</title></head><body>");
		out.println("<table><tr><th>Nb</th><th>Model</th><th>Year</th><th>Price</th></tr>");

		
		for(Vehicles vehicle:vehicleSelected)
		{
			out.println("<tr>");
			out.println("<td>"+vehicle.getNb()+"</td><td>"+vehicle.getModel()+"</td><td>"+vehicle.getYear()+"</td><td>"+vehicle.getPrice()+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body></html>");
		out.close();
	}

}
