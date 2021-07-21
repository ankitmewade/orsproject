package in.co.rays.ors.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.StudentBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.CollegeModel;
import in.co.rays.ors.model.StudentModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;

/**
 * Student functionality Controller. Performs operation for add, update, delete
 * and get Student
 * 
 * @author SunilOS
 * @version 1.0
 * Copyright (c) SunilOS
 */
@ WebServlet(name="StudentCtl", urlPatterns = {"/ctl/StudentCtl"})
public class StudentCtl extends BaseCtl {

    private static Logger log = Logger.getLogger(StudentCtl.class);

    @Override
    protected void preload(HttpServletRequest request) {
        CollegeModel model = new CollegeModel();
        try {
            List l = model.list();
            request.setAttribute("collegeList", l);
        } catch (ApplicationException e) {
            log.error(e);
        }

    }

    @Override
    protected boolean validate(HttpServletRequest request) {
    	System.out.println("validate started ... std ctl");
        log.debug("StudentCtl Method validate Started");
        boolean pass = true;

        if (DataValidator.isNull(request.getParameter("firstname"))) {
            request.setAttribute("firstname",PropertyReader.getValue("error.require", "First Name"));
            pass = false;
        }else if (!DataValidator.isValidName(request.getParameter("firstname"))) {
        	  request.setAttribute("firstname",PropertyReader.getValue("error.name", "Invalid First"));
              pass = false;
		}
        if (DataValidator.isNull(request.getParameter("lastname"))) {
            request.setAttribute("lastname",PropertyReader.getValue("error.require", "Last Name"));
            pass = false;
        }else if (!DataValidator.isValidName(request.getParameter("lastname"))) {
      	  request.setAttribute("lastname",PropertyReader.getValue("error.name", "Invalid Last"));
          pass = false;
	}
        if (DataValidator.isNull(request.getParameter("mobile"))) {
            request.setAttribute("mobile", PropertyReader.getValue("error.require", "Mobile No"));
            pass = false;
        }else if (!DataValidator.isMobileNo(request.getParameter("mobile"))) {
      	  request.setAttribute("mobile", "Mobile No. must be 10 Digit and No. Series start with 6-9");
          pass = false;
	}
        if (DataValidator.isNull(request.getParameter("email"))) {
            request.setAttribute("email", PropertyReader.getValue("error.require", "Email "));
            pass = false;
        } else if (!DataValidator.isEmail(request.getParameter("email"))) {
            request.setAttribute("email", PropertyReader.getValue("error.email", "Invalid "));
            pass = false;
        }
        if (DataValidator.isNull(request.getParameter("dob"))) {
            request.setAttribute("dob", PropertyReader.getValue("error.require", "Date Of Birth"));
            pass = false;
        }else if (!DataValidator.isvalidateAge(request.getParameter("dob"))) {
                request.setAttribute("dob", "Student Age must be Greater then 18 year ");
                pass = false;
            }  
        
        if (DataValidator.isNull(request.getParameter("collegename"))) {
            request.setAttribute("collegename", PropertyReader.getValue("error.require", "College Name"));
            pass = false;
        } 
        System.out.println("validate over ,.... Student ctl");
        log.debug("StudentCtl Method validate Ended");
        return pass;
    }

    @Override
    protected BaseBean populateBean(HttpServletRequest request) {

        log.debug("StudentCtl Method populatebean Started");

        StudentBean bean = new StudentBean();

        bean.setId(DataUtility.getLong(request.getParameter("id")));
        bean.setFirstName(DataUtility.getString(request.getParameter("firstname")));
        bean.setLastName(DataUtility.getString(request.getParameter("lastname")));
        bean.setDob(DataUtility.getDate(request.getParameter("dob")));
        bean.setMobileNo(DataUtility.getString(request.getParameter("mobile")));
        bean.setEmail(DataUtility.getString(request.getParameter("email")));
        bean.setCollegeId(DataUtility.getLong(request.getParameter("collegename")));
        populateDTO(bean, request);
        log.debug("StudentCtl Method populatebean Ended");
        return bean;
    }

    /**
     * Contains Display logics
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        log.debug("StudentCtl Method doGet Started");

        String op = DataUtility.getString(request.getParameter("operation"));
        long id = DataUtility.getLong(request.getParameter("id"));

        // get model

        StudentModel model = new StudentModel();
        if (id > 0 || op != null) {
            StudentBean bean;
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
        log.debug("StudentCtl Method doGett Ended");
    }

    /**
     * Contains Submit logics
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        log.debug("StudentCtl Method doPost Started");

        String op = DataUtility.getString(request.getParameter("operation"));

        long id = DataUtility.getLong(request.getParameter("id"));
        // get model

        StudentModel model = new StudentModel();

        if (OP_SAVE.equalsIgnoreCase(op)|| OP_UPDATE.equalsIgnoreCase(op)) {
            StudentBean bean = (StudentBean) populateBean(request);
            try {
                if (id > 0) {
                    model.update(bean);
                } else {
                    long pk = model.add(bean);
             //      bean.setId(pk);
                }
                ServletUtility.setBean(bean, request);
                ServletUtility.setSuccessMessage(" Student is successfully saved",request);
            } catch (ApplicationException e) {
                log.error(e);
                ServletUtility.handleException(e, request, response);
                return;
            
            } catch (DuplicateRecordException e) {
                ServletUtility.setBean(bean, request);
                ServletUtility.setErrorMessage("Student Email Id already exists", request);
            }
        } 
        else if ( OP_RESET.equalsIgnoreCase(op)) {
            
         	ServletUtility.redirect(ORSView.STUDENT_CTL, request, response);
             return;
         }
        else if (OP_CANCEL.equalsIgnoreCase(op) ) {
            
         	ServletUtility.redirect(ORSView.STUDENT_LIST_CTL, request, response);
             return;
         }
/*
        else if (OP_DELETE.equalsIgnoreCase(op)) {

            StudentBean bean = (StudentBean) populateBean(request);
            try {
                model.delete(bean);
                ServletUtility.redirect(ORSView.STUDENT_CTL, request, response);
                return;

            } catch (ApplicationException e) {
                log.error(e);
                ServletUtility.handleException(e, request, response);
                return;
            }
        }
*/        ServletUtility.forward(getView(), request, response);

        log.debug("StudentCtl Method doPost Ended");
    }

    @Override
    protected String getView() {
        return ORSView.STUDENT_VIEW;
    }

}
