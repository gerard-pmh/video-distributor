package com.pge.videodistributor.models;

public class Request {

	private Integer videoId;
	private Integer endpoitId;
	private Long size;

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public Integer getEndpoitId() {
		return endpoitId;
	}

	public void setEndpoitId(Integer endpoitId) {
		this.endpoitId = endpoitId;
	}
}
