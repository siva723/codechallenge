package com.codechallenge.announcement;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;
import java.util.Date;

/**
 * 
 * @author sivakumaran
 *
 */
public class Announcement {

	private String id;
	private String title;
	private String body;
	private boolean edit;
	private boolean delete;
	private Date startDate = new Date();
	private Date expiryDate = new Date();
	
	/**
	 * Testing constructor
	 */
	public Announcement() {
		this.id = "TestID";
		this.title = "TEST TITLE";
		this.body = "TEST ANNOUNCEMENT";
		this.edit = false;
		this.delete = false;
		this.startDate = new Date();
		this.startDate = new Date();
	}

	public Announcement(BasicDBObject dbObject) {
		this.id = ((ObjectId) dbObject.get("_id")).toString();
		this.title = dbObject.getString("title");
		this.body = dbObject.getString("body");
		this.edit = dbObject.getBoolean("edit");
		this.delete = dbObject.getBoolean("delete");
		this.startDate = dbObject.getDate("startDate");
		this.startDate = dbObject.getDate("expiryDate");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

}
