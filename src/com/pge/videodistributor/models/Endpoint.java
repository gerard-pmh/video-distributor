package com.pge.videodistributor.models;

import java.util.Map;

public class Endpoint {

	private Long datacenterLatency;
	private Map<Integer, Long> cacheLatency;

	public Long getDatacenterLatency() {
		return datacenterLatency;
	}

	public void setDatacenterLatency(Long datacenterLatency) {
		this.datacenterLatency = datacenterLatency;
	}

	public Map<Integer, Long> getCacheLatency() {
		return cacheLatency;
	}

	public void setCacheLatency(Map<Integer, Long> cacheLatency) {
		this.cacheLatency = cacheLatency;
	}
}
