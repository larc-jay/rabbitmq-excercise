package larc.rabittmq.obj;

public class F4JComments {
	private String commentId;
	private String message;
	private String commenter;
	private long createdTime;
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}
	public String getCommenter() {
		return commenter;
	}
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	@Override
	public String toString() {
		return "F4JComments [commentId=" + commentId + ", message=" + message + ", commenter=" + commenter
				+ ", createdTime=" + createdTime + "]";
	}
	
}
