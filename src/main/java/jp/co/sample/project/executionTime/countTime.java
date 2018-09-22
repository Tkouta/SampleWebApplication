package jp.co.sample.project.executionTime;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ログを出力するサーブレットの親クラスです。
 * このクラスを継承したサーブレットはログを自動的に出力します。
 *
 * @author 康太
 */
public class countTime extends HttpServlet {

	protected static File logFile = null;

	protected static FileWriter logFileWriter = null;

	protected static PrintWriter logWriter = null;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * GETリクエスト、POSTリクエストを受け取った際に実行されるメソッドです。
		 * 今回はログを自動的に出力することが目的のため、どちらのリクエストでも同じ処理を実行するようにします。
		 * オーバーライドしたサーブレットによって出力する内容が変わります。
		 */
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		Date startDate = new Date();

		try {
			logFile = new File("C:/Users/康太/Documents/NetBeansProjects/PracticeProject/logs");
			logFile.createNewFile();
			logFileWriter = new FileWriter("C:/Users/康太/Documents/NetBeansProjects/PracticeProject/logs/filter.log",
					true);
			logWriter = new PrintWriter(new BufferedWriter(logFileWriter));
			logWriter.println("サーブレット実行開始 : " + startDate.toString());
			logWriter.println("サーブレット初期パラメーター一覧 : " + config.getInitParameterNames());
			logWriter.println("サーブレットインスタンス名 : " + config.getServletName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public void destroy() {
		Date endDate = new Date();
		try {
			logWriter.println("サーブレット実行終了 : " + endDate.toString());
		} finally {
			logWriter.close();
		}
	}

}
