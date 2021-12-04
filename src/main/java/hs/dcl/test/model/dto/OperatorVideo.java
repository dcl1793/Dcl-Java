package hs.dcl.test.model.dto;

public class OperatorVideo {
	private String userId;
	private Boolean openVideo;
	private String url;
	private Integer state; 
	private String reason;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Boolean getOpenVideo() {
		return openVideo;
	}
	public void setOpenVideo(Boolean openVideo) {
		this.openVideo = openVideo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
