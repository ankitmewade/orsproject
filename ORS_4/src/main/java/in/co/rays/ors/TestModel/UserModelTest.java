package in.co.rays.ors.TestModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.ors.bean.UserBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.UserModel;

/**
 * User Model Test classes
 * 
 * @author SunilOS
 * @version 1.0
 * Copyright (c) SunilOS
 * 
 */
public class UserModelTest {

	/**
	 * Model object to test
	 */

	public static UserModel model = new UserModel();

	/**
	 * Main method to call test methods.
	 * 
	 * @param args
	 * @throws ParseException
	 * @throws DuplicateRecordException
	 */
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException, ParseException {
		 testadd();
		// testupdate();
		// testfindByPK();
		// testfindBylogin();
		// testsearch();
		// testGetRoles();
		// testlist();
//		testauthenticate();
		// testregisterUser(); mail
		// testchangePassword(); mail
		// testforgetPassword(); mail
		// testresetPassword(); mail

	}

	private static void testadd() throws ApplicationException, DuplicateRecordException, ParseException {

		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		bean.setId(8);
		bean.setFirstName("Ajay");
		bean.setLastName("Surana");
		bean.setLogin("Aj@gmail.com");
		bean.setDob(sdf.parse("03-12-1989"));
		bean.setPassword("4321");
		bean.setMobileNo("224433");
		bean.setRoleId(3);

	//	model.add(bean);
		System.out.println("data intered");

	}

	private static void testupdate() throws ParseException, ApplicationException, DuplicateRecordException {

		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		bean.setId(7);
		bean.setLogin("svv@gmail.com");
		bean.setFirstName("Sandhaya");
		bean.setLastName("Pandey");

		bean.setPassword("34521");
		bean.setDob(sdf.parse("12-03-1980"));
		bean.setMobileNo("555555");
		bean.setRoleId(3);

//		model.update(bean);
		System.out.println("updated");
	}

	/**
	 * Tests find a User by PK.
	 * 
	 * @throws ApplicationException
	 */
	public static void testfindByPK() throws ApplicationException {
		UserBean bean = new UserBean();
		long pk = 6l;
		bean = model.findByPK(pk);

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getRoleId());
		System.out.println(bean.getUnSuccessfulLogin());
		System.out.println(bean.getGender());
		System.out.println(bean.getLastLogin());
		System.out.println(bean.getLock());
	}

	public static void testfindBylogin() throws ApplicationException {
		UserBean bean = new UserBean();
		String l = "kk@gmail.com";
	//	bean = model.findByLogin(l);

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getRoleId());
		System.out.println(bean.getUnSuccessfulLogin());
		System.out.println(bean.getGender());
		System.out.println(bean.getLastLogin());
		System.out.println(bean.getLock());
	}

	private static void testsearch() throws ApplicationException {
		UserBean bean = new UserBean();
		List list = new ArrayList();
		bean.setFirstName("Amit");
		list = model.search(bean, 0, 0);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		}
	}

/*	private static void testGetRoles() throws ApplicationException {

		UserBean bean = new UserBean();
		List list = new ArrayList();
		bean.setRoleId(3);
		list = model.getRoles(bean);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		}
	}
*/
	private static void testlist() throws ApplicationException {
		UserBean bean = new UserBean();
		List list = new ArrayList();
		list = model.list(0, 0);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		}
	}

	private static void testauthenticate() throws ApplicationException {
		UserBean bean = new UserBean();
		bean.setLogin("k@gmail.com");
		bean.setPassword("12345");
		bean = model.authenticate(bean.getLogin(), bean.getPassword());
		if (bean != null) {
			System.out.println("Successful login");
		} else {
			System.out.println("login id is wrong ");
		}

	}

}
