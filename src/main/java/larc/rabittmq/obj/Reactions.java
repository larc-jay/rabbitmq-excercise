package larc.rabittmq.obj;

public class Reactions {
	private long like =0;
	private long love = 0;
	private long angry =0;
	private long haha=0;
	private long wow=0;
	private long sad=0;
	private long total=0;
	public long getLike() {
		return like;
	}
	public void setLike(long like) {
		this.like = like;
	}
	public long getLove() {
		return love;
	}
	public void setLove(long love) {
		this.love = love;
	}
	public long getAngry() {
		return angry;
	}
	public void setAngry(long angry) {
		this.angry = angry;
	}
	public long getHaha() {
		return haha;
	}
	public void setHaha(long haha) {
		this.haha = haha;
	}
	public long getWow() {
		return wow;
	}
	public void setWow(long wow) {
		this.wow = wow;
	}
	public long getSad() {
		return sad;
	}
	public void setSad(long sad) {
		this.sad = sad;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Reactions [like=" + like + ", love=" + love + ", angry=" + angry + ", haha=" + haha + ", wow=" + wow
				+ ", sad=" + sad + ", total=" + total + "]";
	}
	
}
