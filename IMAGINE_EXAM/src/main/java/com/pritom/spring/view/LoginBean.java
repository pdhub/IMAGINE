package com.pritom.spring.view;

public class LoginBean
{
		private String username;

		private String password;
		
		private String examDescription;

		public String getPassword()
		{
				return this.password;
		}

		public String getUsername()
		{
				return this.username;
		}

		public void setUsername(String username)
		{
				this.username = username;
		}

		public void setPassword(String password)
		{
				this.password = password;
		}

		public String getExamDescription() {
			return examDescription;
		}

		public void setExamDescription(String examDescription) {
			this.examDescription = examDescription;
		}


}
