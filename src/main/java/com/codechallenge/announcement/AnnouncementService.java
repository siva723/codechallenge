package com.codechallenge.announcement;

import com.google.gson.Gson;
import com.mongodb.*;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author sivakumaran
 *
 */
public class AnnouncementService {

    private final DB db;
    private final DBCollection collection;

    public AnnouncementService(DB db) {
        this.db = db;
        this.collection = db.getCollection("announcement");
    }

    public List<Announcement> findAll() {
        List<Announcement> announcements = new ArrayList<>();
        
        DBCursor dbObjects = collection.find();
        announcements.add(new Announcement());
        
        while (dbObjects.hasNext()) {
            DBObject dbObject = dbObjects.next();
            announcements.add(new Announcement((BasicDBObject) dbObject));
        }
        return announcements;
    }

    public void createNewAnnouncement(String body) {
        Announcement announcement = new Gson().fromJson(body, Announcement.class);
        collection.insert(new BasicDBObject("title", announcement.getTitle()).append("done", announcement.isEdit()).append("startDate", new Date())
        		.append("expiryDate", new Date()));
    }

    public Announcement find(String id) {
        return new Announcement((BasicDBObject) collection.findOne(new BasicDBObject("id", new ObjectId(id))));
    }

    public Announcement update(String id, String body) {
        Announcement announcement = new Gson().fromJson(body, Announcement.class);
        collection.update(new BasicDBObject("id", new ObjectId(id)), new BasicDBObject("$set", new BasicDBObject("edit", announcement.isEdit())));
        return this.find(id);
    }
    
    public WriteResult delete(String id) {
        
    	return  collection.remove(new BasicDBObject("id", new ObjectId(id)));
    }
}
