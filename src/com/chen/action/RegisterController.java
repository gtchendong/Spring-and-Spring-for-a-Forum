package com.chen.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chen.bean.dao.CreateDao;

@Controller
public class RegisterController {
	@Autowired
	private CreateDao create;
	@RequestMapping(value="/register.do")
	public String register(){
		
		return "register";
	}
	@RequestMapping(value="/reput.do",method=RequestMethod.POST)
	public String create(HttpSession session,HttpServletRequest request){
		String title=null;
		String context=null;
		String image=null;
		// 创建FileItem工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 用于解析请求数据的组件
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(int i=0;i<list.size();i++){
				FileItem item = list.get(i);
				if (item.isFormField()) {//判断文件向是否为表单字段
					if ("title".equals(item.getFieldName())) {
						//System.out.println("description:"+new String(item.getString().getBytes("iso-8859-1"),"utf-8"));//解决乱码
						try {
							title =new String(item.getString().getBytes("iso-8859-1"),"utf-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else if("context".equals(item.getFieldName())){
						context=item.getString();
					}
				}
				else{
					String filename=item.getName();
					//System.out.println("filename:"+filename);//获取文件名
					if(filename!=""){
					String extName=filename.substring(filename.lastIndexOf("."));//截取文件扩展名
					//System.out.println("extName:"+extName);
					//生成UUID作为文件名
					String newName=UUID.randomUUID().toString();
					//获取服务器上的自定义的存放文件目录
					String rootPath=request.getServletContext().getRealPath("/Pic");
					//System.out.println("request.getServletContext().getRealPath():"+request.getServletContext().getRealPath("/"));
					//System.out.println("request.getServletContext():"+request.getServletContext());
					image=rootPath+"\\"+newName+extName;
					//System.out.println(image);
					try {
						item.write(new File(rootPath+"\\"+newName+extName));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}	
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		String title =request.getParameter("title");
//		String context=request.getParameter("context");
		String username=(String) session.getAttribute("username");
		create.create(title, context, username,image);
		return "forward:/bottom/0.do";
	}
}
