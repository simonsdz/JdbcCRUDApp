package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.Player;
import com.service.IPlayerService;
import com.servicefactory.PlayerServiceFactory;

@WebServlet("/mainservlet/*")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IPlayerService playerService = PlayerServiceFactory.getPlayerService();
		PrintWriter writer = response.getWriter();
		if (request.getPathInfo().endsWith("add")) {
			String playerName = request.getParameter("playerName");
			String playerAge = request.getParameter("playerAge");
			String playerTeam = request.getParameter("playerTeam");

			Player player = new Player();
			player.setName(playerName);
			player.setAge(Integer.parseInt(playerAge));
			player.setTeam(playerTeam);

			Player addPlayer = playerService.addPlayer(player);
			if (addPlayer != null) {
				writer.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
			} else {
				writer.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
			}
		}
		if (request.getPathInfo().endsWith("search")) {
			String playerID = request.getParameter("playerID");

			Player player = playerService.searchPlayer(Integer.parseInt(playerID));

			if (player != null) {
				writer.println("<body>");
				writer.println("<br/><br/><br/>");
				writer.println("<center>");
				writer.println("<table border='1'>");
				writer.println("<tr><th>ID</th><td>" + player.getId() + "</td></tr>");
				writer.println("<tr><th>NAME</th><td>" + player.getName() + "</td></tr>");
				writer.println("<tr><th>AGE</th><td>" + player.getAge() + "</td></tr>");
				writer.println("<tr><th>TEAM</th><td>" + player.getTeam() + "</td></tr>");
				writer.println("</table>");
				writer.println("</center>");
				writer.println("</body>");
			} else {
				writer.println("<h1 style='color:red;text-align:center;'>RECORD NOT AVAILABLE FOR THE GIVEN ID "
						+ playerID + "</h1>");
			}
		}
		if (request.getPathInfo().endsWith("delete")) {
			String playerID = request.getParameter("playerID");
			Player player = playerService.searchPlayer(Integer.parseInt(playerID));

			if (player != null) {
				Player deletePlayer = playerService.deletePlayer(Integer.parseInt(playerID));
				
				if (deletePlayer != null) {
					writer.println("<body>");
					writer.println("<h1 style='color:green;text-align:center;'>RECORD DELETED SUCCESFULLY</h1>");
					writer.println("</body>");
				} else {
					writer.println("<body>");
					writer.println("<h1 style='color:green;text-align:center;'>RECORD NOT FOUND FOR DELETION</h1>");
					writer.println("</body>");
				}
			}
		}
		if (request.getPathInfo().endsWith("update")) {
			String playerID = request.getParameter("playerID");
			
			Player player = playerService.searchPlayer(Integer.parseInt(playerID));
			if (player != null) {
				writer.println("<body>");
				writer.println("<center>");
				writer.println("<form method='post' action='./controller/updateRecord'>");
				writer.println("<table>");
				writer.println("<tr><th>ID</th><td>" + player.getId() + "</td></tr>");
				writer.println("<input type='hidden' name='playerID' value='" + player.getId() + "'/>");
				writer.println("<tr><th>NAME</th><td><input type='text' name='playerName' value='" + player.getName()
						+ "'/></td></tr>");
				writer.println("<tr><th>AGE</th><td><input type='text' name='playerAge' value='" + player.getAge()
						+ "'/></td></tr>");
				writer.println("<tr><th>ADDRESS</th><td><input type='text' name='playerTeam' value='" + player.getTeam()
						+ "'/></td></tr>");
				writer.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				writer.println("</table>");
				writer.println("</form>");
				writer.println("</center>");
				writer.println("</body>");
			} else {
				writer.println("<body>");
				writer.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + playerID
						+ "</h1>");
				writer.println("</body>");
			}
		}
		if (request.getPathInfo().endsWith("updateRecord")) {
			String playerID = request.getParameter("playerID");
			String playerName = request.getParameter("playerName");
			String playerAge = request.getParameter("playerAge");
			String playerTeam = request.getParameter("playerTeam");
			
			Player player = new Player();
			player.setId(Integer.parseInt(playerID));
			player.setName(playerName);
			player.setAge(Integer.parseInt(playerAge));
			player.setTeam(playerTeam);
			
			Player updatePlayer = playerService.updatePlayer(player);
			
			if (updatePlayer != null) {
				writer.println("<h1 style='color:green; text-align:center;'>RECORD UPDATED SUCCESSFULLY</h1>");
			} else {
				writer.println("<h1 style='color:green; text-align:center;'>RECORD UPDATION FAILED</h1>");
			}
		}
		writer.close();
	}
}
