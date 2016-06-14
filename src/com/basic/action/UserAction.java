package com.basic.action;

import java.util.List;

import com.basic.base.BaseAction;
import com.basic.service.IUserService;
import com.basic.pojo.Document;
import com.basic.pojo.Student;
import com.basic.pojo.User;
import com.basic.util.Page;

public class UserAction extends BaseAction{

	private static final long serialVersionUID = -910456589191114077L;
	
	private IUserService userService;
	private List<User> userList;
	private User user;
	private Integer id;

	private String forWhere;
	private String cc;

    public String login(){
    	
		String result = "error";
		String real = (String)getSession().getAttribute("real");
		
		if(cc != null && cc.equalsIgnoreCase(real)){
			
			User loginUser = userService.findOneByEmail(user.getEmail());
			
			if(loginUser!= null){
				if(loginUser.getPassword().equals(user.getPassword())){
					if(loginUser.getStatus().equals("Yes")){
						getSession().setAttribute("user", loginUser);
						result = "success";
					}else{
						getRequest().setAttribute("errorMessage", "Please contact the administrator!");
					}
				}else{
					getRequest().setAttribute("errorMessage", "Password Error!");
				}
			}else{
				getRequest().setAttribute("errorMessage", "Email Error!");
			}
		} else {
			getRequest().setAttribute("errorMessage", "Check code Error!");
		}
			
		return result;
    }
    
    public String logout(){
		String result = "error";
		try {
			User logoutUser=(User)getSession().getAttribute("user");
			if(logoutUser!=null) {
				getSession().invalidate();
				result = "success";
			}
		} catch (Exception e) {}
		return result;
    }
    
    public String updateProfile() {
    	//if(this.validateForm()) {
    		//---------
    		User uu = userService.findOneByEmail(((User)getSession().getAttribute("user")).getEmail());
    		
    		user.setFirstName(user.getFirstName());
    		user.setLastName(user.getLastName());
    		user.setRemark(user.getRemark());
    		
    		user.setEmail(uu.getEmail());
    		user.setPassword(uu.getPassword());
    		user.setStatus(uu.getStatus());

    		if(user!=null) {
    			userService.update(user);
    		}

            return "success";
    	//} else {
            //return "error";
    	//}
    }
    
    public String updatePassword() {
    	//if(this.validateForm()) {
    		//---------
    		User uu = userService.findOneByEmail(((User)getSession().getAttribute("user")).getEmail());
    		
    		user.setPassword(user.getPassword());

    		user.setEmail(uu.getEmail());
    		user.setStatus(uu.getStatus());
    		user.setFirstName(uu.getFirstName());
    		user.setLastName(uu.getLastName());
    		user.setRemark(uu.getRemark());

    		if(user!=null) {
    			userService.update(user);
    		}

            return "success";
    	//} else {
            //return "error";
    	//}
    }
    
 
    public String execute(){
    	return SUCCESS;
    }
    
	public boolean validateForm() {
		if(user!=null){
        	if (user.getEmail()==null || user.getEmail().equals("")) {
        		this.addFieldError("Email", "Email can not be null!");
        		return false;
        	}
		} else {
			return false;
		}
		return true;
	}
    
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getForWhere() {
		return forWhere;
	}
	public void setForWhere(String forWhere) {
		this.forWhere = forWhere;
	}
	
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
}
