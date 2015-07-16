package com.iflysse.bbs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iflysse.bbs.dao.UserDao;
import com.iflysse.bbs.dao.impl.UserDaoImpl;
import com.iflysse.bbs.model.UserInfo;

/**
 * Servlet implementation class AjaxAction
 */
@WebServlet("/ajax.do")
public class AjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		PrintWriter out=null;
		if(flag.equals("login"))
		{
			String account=request.getParameter("account");
			String password=request.getParameter("password");
			UserDao dao=new UserDaoImpl();
			String jsonStr=null;
			out=response.getWriter();
			if(password==null)
			{
				if(dao.getUser(account)!=null)
				{
					jsonStr="{flag:true}";
				}
				out.print(jsonStr);
			}
			else{
				
				if(dao.getUser(account,password)!=null)
				{
					jsonStr="{flag:true}";
				}
				out.print(jsonStr);
			}
			out.close();
		}
		if(flag.equals("register"))
		{
			String account=request.getParameter("account");
			String password=request.getParameter("password");
			UserDao dao=new UserDaoImpl();
			String jsonStr=null;
			out=response.getWriter();
			if(password==null)
			{
				if(dao.getUser(account)!=null)
				{
					
					jsonStr="{flag:true}";
				}
				out.print(jsonStr);
			}
			else{
				if(dao.getUser(account,password)!=null)
				{
					jsonStr="{flag:true}";
				}
				out.print(jsonStr);
			}
			out.close();
		}
		if(flag.equals("editpwd")){
			HttpSession session=request.getSession(true);
			String password=request.getParameter("password");
			UserInfo user=(UserInfo) session.getAttribute("currentUser");
			UserDao dao=new UserDaoImpl();
			String jsonStr=null;
			if(dao.getUser(user.getAccount(), password)!=null)
			{
				jsonStr="{flag:true}";
			}
			out=response.getWriter();
			out.print(jsonStr);
			out.close();
		}
	}

}
