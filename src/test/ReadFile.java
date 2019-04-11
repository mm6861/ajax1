package test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import service.FileService;
import service.impl.FileServiceImpl;

public class ReadFile {
	public static void main(String[] args) {
		FileService fs = new FileServiceImpl();
		String path = "D:\\study\\addr\\input";
		String targetPath = "D:\\study\\addr\\input\\ok";
		File targetFolder = new File(targetPath);
		File root = new File(path);
		File[] files = root.listFiles();
		for(File file : files) {
			if(!file.isDirectory()) {
				Map<String,String> rMap = fs.insertAddrFromFile(file);
				int targetCnt = Integer.parseInt(rMap.get("targetCnt"));
				int totalCnt = Integer.parseInt(rMap.get("totalCnt"));
				if(targetCnt==totalCnt) {
					try {
						FileUtils.moveFileToDirectory(file, targetFolder, false);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return;  
			}
			
		}
	}
}
