package com.pge.videodistributor.models;

import java.util.List;

public class Datacenter {

	private DatacenterConfiguration configuration;
	private List<Video> videos;
	private List<Endpoint> endpoints;
	private List<Request> requests;

	public DatacenterConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(DatacenterConfiguration configuration) {
		this.configuration = configuration;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

}
