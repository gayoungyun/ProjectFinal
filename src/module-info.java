module Project01 {
	exports login.main;
	exports login.controller;
	exports login.dao;
	exports login.dto;

	requires java.naming;
	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
}