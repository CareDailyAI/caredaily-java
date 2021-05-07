package com.peoplepowerco.virtuoso.models;


import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import java.util.List;

public class PPDeviceGoalsModel extends RealmObject {

    public int id;
    public int deviceType;
    public int nWeight;
    public String sName;
    public String sIcon;
    public String sIconFont;
    public String sDesc;
    public RealmList<String> suggestionList = new RealmList<>();
    public RealmList<String> spaceList = new RealmList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return sName;
    }

    public String getDesc() {
        return sDesc;
    }

    public String getIcon() {
        return sIcon;
    }

    public String getIconFont() {
        return sIconFont;
    }

    public int getWeight() {
        return nWeight;
    }

    public List<String> getSuggestionList() {
        return suggestionList;
    }

    public static List<PPDeviceGoalsModel> getGoals(Realm realm, int deviceType) {
        return realm.where(PPDeviceGoalsModel.class).equalTo("deviceType", deviceType).findAll();
    }

    public static List<String> getSuggestions(Realm realm, int id, int deviceType) {
        PPDeviceGoalsModel goal = realm.where(PPDeviceGoalsModel.class).equalTo("id", id)
            .and().equalTo("deviceType", deviceType).findFirst();
        if (null != goal) {
            return goal.suggestionList;
        }
        return null;
    }

    public static List<String> getSuggestSpaces(Realm realm, int deviceType) {
        PPDeviceGoalsModel goal = realm.where(PPDeviceGoalsModel.class).equalTo("deviceType", deviceType)
            .findFirst();
        if (null != goal) {
            return goal.spaceList;
        }
        return null;
    }

    public static List<String> getSuggestSpaces(Realm realm, int goalId, int deviceType) {
        PPDeviceGoalsModel goal = realm.where(PPDeviceGoalsModel.class)
            .beginGroup()
            .equalTo("id", goalId)
            .and()
            .equalTo("deviceType", deviceType)
            .endGroup()
            .findFirst();
        if (null != goal) {
            return goal.spaceList;
        }
        return null;
    }
}
