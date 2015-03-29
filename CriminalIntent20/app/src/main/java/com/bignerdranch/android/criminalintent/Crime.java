package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class Crime {

    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_DATE = "date";
    private static final String JSON_SOLVED = "solved";
    private static final String JSON_PHOTO = "photo";
    private static final String JSON_PHOTO1 = "photo1";
    private static final String JSON_PHOTO2 = "photo2";
    private static final String JSON_PHOTO3 = "photo3";
    
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private Photo mPhoto;
    private Photo prevPhoto1;
    private Photo prevPhoto2;
    private Photo prevPhoto3;
    
    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Crime(JSONObject json) throws JSONException {
        mId = UUID.fromString(json.getString(JSON_ID));
        mTitle = json.getString(JSON_TITLE);
        mSolved = json.getBoolean(JSON_SOLVED);
        mDate = new Date(json.getLong(JSON_DATE));
        if (json.has(JSON_PHOTO))
            mPhoto = new Photo(json.getJSONObject(JSON_PHOTO));
        if (json.has(JSON_PHOTO1))
            prevPhoto1 = new Photo(json.getJSONObject(JSON_PHOTO1));
        if (json.has(JSON_PHOTO2))
            prevPhoto2 = new Photo(json.getJSONObject(JSON_PHOTO2));
        if (json.has(JSON_PHOTO3))
            prevPhoto3 = new Photo(json.getJSONObject(JSON_PHOTO3));
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, mId.toString());
        json.put(JSON_TITLE, mTitle);
        json.put(JSON_SOLVED, mSolved);
        json.put(JSON_DATE, mDate.getTime());
        if (mPhoto != null)
            json.put(JSON_PHOTO, mPhoto.toJSON());
        if (prevPhoto1 != null)
            json.put(JSON_PHOTO1, prevPhoto1.toJSON());
        if (prevPhoto2 != null)
            json.put(JSON_PHOTO2, prevPhoto2.toJSON());
        if (prevPhoto3 != null)
            json.put(JSON_PHOTO3, prevPhoto3.toJSON());
        return json;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

	public Photo getPhoto() {return mPhoto; }

	public void setPhoto(Photo photo) {mPhoto = photo; }

    public Photo getPrevPhoto1() {return prevPhoto1; }

    public void setPrevPhoto1(Photo photo) {prevPhoto1 = photo; }

    public Photo getPrevPhoto2() {return prevPhoto2; }

    public void setPrevPhoto2(Photo photo) {prevPhoto2 = photo; }

    public Photo getPrevPhoto3() {return prevPhoto3; }

    public void setPrevPhoto3(Photo photo) {prevPhoto3 = photo; }
}
