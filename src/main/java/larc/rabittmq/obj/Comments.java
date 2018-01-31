package larc.rabittmq.obj;

import java.util.List;
public class Comments {
	private long count;
	private List<F4JComments> comment;
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List<F4JComments> getComments() {
		return comment;
	}
	public void setComments(List<F4JComments> comments) {
		this.comment = comments;
	}
	@Override
	public String toString() {
		return "Comments [count=" + count + ", comment=" + comment + "]";
	}
	
}
