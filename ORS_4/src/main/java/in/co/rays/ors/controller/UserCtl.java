package in.co.rays.ors.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.RoleBean;
import in.co.rays.ors.bean.UserBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.exception.RecordNotFoundException;
import in.co.rays.ors.model.RoleModel;
import in.co.rays.ors.model.UserModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;


/**
 * * User functionality Controller. Performs operation for add, update and get
 * User
 * 
 * @author SunilOS
 * @version 1.0
 * Copyright (c) SunilOS
 */
@ WebServlet(name="UserCtl",urlPatterns={"/ctl/UserCtl"})
public class UserCtl extends BaseCtl {

    private static final long serialVersionUID = 1L;

    private static Logger log = Logger.getLogger(UserCtl.class);

    @Override
    protected void preload(HttpServletRequest request) {
        RoleModel model = new RoleModel();
       
        try {
           List rlist = model.list();
            request.setAttribute("roleList", rlist);
        } catch (ApplicationException e) {
            log.error(e);
            e.printStackTrace();
        }

    }

    @Override
    protected boolean validate(HttpServletRequest request) {

        log.debug("UserCtl Method validate Started");
        boolean pass = true;

        long id = DataUtility.getInt(request.getParameter("id"));
        
        String login = request.getParameter("login");
        String dob = request.getParameter("dob");

        if (DataValidator.isNull(request.getParameter("firstName"))) {
            request.setAttribute("firstName",PropertyReader.getValue("error.require", "First Name"));
            pass = false;
        }else if (!DataValidator.isValidName(request.getParameter("firstName"))) {
        	request.setAttribute("firstName",PropertyReader.getValue("error.name", "Invalid First"));
            pass = false;
		}

        if (DataValidator.isNull(request.getParameter("lastName"))) {
            request.setAttribute("lastName",PropertyReader.getValue("error.require", "Last Name"));
            pass = false;
        }else if (!DataValidator.isValidName(request.getParameter("lastName"))) {
            request.setAttribute("lastName",PropertyReader.getValue("error.name", "Invalid Last"));
            pass = false;
        }
        if (DataValidator.isNull(login)) {
            request.setAttribute("login",PropertyReader.getValue("error.require", "Login Id"));
            pass = false;
        } else if (!DataValidator.isEmail(login)) {
            request.setAttribute("login",PropertyReader.getValue("error.email", "Invalid "));
            pass = false;
        }

        if (DataValidator.isNull(request.getParameter("password"))) {
            request.setAttribute("password",PropertyReader.getValue("error.require", "Password"));
            pass = false;
        }else if (!DataValidator.isPassword(request.getParameter("password"))) {
        	request.setAttribute("password","Password should contain 8 letter with alpha-numeric and special Character"
);
            pass = false;
		}

        if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
            request.setAttribute("confirmPassword", PropertyReader.getValue("error.require", "Confirm Password"));
            pass = false;
        }
        if (DataValidator.isNull(request.getParameter("mobileno"))) {
			request.setAttribute("mobileno", PropertyReader.getValue("error.require","Mobile No"));
			pass = false ;
        }else if (!DataValidator.isMobileNo(request.getParameter("mobileno"))) {
        	request.setAttribute("mobileno","Mobile No. must be 10 Digit and No. Series start with 6-9"
);
			pass = false ;
		}
        
        
        if (DataValidator.isNull(request.getParameter("rolename"))) {
			request.setAttribute("rolename", PropertyReader.getValue("error.require"," Role ID"));
			pass = false ;
        }

        if (DataValidator.isNull(request.getParameter("gender"))) {
            request.setAttribute("gender",PropertyReader.getValue("error.require", "Gender"));
            pass = false;
        }
        if (DataValidator.isNull(dob)) {
            request.setAttribute("dob",PropertyReader.getValue("error.require", "Date Of Birth"));
            pass = false;
        } else if (!DataValidator.isvalidateAge(dob)) {
            request.setAttribute("dob", PropertyReader.getValue("error.require", "Maximum Age 18 year"));
            pass = false;
        }
        if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))
                && !"".equals(request.getParameter("confirmPassword"))) {
        	request.setAttribute("confirmPassword", PropertyReader.getValue("error.confirmpassword", "Password and Correct Password"));
             pass = false;
        }
        log.debug("UserCtl Method validate Ended");
        return pass;
    }

    @Override
    protected BaseBean populateBean(HttpServletRequest request) {

        log.debug("UserCtl Method populatebean Started");
        UserBean bean = new UserBean();
        long id = DataUtility.getInt(request.getParameter("id"));
        
        bean.setId(DataUtility.getLong(request.getParameter("id")));
        bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
        bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
        bean.setLogin(DataUtility.getString(request.getParameter("login")));
        bean.setPassword(DataUtility.getString(request.getParameter("password")));
        bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
        bean.setGender(DataUtility.getString(request.getParameter("gender")));
        bean.setDob(DataUtility.getDate(request.getParameter("dob")));
        bean.setMobileNo(DataUtility.getString(request.getParameter("mobileno")));
        
        bean.setRoleId(DataUtility.getLong(request.getParameter("rolename")));
        
        populateDTO(bean, request);
        log.debug("UserCtl Method populatebean Ended");
        return bean;
    }
    /**
     * Contains Display logics
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.debug("UserCtl Method doGet Started");

        String op = DataUtility.getString(request.getParameter("operation"));
        long id = DataUtility.getLong(request.getParameter("id"));
        
        UserModel model = new UserModel();
        
        if (id > 0 || op != null) {
      //      System.out.println("in id > 0  condition");
            UserBean bean;
            try {
                bean = model.findByPK(id);
                ServletUtility.setBean(bean, request);
            } catch (ApplicationException e) {
                log.error(e);
                ServletUtility.handleException(e, request, response);
                return;
            }
        }

        ServletUtility.forward(getView(), request, response);
        log.debug("UserCtl Method doGet Ended");
    }

    /**
     * Contains Submit logics
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.debug("UserCtl Method doPost Started");
       
        String op = DataUtility.getString(request.getParameter("operation"));
          long id = DataUtility.getLong(request.getParameter("id"));
        
        UserModel model = new UserModel();
   
        if (OP_SAVE.equalsIgnoreCase(op)||OP_UPDATE.equalsIgnoreCase(op)) {
        	UserBean bean = (UserBean) populateBean(request);

            try {
                if (id > 0) {
                    model.update(bean);
                } else {
                    long pk = model.add(bean);
              //    bean.setId(pk);
                }
                ServletUtility.setBean(bean, request);
                ServletUtility.setSuccessMessage("User is successfully saved",request);
            } catch (ApplicationException e) {
                log.error(e);
                ServletUtility.handleException(e, request, response);
                return;
            } catch (DuplicateRecordException e) {
                ServletUtility.setBean(bean, request);
                ServletUtility.setErrorMessage("Login id already exists",request);
            } catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
                return;
			}
        }
        	else if ( OP_RESET.equalsIgnoreCase(op) ) {
            ServletUtility.redirect(ORSView.USER_CTL, request, response);
            return;
        }
        	else if (OP_CANCEL.equalsIgnoreCase(op) || OP_BACK.equalsIgnoreCase(op)) {
                ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
                return;
            }
      
        ServletUtility.forward(getView(), request, response);
        log.debug("UserCtl Method doPostEnded");
    }

    @Override
    protected String getView() {
        return ORSView.USER_VIEW;
    }

}
