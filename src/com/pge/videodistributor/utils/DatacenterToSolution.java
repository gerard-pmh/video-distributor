package com.pge.videodistributor.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.pge.videodistributor.models.Datacenter;
import com.pge.videodistributor.models.Endpoint;
import com.pge.videodistributor.models.Link;
import com.pge.videodistributor.models.Request;
import com.pge.videodistributor.models.Solution;

public class DatacenterToSolution {

	private Datacenter datacenter;

	public DatacenterToSolution(Datacenter datacenter) {
		this.datacenter = datacenter;
	}

	public Datacenter getDatacenter() {
		return datacenter;
	}

	public void setDatacenter(Datacenter datacenter) {
		this.datacenter = datacenter;
	}

	private List<Link> genererateLinks() {
		List<Link> links = new ArrayList<>();
		for (Request request : datacenter.getRequests()) {
			Endpoint endpoint = datacenter.getEndpoints().get(request.getEndpoitId());
			for (Entry<Integer, Long> cacheLatency : endpoint.getCacheLatency().entrySet()) {
				Link link = new Link();
				link.setCacheId(cacheLatency.getKey());
				link.setCacheLatency(cacheLatency.getValue());
				link.setVideoId(request.getVideoId());
				link.setDatacenterLatency(endpoint.getDatacenterLatency());
				link.setRequestSize(request.getSize());
				link.setVideoSize(datacenter.getVideos().get(request.getVideoId()).getSize());
				links.add(link);
			}
		}
		return links;
	}

	private List<Long> generateCaches() {
		List<Long> caches = new ArrayList<>();
		for (int i = 0; i < datacenter.getConfiguration().getNbCaches(); i++) {
			caches.add(datacenter.getConfiguration().getCacheSize().longValue());
		}
		return caches;
	}

	public Solution generateSolution() {
		List<Long> caches = generateCaches();
		List<Link> links = genererateLinks();
		links.sort(Collections.reverseOrder(Comparator.comparing(Link::generateScore)));
		Iterator<Link> itLink = links.iterator();
		while (itLink.hasNext()) {
			Link link = itLink.next();
			Long cacheSize = caches.get(link.getCacheId());
			if (link.getVideoSize() < cacheSize) {
				caches.set(link.getCacheId(), cacheSize - link.getVideoSize());
			} else {
				itLink.remove();
			}
		}
		return new Solution(links);
	}

}
