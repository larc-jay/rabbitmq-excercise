package larc.rabittmq.obj;

public class F4JPostLikedUser {
	private String reaction;
	private String name;
	private String profileUrl;
	private String isFriend;
	public String getReaction() {
		return reaction;
	}
	public void setReaction(String reaction) {
		this.reaction = reaction;
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
	public String getIsFriend() {
		return isFriend;
	}
	public void setIsFriend(String isFriend) {
		this.isFriend = isFriend;
	}
	@Override
	public String toString() {
		return "F4JPostLikedUser [reaction=" + reaction + ", name=" + name + ", profileUrl=" + profileUrl
				+ ", isFriend=" + isFriend + "]";
	}
	
}
