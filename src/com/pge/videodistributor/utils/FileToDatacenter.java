package com.pge.videodistributor.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pge.videodistributor.models.Datacenter;
import com.pge.videodistributor.models.DatacenterConfiguration;
import com.pge.videodistributor.models.Endpoint;
import com.pge.videodistributor.models.Request;
import com.pge.videodistributor.models.Video;

public class FileToDatacenter {

	private String path;

	public FileToDatacenter(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Datacenter generateDatacenter() throws IOException {

		Datacenter datacenter = new Datacenter();

		List<String> lines = Files.readAllLines(Paths.get(path));

		DatacenterConfiguration datacenterConfiguration = new DatacenterConfiguration();

		List<Long> confData = parseLine(lines.remove(0));

		datacenterConfiguration.setNbVideos(confData.get(0));
		datacenterConfiguration.setNbEndpoints(confData.get(1));
		datacenterConfiguration.setNbRequests(confData.get(2));
		datacenterConfiguration.setNbCaches(confData.get(3));
		datacenterConfiguration.setCacheSize(confData.get(4));

		datacenter.setConfiguration(datacenterConfiguration);

		List<Video> videos = new ArrayList<>();

		List<Long> videoData = parseLine(lines.remove(0));

		for (int i = 0; i < videoData.size(); i++) {
			Video video = new Video();
			video.setSize(videoData.get(i));
			videos.add(video);
		}

		datacenter.setVideos(videos);

		List<Endpoint> endpoints = new ArrayList<>();

		int startI = 0;
		for (int i = 0; i < datacenter.getConfiguration().getNbEndpoints(); i++) {

			int trueI = i + startI;

			Endpoint endpoint = new Endpoint();

			List<Long> endpointData = parseLine(lines.get(trueI));

			endpoint.setDatacenterLatency(endpointData.get(0));

			Long nbCacheAccess = endpointData.get(1);

			Map<Integer, Long> cacheLatency = new HashMap<>();

			for (int j = 0; j < nbCacheAccess; j++) {
				List<Long> cacheLatencyData = parseLine(lines.get(trueI + j + 1));
				cacheLatency.put(cacheLatencyData.get(0).intValue(), cacheLatencyData.get(1));
			}

			endpoint.setCacheLatency(cacheLatency);

			endpoints.add(endpoint);

			startI += nbCacheAccess;
		}

		datacenter.setEndpoints(endpoints);

		List<Request> requests = new ArrayList<>();

		startI += datacenter.getConfiguration().getNbEndpoints();
		for (int i = 0; i < datacenter.getConfiguration().getNbRequests(); i++) {
			Request request = new Request();
			List<Long> requestData = parseLine(lines.get(i + startI));
			request.setVideoId(requestData.get(0).intValue());
			request.setEndpoitId(requestData.get(1).intValue());
			request.setSize(requestData.get(2));
			requests.add(request);
		}

		datacenter.setRequests(requests);

		return datacenter;
	}

	private List<Long> parseLine(String line) {
		return Arrays.asList(line.split(" ")).stream().map(Long::parseLong).collect(Collectors.toList());
	}
}
