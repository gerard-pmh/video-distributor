package com.pge.videodistributor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.pge.videodistributor.models.Datacenter;
import com.pge.videodistributor.models.Solution;
import com.pge.videodistributor.utils.DatacenterToSolution;
import com.pge.videodistributor.utils.FileToDatacenter;

public class Main {

	public static void main(String[] args) {

		String fileName = "videos_worth_spreading";

		FileToDatacenter fileToDatacenter = new FileToDatacenter("inputdata/" + fileName + ".in");
		try {
			Datacenter datacenter = fileToDatacenter.generateDatacenter();
			DatacenterToSolution datacenterToSolution = new DatacenterToSolution(datacenter);
			Solution solution = datacenterToSolution.generateSolution();
			Files.createDirectories(Paths.get("outputdata"));
			Files.write(Paths.get("outputdata/" + fileName + ".out"), solution.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
