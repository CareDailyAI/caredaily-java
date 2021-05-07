package com.peoplepowerco.virtuoso.models.communities;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PPPostCommentModel extends RealmObject {

    @PrimaryKey
    public String commentId;
    public String postId;
    public String replyCommentId;
    public long commentDateMs;
    public String commentText;

    public PPPostUserModel user;
    public RealmList<PPPostReactionModel> reactions = new RealmList<>();
}
