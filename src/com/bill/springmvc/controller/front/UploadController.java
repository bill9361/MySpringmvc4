package com.bill.springmvc.controller.front;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.bill.springmvc.util.FileUpload;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月11日下午4:15:18<br/>
 * 类说明：文件上传
 */
@Controller
@RequestMapping("/upload")
public class UploadController
{

	/**
	 * 单文件上传使用MultipartFile
	 * 
	 * @param request
	 * @param mpFile
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/singleFileUpload")
	public String singleFileUpload(HttpServletRequest request, @RequestParam(name = "headName") MultipartFile mpFile,
			Model model) throws Exception
	{
		System.out.println("UploadController....singleFileUpload()");
		// 获取上传文件的原文件名
		String originalFilename = mpFile.getOriginalFilename();
		// 获取file空间的name值，此处的name值为headName
		/*
		 * tring name = mpFile.getName(); System.out.println("originalFilename:"
		 * + originalFilename); System.out.println("name:" + name);
		 */
		// 对应applicationScope对象，被所有用户共享，只要服务器没关闭，都存活
		ServletContext sContext = request.getServletContext();
		String uploadPath = sContext.getRealPath("/upload");
		// 上传后的文件名
		String fileName = UUID.randomUUID().toString().trim() + "_" + originalFilename;
		// 上传后的文件路径
		String filePath = uploadPath + "\\" + fileName;
		// 将上传的文件保存到指定的文件夹下
		mpFile.transferTo(new File(filePath));

		model.addAttribute("filePaths", filePath);

		return "/upload_success.jsp";
	}

	/**
	 * 多文件上传使用MultipartRequest
	 * 
	 * @param request
	 * @param multipartRequest
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/multipleFileUpload")
	public String multipleFileUpload(HttpServletRequest request, MultipartRequest multipartRequest, Model model)
			throws Exception
	{
		System.out.println("UploadController....multipleFileUpload()");

		System.out.println("从FileMap获取数据：");
		Map<String, MultipartFile> multiPartFileMap = multipartRequest.getFileMap();
		if (multiPartFileMap != null)
		{
			for (Entry<String, MultipartFile> multiPartFileEntry : multiPartFileMap.entrySet())
			{
				if (multiPartFileEntry != null)
				{
					String key = multiPartFileEntry.getKey();
					MultipartFile multipartFile = multiPartFileEntry.getValue();

					System.out.println(key + " == " + "("+multipartFile.getName()+")"+multipartFile.getOriginalFilename());
				}

			}
		}
		
		/*
		System.out.println("从List获取数据：");
		List<MultipartFile> multipartFileList = multipartRequest.getFiles("fileName1");
		if (multipartFileList != null)
		{
			for (int i = 0; i < multipartFileList.size(); i++)
			{
				MultipartFile multipartFile = multipartFileList.get(i);
				System.out.println("("+multipartFile.getName()+")"+multipartFile.getOriginalFilename());
			}
		}*/
		
		return "/upload_success.jsp";
	}
	
	/**
	 * 多文件上传使用MultipartRequest
	 * 
	 * @param request
	 * @param multipartRequest
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/multipleFileUpload1")
	public String multipleFileUpload1(HttpServletRequest request, MultipartRequest multipartRequest, Model model)
			throws Exception
	{
		System.out.println("UploadController....multipleFileUpload1()");
		Map<String, String> filePathMap = FileUpload.uploadFiles(request, multipartRequest);
		model.addAttribute("filePaths", filePathMap);
		
		return "/upload_success.jsp";
	}

}
