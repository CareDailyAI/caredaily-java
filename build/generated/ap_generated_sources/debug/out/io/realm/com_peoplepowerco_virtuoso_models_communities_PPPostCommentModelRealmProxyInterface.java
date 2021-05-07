package io.realm;


public interface com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxyInterface {
    public String realmGet$commentId();
    public void realmSet$commentId(String value);
    public String realmGet$postId();
    public void realmSet$postId(String value);
    public String realmGet$replyCommentId();
    public void realmSet$replyCommentId(String value);
    public long realmGet$commentDateMs();
    public void realmSet$commentDateMs(long value);
    public String realmGet$commentText();
    public void realmSet$commentText(String value);
    public com.peoplepowerco.virtuoso.models.communities.PPPostUserModel realmGet$user();
    public void realmSet$user(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel value);
    public RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> realmGet$reactions();
    public void realmSet$reactions(RealmList<com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel> value);
}
