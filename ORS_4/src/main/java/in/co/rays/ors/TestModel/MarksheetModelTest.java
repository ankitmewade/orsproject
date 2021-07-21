package in.co.rays.ors.TestModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.ors.bean.MarksheetBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.MarksheetModel;

/**
 * Marksheet Model Test classes
 * 
 * @author SunilOS
 * @version 1.0
 * Copyright (c) SunilOS
 * 
 */
public class MarksheetModelTest {

    /**
     * Model object to test
     */

    public static MarksheetModel model = new MarksheetModel();

    /**
     * Main method to call test methods.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // testAdd();
        // testDelete();
         testUpdate();
       //  testFindByRollNo();
       //  testFindByPK();
        // testSearch();
       //  testMeritList();
       // testList();

    }

    /**
     * Tests add a Marksheet
     */
    public static void testAdd() {
        try {
            MarksheetBean bean = new MarksheetBean();
            
            bean.setRollNo("R8");
            bean.setPhysics(88);
            bean.setChemistry(77);
            bean.setMaths(99);
            bean.setStudentId(3L);
           System.out.println("model start");
            long pk = model.add(bean);
            System.out.println("add end");
            
            //MarksheetBean addedbean = model.findByPK(pk);
      /*
            System.out.println("pk end ");
            if (addedbean == null) {
                System.out.println("Test add fail");
            }
*/        } catch (ApplicationException e) {
            e.printStackTrace();
        } catch (DuplicateRecordException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests delete a Marksheet
     */
    public static void testDelete() {

        try {
            MarksheetBean bean = new MarksheetBean();
            long pk = 1L;
            bean.setId(pk);
            model.delete(bean);
            MarksheetBean deletedbean = model.findByPK(pk);
            if (deletedbean != null) {
                System.out.println("Test Delete fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests update a Marksheet
     */
    public static void testUpdate() {

        try {
            MarksheetBean bean = model.findByPK(3);
          
            bean.setStudentId(3L);
            bean.setRollNo("R3");
            bean.setChemistry(99);
            bean.setPhysics(99);;
            bean.setMaths(99);
            
            model.update(bean);

            /*MarksheetBean updatedbean = model.findByPK(1L);
            System.out.println("Test Update succ");
            
            if(!"Pooja Sharma".equals(updatedbean.getName())) {
                System.out.println("Test Update fail");
            }*/
        } catch (ApplicationException e) {
            e.printStackTrace();
        } catch (DuplicateRecordException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests find a marksheet by Roll No.
     */

    public static void testFindByRollNo() {

        try {
            MarksheetBean bean = model.findByRollNo("R2");
            if (bean == null) {
                System.out.println("Test Find By RollNo fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getRollNo());
            System.out.println(bean.getName());
            System.out.println(bean.getPhysics());
            System.out.println(bean.getChemistry());
            System.out.println(bean.getMaths());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests find a marksheet by PK.
     */
    public static void testFindByPK() {
        try {
            MarksheetBean bean = new MarksheetBean();
            long pk = 5L;
            bean = model.findByPK(pk);
            if (bean == null) {
                System.out.println("Test Find By PK fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getRollNo());
            System.out.println(bean.getName());
            System.out.println(bean.getPhysics());
            System.out.println(bean.getChemistry());
            System.out.println(bean.getMaths());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests search a Marksheets
     */

    public static void testSearch() {
        try {
            MarksheetBean bean = new MarksheetBean();
            List list = new ArrayList();
            bean.setName("Amit");
            list = model.search(bean, 1, 10);
            if (list.size() < 0) {
                System.out.println("Test Search fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (MarksheetBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getRollNo());
                System.out.println(bean.getName());
                System.out.println(bean.getPhysics());
                System.out.println(bean.getChemistry());
                System.out.println(bean.getMaths());
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests get the meritlist of Marksheets
     */
    public static void testMeritList() {
        try {
            MarksheetBean bean = new MarksheetBean();
            List list = new ArrayList();
            list = model.getMeritList(1, 5);
            if (list.size() < 0) {
                System.out.println("Test List fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (MarksheetBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getRollNo());
                System.out.println(bean.getName());
                System.out.println(bean.getPhysics());
                System.out.println(bean.getChemistry());
                System.out.println(bean.getMaths());
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests list of Marksheets
     */
    public static void testList() {
        try {
            MarksheetBean bean = new MarksheetBean();
            List list = new ArrayList();
            list = model.list(1, 6);
            if (list.size() < 0) {
                System.out.println("Test List fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (MarksheetBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getRollNo());
                System.out.println(bean.getName());
                System.out.println(bean.getPhysics());
                System.out.println(bean.getChemistry());
                System.out.println(bean.getMaths());
                System.out.println(bean.getCreatedBy());
                System.out.println(bean.getCreatedDatetime());
                System.out.println(bean.getModifiedBy());
                System.out.println(bean.getModifiedDatetime());
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }
}

