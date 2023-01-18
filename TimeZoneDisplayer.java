package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneDisplayer  extends HttpServlet {
	public void service(ServletRequest Req, ServletResponse Res) throws ServletException , IOException{
		Res.setContentType("text/html");
		PrintWriter out = Res.getWriter();
		try {
		String country = Req.getParameter("country");
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setTimeZone(TimeZone.getTimeZone(country));
		sdf.applyPattern("dd MMM yyyy HH:mm:ss");
		String Time = sdf.format(Calendar.getInstance().getTime());
		RequestDispatcher rd = Req.getRequestDispatcher("/index.html");
		rd.include(Req, Res);
		out.println("<h3 class='output'>"+Time+"</h3>");
		}
		catch(Exception ee) {
			out.print(ee);
		}
	}
}

