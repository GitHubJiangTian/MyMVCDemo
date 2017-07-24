package com.company.service.iservice.report;

import java.util.List;

import com.company.dao.pojo.report.OrderReport;
import com.company.service.iservice.IBasicService;

public interface IOrderReportService extends IBasicService<OrderReport,Integer>{
	
	List<OrderReport> showInfo();// 显示用户、产品、订单，订单详情的相关信息
}
