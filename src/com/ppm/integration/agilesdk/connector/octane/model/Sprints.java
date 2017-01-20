package com.ppm.integration.agilesdk.connector.octane.model;

import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by lutian on 2016/11/28.
 */
public class Sprints extends SimpleEntityCollection<Sprint> {

    public List<Sprint> getCollection() {
        return super.getCollection();
    }

    public void SetCollection(String data) {

        JSONObject object = JSONObject.fromObject(data);
        JSONArray jsonarray = (JSONArray)(object.get("data"));
        for (int i = 0, length = jsonarray.size(); i < length; i++) {
            JSONObject tempObj = jsonarray.getJSONObject(i);
            Sprint tempSprint = new Sprint();
            tempSprint.id = (String)tempObj.get("id");
            tempSprint.name = (String)tempObj.get("name");
            tempSprint.releaseId = WorkItem.getSubObjectItem("release", "id", tempObj);
            super.add(tempSprint);
        }
    }
}