package in.co.rays.ors.TestModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.ors.bean.CollegeBean;
import in.co.rays.ors.bean.FacultyBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.CollegeModel;
import in.co.rays.ors.model.FacultyModel;

/**
 * College Model Test classes
 * 
 * @author SunilOS
 * @version 1.0
 * Copyright (c) SunilOS
 * 
 */
public class FacultyModelTest {

	/**
	 * Model object to test
	 */
	public static FacultyModel model = new FacultyModel();

	/**
	 * Main method to call test methods.
	 * 
	 * @param args
	 * @throws DuplicateRecordException
	 */
	public static void main(String[] args) throws DuplicateRecordException {
	//	 testAdd();
	//	 testDelete();
	//	 testUpdate();
	//	 testFindByName();
	//	 testFindByPK();
		 testSearch();
	//	testList();

	}

	/**
	 * Tests add a College
	 * 
	 * @throws DuplicateRecordException
	 */
	public static void testAdd() throws DuplicateRecordException {

		try {
			FacultyBean bean = new FacultyBean();
			bean.setFirstName("Amit");;
			bean.setLastName("Pal");;
			bean.setGender("Male");
			
			bean.setQualification("Mba");
			bean.setLoginId("ap@gmail.com");
			bean.setMobileno("888888");
			bean.setCollegeid(1);
			bean.setCollegeName("abc");
			bean.setCourseId(2);
			bean.setCourseName("xyz");
			bean.setSubjectId(4);
			bean.setSubjectName("marketing");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.add(bean);
			System.out.println("Test add succ");
	
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests delete a College
	 */
/*
	public static void testDelete() {

		try {
			CollegeBean bean = new CollegeBean();
			long pk = 7L;
			bean.setId(pk);
	//		model.delete(bean);
			System.out.println("Test Delete succ");
	//		CollegeBean deletedBean = model.findByPK(pk);
		//	if (deletedBean != null) {
				System.out.println("Test Delete fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Tests update a College
	 */
/*	public static void testUpdate() {

		try {
	//		CollegeBean bean = model.findByPK(3L);
//			bean.setName("Vikram University");
	//		bean.setAddress("Ujjain");
		//	model.update(bean);
			System.out.println("Test Update succ");
			CollegeBean updateBean = model.findByPK(3L);
			if (!"Vikram University".equals(updateBean.getName())) {
				System.out.println("Test Update fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Tests find a College by Name.
	 */

/*	public static void testFindByName() {

		try {
			CollegeBean bean = model.findByName("Vikram university");
			if (bean == null) {
				System.out.println("Test Find By Name fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getState());
			System.out.println(bean.getCity());
			System.out.println(bean.getPhoneNo());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}
*/
	/**
	 * Tests find a College by PK.
	 */
/*	public static void testFindByPK() {
		try {
			CollegeBean bean = new CollegeBean();
			long pk = 2L;
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getState());
			System.out.println(bean.getCity());
			System.out.println(bean.getPhoneNo());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}
*/
	/**
	 * Tests search a College by Name
	 */

	public static void testSearch() {
		try {
			FacultyBean bean = new FacultyBean();
			List list = new ArrayList();
		//	bean.setName("LNCT");
			 bean.setFirstName("nikita");
			list = model.search(bean, 1, 10);
			if (list.size() < 0) {
				System.out.println("Test Search fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (FacultyBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLoginId());
				System.out.println(bean.getQualification());
				System.out.println(bean.getMobileno());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests get List a College.
	 */
/*	public static void testList() {

		try {
			CollegeBean bean = new CollegeBean();
			List list = new ArrayList();
			list = model.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (CollegeBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getAddress());
				System.out.println(bean.getState());
				System.out.println(bean.getCity());
				System.out.println(bean.getPhoneNo());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
*/
}
