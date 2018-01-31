package larc.rabittmq.obj;

import java.util.List;

public class Post {
	private String title;
	private String creationTime;
	private Long creationTimeInMilli;
	private String postedBy;
	private String postUrl;
	private List<String> media;
	private Comments comments;
	private String likeDislikeCount;
	private String sharedCount;
	private Reactions reaction;
	private String postId;
	private String postLikedUserPageUrl;
	private String postedByUserProfileUrl;
	private String link;
	private  List<F4JPostLikedUser> postLikedUsers;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public Long getCreationTimeInMilli() {
		return creationTimeInMilli;
	}
	public void setCreationTimeInMilli(Long creationTimeInMilli) {
		this.creationTimeInMilli = creationTimeInMilli;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getPostUrl() {
		return postUrl;
	}
	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}
	public List<String> getMedia() {
		return media;
	}
	public void setMedia(List<String> media) {
		this.media = media;
	}
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	public String getLikeDislikeCount() {
		return likeDislikeCount;
	}
	public void setLikeDislikeCount(String likeDislikeCount) {
		this.likeDislikeCount = likeDislikeCount;
	}
	public String getSharedCount() {
		return sharedCount;
	}
	public void setSharedCount(String sharedCount) {
		this.sharedCount = sharedCount;
	}
	public Reactions getReaction() {
		return reaction;
	}
	public void setReaction(Reactions reaction) {
		this.reaction = reaction;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPostLikedUserPageUrl() {
		return postLikedUserPageUrl;
	}
	public void setPostLikedUserPageUrl(String postLikedUserPageUrl) {
		this.postLikedUserPageUrl = postLikedUserPageUrl;
	}
	public String getPostedByUserProfileUrl() {
		return postedByUserProfileUrl;
	}
	public void setPostedByUserProfileUrl(String postedByUserProfileUrl) {
		this.postedByUserProfileUrl = postedByUserProfileUrl;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<F4JPostLikedUser> getPostLikedUsers() {
		return postLikedUsers;
	}
	public void setPostLikedUsers(List<F4JPostLikedUser> postLikedUsers) {
		this.postLikedUsers = postLikedUsers;
	}
	@Override
	public String toString() {
		return "Post [title=" + title + ", creationTime=" + creationTime + ", creationTimeInMilli="
				+ creationTimeInMilli + ", postedBy=" + postedBy + ", postUrl=" + postUrl + ", media=" + media
				+ ", comments=" + comments + ", likeDislikeCount=" + likeDislikeCount + ", sharedCount=" + sharedCount
				+ ", reaction=" + reaction + ", postId=" + postId + ", postLikedUserPageUrl=" + postLikedUserPageUrl
				+ ", postedByUserProfileUrl=" + postedByUserProfileUrl + ", link=" + link + ", postLikedUsers="
				+ postLikedUsers + "]";
	}
	
}
