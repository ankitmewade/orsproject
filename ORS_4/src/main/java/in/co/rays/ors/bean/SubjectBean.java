package in.co.rays.ors.bean;


/**
 * Subject JavaBean encapsulates Subject attributes
 * 
 * @author SunilOS
 * @version 1.0
 * Copyright (c) SunilOS
 * 
 */
public class SubjectBean extends BaseBean {


	/**
     * Name of Subject
     */
	private String subjectName;

	/**
     * Description of Subject
     */
	private String description;

    /**
     * CourseId of Subject
     */
	private long courseId;

    /**
     * Course Name of Subject
     */
	private String courseName;


    /**
     * Getter and Setter of Subject
     */

    public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

    public String getKey() {
        return id + "";
    }

   
    public String getValue() {
        return subjectName;
    }
}
