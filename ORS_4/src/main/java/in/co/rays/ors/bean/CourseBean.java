package in.co.rays.ors.bean;

/**
 * Course JavaBean encapsulates Course attributes
 * 
 * @author SunilOS
 * @version 1.0
 * Copyright (c) SunilOS
 * 
 */
public class CourseBean extends BaseBean{

    /**
     * Name of Course
     */
	private String name;

    /**
     * Description of Course
     */
	private String description;

    /**
     * Duration of Course
     */
	
	private String duration;
	

    /**
     * Getter and Setter of Course
     */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}


    public String getKey() {
        return id+"";
    }

   
    public String getValue() {
        return name;
    }
	
}
