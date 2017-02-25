package com.pge.videodistributor;

import com.pge.videodistributor.models.Datacenter;
import com.pge.videodistributor.models.Solution;
import com.pge.videodistributor.utils.DatacenterToSolution;

public class VideoDistributor {

	public Solution distributeVideo(Datacenter datacenter) {
		DatacenterToSolution datacenterToSolution = new DatacenterToSolution(datacenter);
		return datacenterToSolution.generateSolution();
	}
}
