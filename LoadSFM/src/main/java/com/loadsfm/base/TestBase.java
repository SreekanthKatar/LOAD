package com.loadsfm.base;

public class TestBase {
	
		// Browser Info
		public final static String chromepath = "D:\\Projects\\SFM_LOAD\\LoadSFM\\src\\main\\java\\com\\loadsfm\\browsers\\chromedriver.exe";
		public final static String chromedriver = "webdriver.chrome.driver";
		
		// URL
		public final static String appurl = "http://192.168.2.191:8080/SFM/";
		
		// Credentials
		public final static String username = "pavan";
		public final static String password = "123";
		
		// Contacts Page Object Repository
		public static String usrnamepath = "//*[@id=\"Username\"]";
		public static String passwrdpath = "//*[@id=\"password\"]";
		public static String signinbuttonpath = "/html/body/div/form/button";
		public static String dashboardurl = "http://192.168.2.130:8080/SFM/home";
		public static String contactspageurl = "http://192.168.2.130:8080/SFM/openNewContactPage";
		public static String titlepath = "//*[@id=\"title\"]";
		public static String contactnamepath = "//*[@id=\"contactName\"]";
		public static String designationpath = "//*[@id=\"designation\"]";
		public static String companynamepath = "//*[@id=\"companyName\"]";
		public static String companypath = "//*[@id=\"companyName_chosen\"]/a";
		public static String companynameinputpath = "//*[@id=\"companyName_chosen\"]/div/div/input";
		public static String branchnamepath = "//*[@id=\"branchName_chosen\"]/a";
		public static String branchnameinputpath = "//*[@id=\"branchName_chosen\"]/div/div/input";
		public static String emailpath = "//*[@id=\"mailId\"]";
		public static String mobilenumber1path = "//*[@id=\"mobileNo\"]";
		public static String savebuttonpath = "//*[@id=\"bootstrapForm\"]/div/div[2]/button";
		public static String followuprequestyespath = "//input[@id='followUpRequest'][@type='radio'][@value='yes']";
		public static String followupdatefieldpath = "//input[@id=\"followUpDate\"]"; 
		public static String followupdatepickmonthcalpath = "//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]";
		public static String followupdatedelinktextpath = "31";
		public static String followuptimepath = "//*[@id=\"followUpTime\"]";
		public static String followuptimelablepath = "//*[@id=\"taskHideId\"]/div/div/div/div/div[1]/div[2]/label";
		public static String followup_tasknamepath = "//*[@id=\"taskName\"]";
		public static String followup_tasktypepath = "//*[@id=\"taskType\"]";
		public static String followup_assignedtopath = "//*[@id=\"assignTo1\"]";
		public static String followup_notespath = "//*[@id=\"notes\"]";
		public static String followup_prioritypath = "//*[@id=\"priority1\"]";
		
		
		
		// Lead Information Page Object Repository
		public static String leadinfourlwithoutid = "http://192.168.2.130:8080/SFM/qualifyContactDetails?contactMasterId=";
		public static String leadnamepath = "//*[@id=\"leadName\"]";
		public static String sourcepath = "//*[@id=\"leadSource\"]";
		public static String leadterritorypath = "//*[@id=\"leadTerritory\"]";
		public static String productsourcepath = "//*[@id=\"productSource\"]";
		public static String quantitypath = "//*[@id=\"quantity\"]";
		public static String productfamilypath = "//*[@id=\"productFamily\"]";
		public static String productgrouppath = "//*[@id=\"productGroup\"]";
		public static String producttypepath = "//*[@id=\"productType_chosen\"]/a";
		public static String producttypeinputpath = "//*[@id=\"productType_chosen\"]/div/div/input";
		public static String ratingpath = "//*[@id=\"rating\"]";
		public static String addbuttonpath = "//*[@id=\"add\"]";
		public static String leadsavebuttonpath = "//button[@type='button'and @value='submit']";
		

		// Activit Entry Page Object Repostitory
		public static String activityentrypageurl = "http://192.168.2.191:8080/SFM/newActivity";
		public static String calltypepath = "//*[@id=\"callType\"]";
		public static String activity_companynamepath = "//*[@id=\"activityCompanyName\"]";
		public static String modalpopup_companypath = "//*[@id=\"tbodyCompanyActData\"]/tr[1]/td[2]";
		public static String activity_contactpersonpath = "//*[@id=\"activityContactPerson\"]";
		public static String activitytypepath = "//*[@id=\"activityTypeName\"]";
		public static String activitytypepurposepath = "//*[@id=\"visitType\"]";
		public static String notespath = "//*[@id=\"matterDiscussed\"]";
		public static String activity_savebuttonpath = "//*[@id=\"bootstrapForm\"]/div/div/div[2]/div[4]/button";
		public static String activity_leadnamepath = "//*[@id=\"activityLeadName\"]";
		public static String modalpopup_leadnamepath = "//*[@id=\"tbodyLeadActData\"]/tr[1]/td[2]";
}

