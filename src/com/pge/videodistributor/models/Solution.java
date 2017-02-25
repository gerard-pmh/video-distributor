package com.pge.videodistributor.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution {

	private Map<Integer, List<Integer>> cacheVideos;

	public Solution(List<Link> links) {
		this.cacheVideos = new HashMap<>();
		for (Link link : links) {
			Integer cacheId = link.getCacheId();
			if (!cacheVideos.containsKey(cacheId)) {
				cacheVideos.put(cacheId, new ArrayList<>());
			}
			if (!cacheVideos.get(cacheId).contains(link.getVideoId())) {
				cacheVideos.get(cacheId).add(link.getVideoId());
			}
		}
	}

	@Override
	public String toString() {
		String result = Integer.toString(cacheVideos.size()) + "\n";
		result += cacheVideos.entrySet().stream().map(this::printLine).collect(Collectors.joining("\n"));
		return result + "\n";
	}

	private String printLine(Entry<Integer, List<Integer>> entry) {
		StringBuilder sb = new StringBuilder();
		sb.append(entry.getKey().toString());
		for (Integer videoId : entry.getValue()) {
			sb.append(" " + videoId);
		}
		return sb.toString();
	}
}
