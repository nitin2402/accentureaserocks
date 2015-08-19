package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;

import com.accenture.tmt.dao.dto.EmployeeReportDetailsFlatDTO;

import com.accenture.tmt.presentation.dto.EmployeeReportUpdateDTO;
import com.accenture.tmt.presentation.dto.ReportDetailsDTO;




public class EmlpoyeeReportDAO {

		
		

	public List<EmployeeReportDetailsFlatDTO> getEmployeeDetailsReportDAO(ReportDetailsDTO empreportdto){
		List<EmployeeReportDetailsFlatDTO> empreportflatdto = new ArrayList<EmployeeReportDetailsFlatDTO>();
		//EmployeeReportDetailsFlatDTO emplist = null;
	    try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
					if((empreportdto.getEmpname()==""||empreportdto.getEmpname()==null)&& (empreportdto.getAction()==""||empreportdto.getAction()==null))
					{
						
						Statement st1 = con.createStatement();
						String start=((Date)empreportdto.getStartDate()).toString();
						String end=((Date)empreportdto.getEndDate()).toString();
						String query= "select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId "
								+ " where EmployeeName LIKE '*'"
								+ " AND  Date BETWEEN #" +start+ 
								"# AND #" +end+"# AND Action LIKE '*'";
					    rs = st1.executeQuery(query);
					}
					else if((empreportdto.getEmpname()==""||empreportdto.getEmpname()==null)&&(empreportdto.getAction()!=""||empreportdto.getAction()!=null))
					{
						
						PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY_action);
					    //st1.setString(1, empreportdto.getEmpname());
					    st1.setDate(1, (Date)empreportdto.getStartDate());
					    st1.setDate(2, (Date)empreportdto.getEndDate());
					    st1.setString(3, empreportdto.getAction());
					    rs = st1.executeQuery();
					}else if((empreportdto.getAction()==""||empreportdto.getAction()==null)&& (empreportdto.getEmpname()!=""||empreportdto.getEmpname()!=null))
					{
						
						PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY_emp);
					    st1.setString(1, empreportdto.getEmpname());
					    st1.setDate(2, (Date)empreportdto.getStartDate());
					    st1.setDate(3, (Date)empreportdto.getEndDate());
					    //st1.setString(3, empreportdto.getAction());
					    rs = st1.executeQuery();
					}else{PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY);
				    st1.setString(1, empreportdto.getEmpname());
				    st1.setDate(2, (Date)empreportdto.getStartDate());
				    st1.setDate(3, (Date)empreportdto.getEndDate());
				    st1.setString(4, empreportdto.getAction());
				    rs = st1.executeQuery();
				    }
	
					 resultSet(rs,(ArrayList<EmployeeReportDetailsFlatDTO>) empreportflatdto);

				    //System.out.println("bye");
				    con.close();
					}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return empreportflatdto;
	}

	public List<EmployeeReportDetailsFlatDTO> getEmployeeDetailsReportDAO_allpresent(ReportDetailsDTO empreportdto) {
		// TODO Auto-generated method stub
		List<EmployeeReportDetailsFlatDTO> empreportflatdto = new ArrayList<EmployeeReportDetailsFlatDTO>();
		//EmployeeReportDetailsFlatDTO emplist = null;
	    try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
			 
				if(con != null){
		//bill null
					
					//all are null
						 if((empreportdto.getBill() ==null||empreportdto.getBill() =="") &&(empreportdto.getAction() =="" || empreportdto.getAction() ==null) && (empreportdto.getDesignation() ==""||empreportdto.getDesignation() ==null))
							{
							 Statement st1 = con.createStatement();
								String start=((Date)empreportdto.getStartDate()).toString();
								String end=((Date)empreportdto.getEndDate()).toString();
								/*String query= "select * from EmployeeReport where EmployeeDesignation LIKE '*'"
										+ " AND  Date BETWEEN #" +start+ 
										"# AND #" +end+"# AND Action LIKE '*'";*/
								String query= "select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where Billable Like '*' AND EmployeeDesignation LIKE '*'"
								+ " AND  Date BETWEEN #" +start+ 
								"# AND #" +end+"# AND Action LIKE '*'";
							    rs = st1.executeQuery(query);
							}
						 
						 //bill&action null--only desg
						 else if( (empreportdto.getDesignation()!=""||empreportdto.getDesignation()!=null) && (empreportdto.getBill()==null||empreportdto.getBill()=="") && (empreportdto.getAction()=="" || empreportdto.getAction()==null))
							{
								
								PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY_DESIGNATION);
							    st1.setString(1, empreportdto.getDesignation());
							    st1.setDate(2, (Date)empreportdto.getStartDate());
							    st1.setDate(3, (Date)empreportdto.getEndDate());
							   // st1.setString(3, empreportdto.getAction());
							    rs = st1.executeQuery();
							}
						 
						 //bill&desg null--only action
						 else if((empreportdto.getAction() !="" || empreportdto.getAction()!=null) && (empreportdto.getBill()==null||empreportdto.getBill()=="") && (empreportdto.getDesignation()==""||empreportdto.getDesignation()==null)  )
							{
								
								PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY_action);
							    //st1.setString(1, empreportdto.getDesignation());
							    st1.setDate(1, (Date)empreportdto.getStartDate());
							    st1.setDate(2, (Date)empreportdto.getEndDate());
							    st1.setString(3, empreportdto.getAction());
							    rs = st1.executeQuery();
							}
						 
				        //desg&action null--only bill
					
					
					
						 else if((empreportdto.getBill()!=null||empreportdto.getBill()!="") && (empreportdto.getAction() ==""||empreportdto.getAction() ==null) && (empreportdto.getDesignation()==""||empreportdto.getDesignation()==null)  )
							{
								
								PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY_BILLABILITY);
							    st1.setString(1, empreportdto.getBill());
							    st1.setDate(2, (Date)empreportdto.getStartDate());
							    st1.setDate(3, (Date)empreportdto.getEndDate());
							   // st1.setString(4, empreportdto.getAction());
							    rs = st1.executeQuery();
							 
							}
					
					//dsg-null only
						 else if((empreportdto.getBill()!=null||empreportdto.getBill()!="") && (empreportdto.getAction() !=""||empreportdto.getAction() !=null) && (empreportdto.getDesignation()==""||empreportdto.getDesignation()==null)  )
						 {
							 
							 PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY_BILL_action);
							    st1.setString(1, empreportdto.getBill());
							    st1.setDate(2, (Date)empreportdto.getStartDate());
							    st1.setDate(3, (Date)empreportdto.getEndDate());
							    st1.setString(4, empreportdto.getAction());
							    rs = st1.executeQuery();
							 
							   
						 }
					//action null only
						 else if((empreportdto.getAction() ==""||empreportdto.getAction() ==null)  &&(empreportdto.getBill()!=null||empreportdto.getBill()!="") && (empreportdto.getDesignation()!=""||empreportdto.getDesignation()!=null)  )
						 {
							 
							 PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY_BILL_desg);
							    st1.setString(1, empreportdto.getBill());
							    st1.setString(2, empreportdto.getDesignation());
							    st1.setDate(3, (Date)empreportdto.getStartDate());
							    st1.setDate(4, (Date)empreportdto.getEndDate());
							   
							    rs = st1.executeQuery();
							 
							   
						 }
					//bill null only
						 else if((empreportdto.getAction() !=""||empreportdto.getAction() !=null)  &&(empreportdto.getDesignation()!=""||empreportdto.getDesignation()!=null) && (empreportdto.getBill()==null||empreportdto.getBill()=="")  )
						 {
							 
							 PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY_DESG);
							   
							    st1.setString(1, empreportdto.getDesignation());
							    st1.setDate(2, (Date)empreportdto.getStartDate());
							    st1.setDate(3, (Date)empreportdto.getEndDate());
							    st1.setString(4, empreportdto.getAction());
							    rs = st1.executeQuery();
							 
							   
						 }
					//all not null	 
					
						 else{
								PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_EMPLOYEE_REPORT_QUERY_ALL);
							    st1.setString(1, empreportdto.getBill());
							    st1.setString(2, empreportdto.getDesignation());
							    st1.setDate(3, (Date)empreportdto.getStartDate());
							    st1.setDate(4, (Date)empreportdto.getEndDate());
							    st1.setString(5, empreportdto.getAction());
							    rs = st1.executeQuery();
							 
						 }
					
					
					
				
				
				 resultSet(rs,(ArrayList<EmployeeReportDetailsFlatDTO>) empreportflatdto);
					
				  
				

				    //System.out.println("bye");
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return empreportflatdto;
	}
	
	
	 private void resultSet(ResultSet rs, ArrayList<EmployeeReportDetailsFlatDTO> empreportflatdto) {	 
		 try {
			 EmployeeReportDetailsFlatDTO emplist = null;
			 
			   while (rs.next() == true) {
			    	
				   emplist = new EmployeeReportDetailsFlatDTO();  
			    	emplist.setEmpId(rs.getString("EmployeeId"));
			    	emplist.setEmpName(rs.getString("EmployeeName"));
			    	emplist.setDesignation(rs.getString("EmployeeDesignation"));
			    	emplist.setLevel(rs.getString("EmployeeLevel"));
			    	emplist.setExpertise(rs.getString("EmployeeExpertise"));
					emplist.setClientId(rs.getString("EmployeeClientId"));
					emplist.setEmail(rs.getString("EmployeeEmail"));
					emplist.setTeamId(rs.getString("TeamId"));
					emplist.setTeamName(rs.getString("TeamName"));
					emplist.setProfCamps(rs.getString("ProficiencyCams"));
					emplist.setProfProject(rs.getString("ProficiencyProject"));
					emplist.setDoj(rs.getString("DateofJoining"));
					emplist.setLastWD(rs.getString("LastWorkingDay")); 
					emplist.setIsBillable(rs.getString("Billable"));
					emplist.setIsActive(rs.getString("ActiveUser")); 
					emplist.setUserName(rs.getString("Username"));
					emplist.setAction(rs.getString("Action"));
					emplist.setTimeStamp(rs.getString("Timestamp"));
				
					empreportflatdto.add(emplist);     
			   }  
		 	}
		 
		 	catch (SQLException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
	 	}
	 
		public void insertEmpreoptrs(EmployeeReportUpdateDTO reportupdatedto) {
			
			// TODO Auto-generated method stub
			try {
				Connection con = DBConnection.getConnection();
				if(con != null){
					
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.INSERT_EMPLOYEE_REPORT_QUERY);
					    st1.setString(1, reportupdatedto.getEmpId());
					    st1.setString(2, reportupdatedto.getEmpName());
					    st1.setString(3, reportupdatedto.getDesignation());
					    st1.setString(4, reportupdatedto.getLevel());
					    st1.setString(5, reportupdatedto.getExpertise());
					    st1.setString(6, reportupdatedto.getClientId());
					    st1.setString(7, reportupdatedto.getEmail());
					    st1.setString(8, reportupdatedto.getTeamId());
					    st1.setString(9, reportupdatedto.getProfCamps());
					    st1.setString(10, reportupdatedto.getProfProject());
					    st1.setString(11, reportupdatedto.getDoj());
					    st1.setString(12, reportupdatedto.getLastWD());
					    st1.setString(13, reportupdatedto.getIsBillable());
					    st1.setString(14, reportupdatedto.getIsActive());
					    st1.setString(15, reportupdatedto.getCost());
					    st1.setString(16, reportupdatedto.getUserName());
					    st1.setString(17, reportupdatedto.getAction());
					    st1.setString(18, reportupdatedto.getTimeStamp());
					    st1.setDate(19, reportupdatedto.getDate());
					 
						st1.executeUpdate();
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
			public void insertintoEmpReoptr_Authorized(EmployeeReportUpdateDTO reportUpdateDTO) {
			
			// TODO Auto-generated method stub
			try {
				Connection con = DBConnection.getConnection();
				if(con != null){
					
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.INSERT_EMPLOYEE_REPORT_AUTHORIZED_QUERY);
					 
					    st1.setString(1, reportUpdateDTO.getUserName());
					    st1.setString(2, reportUpdateDTO.getAction());
					    st1.setString(3, reportUpdateDTO.getTimeStamp());
					    st1.setDate(4, reportUpdateDTO.getDate());
					 	st1.setString(5, reportUpdateDTO.getEmpId());
					 
						st1.executeUpdate();
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
}



