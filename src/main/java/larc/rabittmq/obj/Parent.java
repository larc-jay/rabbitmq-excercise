package larc.rabittmq.obj;

import java.util.List;


public class Parent {
	private Intro intro;
	private String accountTypes;
	private String screenName;
	private String screenNameUrl;
	private String name;
	private String profileUrl;
	private String profileImagelUrl;
	private String profileThumbnailUrl;
	private long postCount;
	private List<Post> allposts;
	public Intro getIntro() {
		return intro;
	}
	public void setIntro(Intro intro) {
		this.intro = intro;
	}
	public String getAccountTypes() {
		return accountTypes;
	}
	public void setAccountTypes(String accountTypes) {
		this.accountTypes = accountTypes;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getScreenNameUrl() {
		return screenNameUrl;
	}
	public void setScreenNameUrl(String screenNameUrl) {
		this.screenNameUrl = screenNameUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public String getProfileImagelUrl() {
		return profileImagelUrl;
	}
	public void setProfileImagelUrl(String profileImagelUrl) {
		this.profileImagelUrl = profileImagelUrl;
	}
	public String getProfileThumbnailUrl() {
		return profileThumbnailUrl;
	}
	public void setProfileThumbnailUrl(String profileThumbnailUrl) {
		this.profileThumbnailUrl = profileThumbnailUrl;
	}
	public long getPostCount() {
		return postCount;
	}
	public void setPostCount(long postCount) {
		this.postCount = postCount;
	}
	public List<Post> getAllposts() {
		return allposts;
	}
	public void setAllposts(List<Post> allposts) {
		this.allposts = allposts;
	}
	@Override
	public String toString() {
		return "Parent [intro=" + intro + ", accountTypes=" + accountTypes + ", screenName=" + screenName
				+ ", screenNameUrl=" + screenNameUrl + ", name=" + name + ", profileUrl=" + profileUrl
				+ ", profileImagelUrl=" + profileImagelUrl + ", profileThumbnailUrl=" + profileThumbnailUrl
				+ ", postCount=" + postCount + ", allposts=" + allposts + "]";
	}
	
}
