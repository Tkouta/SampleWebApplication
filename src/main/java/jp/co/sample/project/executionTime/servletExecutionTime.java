package jp.co.sample.project.executionTime;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 康太
 */
@WebServlet(name = "servletExecutionTime", urlPatterns = { "/servletExecutionTime" })
public class servletExecutionTime extends countTime {

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>サーブレット実行時間</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>ここは、サーブレットの実行時間をログに出力します。</h1>");
			out.println("<h1>時間の変化をわかりやすくするため、少し時間をおいてからログに出力します。</h1>");
			out.println("</body>");
			out.println("</html>");

			Thread.sleep(3000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
