package in.co.rays.ors.TestModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import in.co.rays.ors.bean.SubjectBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.SubjectModel;

public class SubjectModelTest {


    public static SubjectModel model = new SubjectModel();

    /**
     * Main method to call test methods.
     * 
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
         testAdd();
        // testDelete();
        // testUpdate();
        // testFindByPK();
       //  testFindByEmailId();
       //  testSearch();
   //      testList();

    }

    /**
     * Tests add a Student
     * 
     * @throws ParseException
     */
    public static void testAdd() throws ParseException {

        try {
            SubjectBean bean = new SubjectBean();

            bean.setId(1L);
            bean.setSubjectName("c");
            bean.setDescription("basic computer lang");
            bean.setCourseId(1);
            bean.setCourseName("bca");
            bean.setCreatedBy("Admin");
            bean.setModifiedBy("Admin");
            bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
            bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
            System.out.println("add method call");
            long pk = model.add(bean);
           System.out.println("data enter");
        } catch (ApplicationException e) {
            e.printStackTrace();
        } catch (DuplicateRecordException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests delete a Student
     */
/*    public static void testDelete() {

        try {
            StudentBean bean = new StudentBean();
            long pk = 8L;
            bean.setId(pk);
            model.delete(bean);
            StudentBean deletedbean = model.findByPK(pk);
            if (deletedbean != null) {
                System.out.println("Test Delete fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    *//**
     * Tests update a Student
     *//*
    public static void testUpdate() {

        try {
            StudentBean bean = model.findByPK(9L);
           
            bean.setFirstName("ankit");
            bean.setLastName("sharma");
            model.update(bean);

            StudentBean updatedbean = model.findByPK(9L);
            if (!"ankit".equals(updatedbean.getFirstName())) {
                System.out.println("Test Update fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        } catch (DuplicateRecordException e) {
            e.printStackTrace();
        }
    }

    *//**
     * Tests find a Student by PK.
     *//*
    public static void testFindByPK() {
        try {
            StudentBean bean = new StudentBean();
            long pk = 1L;
            bean = model.findByPK(pk);
            if (bean == null) {
                System.out.println("Test Find By PK fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getFirstName());
            System.out.println(bean.getLastName());
            System.out.println(bean.getDob());
            System.out.println(bean.getMobileNo());
            System.out.println(bean.getEmail());
            System.out.println(bean.getCollegeId());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }

    *//**
     * Tests find a Student by Emailid.
     *//*
    public static void testFindByEmailId() {
        try {
            StudentBean bean = new StudentBean();
            bean = model.findByEmailId("mc@gmail.com");
            if (bean != null) {
                System.out.println("Test Find By EmailId fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getFirstName());
            System.out.println(bean.getLastName());
            System.out.println(bean.getDob());
            System.out.println(bean.getMobileNo());
            System.out.println(bean.getEmail());
            System.out.println(bean.getCollegeId());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    *//**
     * Tests get Search
     *//*
    public static void testSearch() {

        try {
            StudentBean bean = new StudentBean();
            List list = new ArrayList();
            bean.setFirstName("Amit");
            list = model.search(bean, 0, 0);
            if (list.size() < 0) {
                System.out.println("Test Serach fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (StudentBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getFirstName());
                System.out.println(bean.getLastName());
                System.out.println(bean.getDob());
                System.out.println(bean.getMobileNo());
                System.out.println(bean.getEmail());
                System.out.println(bean.getCollegeId());
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }

    *//**
     * Tests get List.
     *//*
    public static void testList() {

        try {
            StudentBean bean = new StudentBean();
            List list = new ArrayList();
            list = model.list(1, 10);
            if (list.size() < 0) {
                System.out.println("Test list fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (StudentBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getFirstName());
                System.out.println(bean.getLastName());
                System.out.println(bean.getDob());
                System.out.println(bean.getMobileNo());
                System.out.println(bean.getEmail());
                System.out.println(bean.getCollegeId());
                System.out.println(bean.getCreatedBy());
                System.out.println(bean.getCreatedDatetime());
                System.out.println(bean.getModifiedBy());
                System.out.println(bean.getModifiedDatetime());
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
        }
*/    }

