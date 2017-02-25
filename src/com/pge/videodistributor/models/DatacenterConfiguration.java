package com.pge.videodistributor.models;

public class DatacenterConfiguration {

	private Long nbVideos;
	private Long nbEndpoints;
	private Long nbRequests;
	private Long nbCaches;
	private Long cacheSize;

	public Long getNbVideos() {
		return nbVideos;
	}

	public void setNbVideos(Long nbVideos) {
		this.nbVideos = nbVideos;
	}

	public Long getNbEndpoints() {
		return nbEndpoints;
	}

	public void setNbEndpoints(Long nbEndpoints) {
		this.nbEndpoints = nbEndpoints;
	}

	public Long getNbRequests() {
		return nbRequests;
	}

	public void setNbRequests(Long nbRequests) {
		this.nbRequests = nbRequests;
	}

	public Long getNbCaches() {
		return nbCaches;
	}

	public void setNbCaches(Long nbCaches) {
		this.nbCaches = nbCaches;
	}

	public Long getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(Long cacheSize) {
		this.cacheSize = cacheSize;
	}
}
