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
		// ����FileItem����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ���ڽ����������ݵ����
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(int i=0;i<list.size();i++){
				FileItem item = list.get(i);
				if (item.isFormField()) {//�ж��ļ����Ƿ�Ϊ���ֶ�
					if ("title".equals(item.getFieldName())) {
						//System.out.println("description:"+new String(item.getString().getBytes("iso-8859-1"),"utf-8"));//�������
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
					//System.out.println("filename:"+filename);//��ȡ�ļ���
					if(filename!=""){
					String extName=filename.substring(filename.lastIndexOf("."));//��ȡ�ļ���չ��
					//System.out.println("extName:"+extName);
					//����UUID��Ϊ�ļ���
					String newName=UUID.randomUUID().toString();
					//��ȡ�������ϵ��Զ���Ĵ���ļ�Ŀ¼
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
