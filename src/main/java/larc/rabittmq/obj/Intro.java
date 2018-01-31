package larc.rabittmq.obj;

public class Intro {
	private String introduction;
	private  String  study;
	private  String  work;
	private String followedByCount;
	private String homeTown;
	private String livingPlace;
	private String status;
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getStudy() {
		return study;
	}
	public void setStudy(String study) {
		this.study = study;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getFollowedByCount() {
		return followedByCount;
	}
	public void setFollowedByCount(String followedByCount) {
		this.followedByCount = followedByCount;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getLivingPlace() {
		return livingPlace;
	}
	public void setLivingPlace(String livingPlace) {
		this.livingPlace = livingPlace;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Intro [introduction=" + introduction + ", study=" + study + ", work=" + work + ", followedByCount="
				+ followedByCount + ", homeTown=" + homeTown + ", livingPlace=" + livingPlace + ", status=" + status
				+ "]";
	}
	
}
