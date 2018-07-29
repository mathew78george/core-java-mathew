package com.mathew.corejava.designs.logging;

import java.util.TimerTask;

public class FileRollOverTask extends TimerTask {
	
	private FileLogger logger;

	public FileRollOverTask(FileLogger lgr) {
		logger = lgr;
	}

	@Override
	public void run() {
		logger.rolloverFile();

	}	
}