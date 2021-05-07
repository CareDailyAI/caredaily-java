package com.peoplepowerco.virtuoso.models.communities;

import io.realm.RealmObject;

public class PPPostReactionModel extends RealmObject {

    public int reaction;
    public String postId;
    public String commentId;
    public PPPostUserModel user;
}
