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
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Displaying Results</title></head><body>");
		out.println("<table><tr><th>Nb</th><th>Model</th><th>Year</th><th>Price</th><th>BrandID</th></tr>");
		VehicleDAO vehicleDAO = new VehicleDAO();
		List<Vehicles> vehicles;
		try {
			vehicles = vehicleDAO.getAllVehicles();
			for(Vehicles vehicle:vehicles)
			{
				out.println("<tr>");
				out.println("<td>"+vehicle.getNb()+"</td><td>"+vehicle.getModel()+"</td><td>"+vehicle.getYear()+"</td><td>"+vehicle.getPrice()+"</td><td>"+vehicle.getBrand()+"</td>");
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
