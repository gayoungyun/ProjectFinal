module Project01 {
	exports login.main;
	exports basket.basketDTO;
	exports admin.controller;
	exports list.listDAO;
	exports buypage.controller;
	exports admin.dao;
	exports basket.basketDAO;
	exports mainpage.mainclass;
	exports search.pwd.controller;
	exports basket.controller;
	exports login.controller;
	exports list.controller;
	exports mainpage.controller;
	exports list.listDTO;
	exports login.url;
	exports list.mainclass;
	exports login.dto;
	exports basket.mainclass;
	exports buypage.buypageDAO;
	exports UserIdSave;
	exports admin.main;
	exports login.dao;
	exports admin.dto;
	exports admin.service;
	exports buypage.mainclass;
	exports search.id.controller;
	exports MemberInfo.main;
	exports register.url;
	exports Member.dao;
	exports Member.service;
	exports Member.dto;
	exports Member.controller;
	exports Member.main;
	
	
	requires java.naming;
	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	
	opens basket.basketDTO;
	opens basket.controller;
	opens buypage.controller;
	opens list.controller;
	opens mainpage.controller;
	opens admin.controller;
	opens Member.controller;
}