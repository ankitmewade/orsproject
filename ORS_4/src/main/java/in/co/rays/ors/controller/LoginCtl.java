package in.co.rays.ors.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.RoleBean;
import in.co.rays.ors.bean.UserBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.model.RoleModel;
import in.co.rays.ors.model.UserModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;

/**
 * Login functionality Controller. Performs operation for Login
 * 
 * @author SunilOS
 * @version 1.0 Copyright (c) SunilOS
 */

@WebServlet(name = "LoginCtl", urlPatterns = { "/LoginCtl" })
public class LoginCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	public static final String OP_REGISTER = "Register";
	public static final String OP_SIGN_IN = "SignIn";
	public static final String OP_SIGN_UP = "SignUp";
	public static final String OP_LOG_OUT = "Logout";

	private static Logger log = Logger.getLogger(LoginCtl.class);

	public LoginCtl() {

	}

	
	@Override
	protected boolean validate(HttpServletRequest request) {
		log.debug("LoginCtl Method validate Started");
		boolean pass = true;
	
		String op = request.getParameter("operation");
		if (OP_SIGN_UP.equals(op) || OP_LOG_OUT.equals(op)) {
			System.out.println("signup or logout");
			return pass;
		}
		
		
		String login = request.getParameter("login");
		if (DataValidator.isNull(login)) {
			System.out.println("login checks");
			log.debug("checkk");

			request.setAttribute("login", PropertyReader.getValue("error.require", "LoginId"));
			pass = false;
		} else if (!DataValidator.isEmail(login)) {
			log.debug("checkk");

			request.setAttribute("login", PropertyReader.getValue("error.email", "Invalid "));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("password"))) {
			log.debug("checkk");

			request.setAttribute("password", PropertyReader.getValue("error.require", "Password"));
			pass = false;
		} /*
		else if (!DataValidator.isPassword(request.getParameter("password"))) {
			  request.setAttribute("password","Password should contain 8 letter with alpha-numeric and special Character");
			  pass = false; 
			  }*/
			 
		log.debug("LoginCtl Method validate Ended");
	
		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("LoginCtl Method populatebean Started");
		UserBean bean = new UserBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		log.debug("LoginCtl Method populatebean Ended");
		
		populateDTO(bean, request);
		
		return bean;
		
	}

	/**
	 * Display Login form
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.debug(" Method doGet Started");

		HttpSession session = request.getSession(false);
		String op = DataUtility.getString(request.getParameter("operation"));

		if (OP_LOG_OUT.equals(op)) {

			session.invalidate();
			ServletUtility.setSuccessMessage("User Logout Succesfully", request);
			ServletUtility.forward(getView(), request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("LoginCtl Method doGet Ended");

	}

	/**
	 * Contains Submit logics
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug(" Login Ctl Method doPost Started");

		HttpSession session = request.getSession();
		
		if(session!=null){
			System.out.println("session created, doPost()");
		}else{
			System.out.println("session not created");
		}
		
		
		String op = DataUtility.getString(request.getParameter("operation"));

		// get model
		UserModel model = new UserModel();
		RoleModel role = new RoleModel();

		// long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SIGN_IN.equalsIgnoreCase(op)) {
			UserBean bean = (UserBean) populateBean(request);

		
			try {
				bean = model.authenticate(bean.getLogin(), bean.getPassword());
				ServletUtility.setBean(bean, request);

				if (bean != null) {
					session.setAttribute("user", bean);
					long rollId = bean.getRoleId();
					RoleBean rolebean = role.findByPK(rollId);

					if (rolebean != null) {
						session.setAttribute("role", rolebean.getName());
					}

					// Code of The URI
					String str = (String) session.getAttribute("URI");
					if (str == null || "null".equalsIgnoreCase(str)) {
						ServletUtility.redirect(ORSView.WELCOME_CTL, request, response);
						return;
					} else {
						ServletUtility.redirect(str, request, response);
						return;
					}
				} else {
					 bean = (UserBean) populateBean(request);
					 ServletUtility.setBean(bean, request);
					ServletUtility.setErrorMessage("Invalid LoginId And Password", request);
				
				}
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		} else if (OP_SIGN_UP.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.USER_REGISTRATION_CTL, request, response);
			return;
		}

		// ServletUtility.setBean(bean, request);
		log.debug("loginCtl Method doPost Ended");
		ServletUtility.forward(getView(), request, response);
		
	}

	@Override
	protected String getView() {
		return ORSView.LOGIN_VIEW;
	}
}
