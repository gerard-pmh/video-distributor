package com.pge.videodistributor.models;

public class Link {

	private Integer videoId;
	private Integer cacheId;
	private Long datacenterLatency;
	private Long cacheLatency;
	private Long requestSize;
	private Long videoSize;

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public Integer getCacheId() {
		return cacheId;
	}

	public void setCacheId(Integer cacheId) {
		this.cacheId = cacheId;
	}

	public Long getDatacenterLatency() {
		return datacenterLatency;
	}

	public void setDatacenterLatency(Long datacenterLatency) {
		this.datacenterLatency = datacenterLatency;
	}

	public Long getCacheLatency() {
		return cacheLatency;
	}

	public void setCacheLatency(Long cacheLatency) {
		this.cacheLatency = cacheLatency;
	}

	public Long getRequestSize() {
		return requestSize;
	}

	public void setRequestSize(Long requestSize) {
		this.requestSize = requestSize;
	}

	public Long getVideoSize() {
		return videoSize;
	}

	public void setVideoSize(Long videoSize) {
		this.videoSize = videoSize;
	}

	public Long generateScore() {
		return requestSize * (datacenterLatency - cacheLatency);
	}
}
