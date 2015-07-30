package com.accenture.tmt.dao;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.common.PROPERTY;
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.dao.dto.ModuleDetailsFlatDTO;
import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;
import com.accenture.tmt.manager.ExcelController;
import com.accenture.tmt.presentation.dto.EmployeeDetailsDTO;


public class ExcelDAO {
	
	public int addFromExcel(List<EmployeeDetailsFlatDTO> excel){
		Connection con;
		int a = 0;
		
		try {
			con = DBConnection.getConnection();
			for(int i=0;i<excel.size();i++){
			PreparedStatement st = con.prepareStatement(CONSTANTS.EMPLOYEE_INSERT);
					if (excel.get(i).getEmpId() != null) {
						st.setString(1, excel.get(i).getEmpId());
					} else {
						throw new SQLException("primary key cannot be null");
					}

					if (excel.get(i).getEmpName() != null) {
						st.setString(2, excel.get(i).getEmpName());
					} else {
						st.setString(2, "");
					}
					if (excel.get(i).getDesignation() != null) {
						st.setString(3, excel.get(i).getDesignation());
					} else {
						st.setString(3, "");
					}
					if (excel.get(i).getLevel() != null) {
						st.setString(4, excel.get(i).getLevel());
					} else {
						st.setString(4, "");
					}
					if (excel.get(i).getExpertise() != null) {
						st.setString(5, excel.get(i).getExpertise());
					} else {
						st.setString(5, "");
					}
					if (excel.get(i).getClass() != null) {
						st.setString(6, excel.get(i).getClientId());
					} else {
						st.setString(6, "");
					}
					if (excel.get(i).getEmail() != null) {
						st.setString(7, excel.get(i).getEmail());

					} else {
						st.setString(7, "");
					}
					if (excel.get(i).getTeamId() != null) {
						st.setString(8, excel.get(i).getTeamId());

					} else {
						st.setString(8, "");
					}
					if (excel.get(i).getProfCamps() != null) {
						st.setString(9, excel.get(i).getProfCamps());

					} else {
						st.setString(9, "");
					}
					if (excel.get(i).getProfProject() != null) {
						st.setString(10, excel.get(i).getProfProject());

					} else {
						st.setString(10, "");
					}
					if (excel.get(i).getDoj() != null) {
						st.setString(11, excel.get(i).getDoj());

					} else {
						st.setString(11,"");
					}
					if (excel.get(i).getLastWD() != null) {
						st.setString(12, excel.get(i).getLastWD());

					} else {
						st.setString(12, "");
					}
					
			
			if (excel.get(i).getIsBillable() != null) {
				st.setString(13, excel.get(i).getIsBillable());

			} else {
				st.setString(13, "");
			}
			
			if (excel.get(i).getIsActive() != null) {
				st.setString(14, excel.get(i).getIsActive());

			} else {
				st.setString(14, "");
			}
			if (excel.get(i).getCost() != null) {
				st.setString(15, excel.get(i).getCost());

			} else {
				st.setString(15, "");
			}	
					
			a = st.executeUpdate();
			}
			if(a!=0){
				System.out.println("Record Inserted221213`3");
			}
			if(a ==0){
				
			System.out.println("Record insertion failed321141`4");
		}
		
			
			con.commit();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public int addFromExcel1(List<TeamDetailsFlatDTO> excel){
		Connection con;
		int a = 0;
		
		try {
			con = DBConnection.getConnection();
			for(int i=0;i<excel.size();i++){
			PreparedStatement st = con.prepareStatement(CONSTANTS.TEAM_INSERT1);
					if (excel.get(i).getTeamName() != null) {
						st.setString(1, excel.get(i).getTeamName());
					} else { 
						st.setString(1, "");
					}
					if (excel.get(i).getTeamId() != null) {
						st.setString(2, excel.get(i).getTeamId());
					}
						else {
							throw new SQLException("primary key cannot be null");
						}
					if(excel.get(i).getModuleId() != null) {
						st.setString(3,excel.get(i).getModuleId());
					} 
					else {
						st.setString(3, "");
					}
					if (excel.get(i).getTeamDescription() != null) {
						st.setString(4, excel.get(i).getTeamDescription());
					}
					else {
						st.setString(4, "");
					}
					if (excel.get(i).getStatus() != null) {
						st.setString(5,excel.get(i).getStatus());
					} else {
						st.setString(5, "");
					}
					
					a = st.executeUpdate();
			}
			if(a!=0){
				System.out.println("Record Inserted");
			}
			if(a ==0){
				
			System.out.println("Record insertion Failed");
		}
		
			
			con.commit();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
}

	
	public int addModuleFromExcel(List<ModuleDetailsFlatDTO> moduleList) {
		Connection con;
		int b = 0;
		
		try {
			con = DBConnection.getConnection();
			for(int j=0;j<moduleList.size();j++){
				PreparedStatement rs = con.prepareStatement(CONSTANTS.MODULE_INSERT);
				
				if (moduleList.get(j).getModuleName() != null) {
					rs.setString(1, moduleList.get(j).getModuleName());
				}else{
					rs.setString(1, "");
				}
				
				if (moduleList.get(j).getProjectId() != null ){
					rs.setString(2, moduleList.get(j).getProjectId());
				} else{
					rs.setString(2, "");
				}
				
				if (moduleList.get(j).getModuleId() != null ){
					rs.setString(3, moduleList.get(j).getModuleId());
				} else{
					throw new SQLException("primary key cannot be null");
				}
				
				if (moduleList.get(j).getModuleDescription() != null ){
					rs.setString(4, moduleList.get(j).getModuleDescription());
				} else{
					rs.setString(4,"");
				}
			
				if (moduleList.get(j).getStatus() != null ){
					rs.setString(5, moduleList.get(j).getStatus());
				} else{
					rs.setString(5,"");
				}
				
				b = rs.executeUpdate();
			}
			if(b!=0){
				System.out.println("Record Inserted");
			}
			
			if(b == 0){	
				System.out.println("Record insertion failed");
			}

			con.commit();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b; 	
	}
	
	public String fetchTeamIdForExcel(EmployeeDetailsDTO listOfEmps ) {
		// TODO Auto-generated method stub
		//ExcelController prjDetails =new ExcelController();
		 String teamId=null;
	
		//List<EmployeeDetailsFlatDTO> li=new ArrayList<EmployeeDetailsFlatDTO>();
        ResultSet rs = null ;
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con.prepareStatement(PROPERTY.FETCHDETAILS);
		
					
					st.setString(1, listOfEmps.getProjectName());
					st.setString(2, listOfEmps.getModuleName());
					st.setString(3, listOfEmps.getTeamName());
					rs = st.executeQuery();
				
				
				while(rs.next()){
				
						  
						 teamId = rs.getString("TeamId");
				 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamId;
	}
	
}