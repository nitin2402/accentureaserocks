package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.ModuleDetailsDTO;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;

public class ModuleDAO {
	public void addModule(ModuleDetailsDTO newModule){
		try {
			Connection con = DBConnection.getConnection();
			
			String projectId="0" ;
			String  sqlInsert = "insert into ModuleDetail (ModuleName,ProjectId) values(?,?)";
	//		String sqlFetchProjectName = "select ProjectId from ProjectDetail where ProjectName=?";
			PreparedStatement st = con.prepareStatement(sqlInsert);
	//		System.out.println(newModule.getProject());
	// projectId = fetchProjectId(newModule.getProject()); 
	 st.setString(1, newModule.getModuleName());
	 st.setString(2, projectId);
		st.executeUpdate();
			
		con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String fetchModuleId(String module){
		
		try {
			Connection con = DBConnection.getConnection();
			

			String sqlFetch = "SELECT ModuleId FROM ModuleDetail where ModuleName=?";
			
			PreparedStatement st = con.prepareStatement(sqlFetch);
			
			st.setString(1, module);
		
			ResultSet rs = st.executeQuery();
		//	ResultSetMetaData metaData = rs.getMetaData();
		//	int count = metaData.getColumnCount();
		
		//	System.out.println();
		//	System.out.println(rs.getString("ModuleName"));
			while(rs.next()){
	
			module= rs.getString("ModuleId");

			}

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println(a);
		return module;
	}
	
	public int editModule(String moduleName, String projectId, String moduleDescription, String moduleId){
		int status=0;
		try {
			Connection con = DBConnection.getConnection();
			

		
			
			PreparedStatement st = con.prepareStatement(CONSTANTS.MODULE_UPDATE);
		//	System.out.println(module+id+projectId);
			st.setString(1, moduleName);
			st.setString(2, projectId);
			st.setString(3, moduleDescription);
			st.setString(4, moduleId);
			
			status = st.executeUpdate();
		//	ResultSetMetaData metaData = rs.getMetaData();
		//	int count = metaData.getColumnCount();
		
		//	System.out.println();
		//	System.out.println(rs.getString("ModuleName"));
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

	public String fetchProjectId(String projectName) {
			String projectId="0" ;
			try {
				Connection con = DBConnection.getConnection();
				
			
		//		String  sqlInsert = "insert into ModuleDetail (ModuleName,ProjectId) values(?,?)";
				String sqlFetchProjectId = "select ProjectId from ProjectDetail where ProjectName=?";
				PreparedStatement st = con.prepareStatement(sqlFetchProjectId);
		//		System.out.println(newModule.getProject());
				st.setString(1,projectName);
				ResultSet rs = st.executeQuery();
				
				while(rs.next())
				{
			projectId = rs.getString("ProjectId");
	//		System.out.println(projectId);
				}
		 /*st = con.prepareStatement(sqlInsert);
		 
		 st.setString(1, newModule.getModuleName());
		 st.setString(2, projectId);
			
			
			st.executeUpdate();*/
				
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return projectId;

	}
	
	public List<ModuleDetailsDTO> fetchModuleDetails(String module){
		List<ModuleDetailsDTO> ModuleDetailsList = new ArrayList<ModuleDetailsDTO>();
		ModuleDetailsDTO moduleList = null;
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(CONSTANTS.MODULE_DETAIL_FETCH);
			st.setString(1, module);
		
			ResultSet rs = st.executeQuery();
		//	ResultSetMetaData metaData = rs.getMetaData();
		//	int count = metaData.getColumnCount();
		
		//	System.out.println();
		//	System.out.println(rs.getString("ModuleName"));
			while(rs.next()){
	
				moduleList= new ModuleDetailsDTO();
				//moduleList.setProject(rs.getString(CONSTANTS.PROJECT));
				moduleList.setModuleName(module);
				moduleList.setModuleDescription(rs.getString(CONSTANTS.MODULE_DESCRIPTION));
				moduleList.setModuleId(rs.getString(CONSTANTS.MODULE_ID));
	
		ModuleDetailsList.add(moduleList);	
	}

con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println(a);
		return ModuleDetailsList;
		
	}
	
	public List<String> fetchModule() {
		List<String> list = new ArrayList<String>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(CONSTANTS.MODULE_FETCH);
			ResultSet rs = st.executeQuery();
			// ResultSetMetaData metaData = rs.getMetaData();
			// int count = metaData.getColumnCount();

			// System.out.println();
			// System.out.println(rs.getString("ModuleName"));
			while (rs.next()) {
				list.add(rs.getString("ModuleName"));
				// System.out.println(rs.getString("ModuleName"));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	
	public List<String> FetchModuleByProject(String project) {
		List<String> list = new ArrayList<String>();

		String projectId = null;
		try {
			Connection con = DBConnection.getConnection();

			String sqlFetch = "SELECT ProjectId FROM ProjectDetail WHERE ProjectName=? ";

			PreparedStatement st = con.prepareStatement(sqlFetch);

			st.setString(1, project);

			ResultSet rs = st.executeQuery();
			// ResultSetMetaData metaData = rs.getMetaData();
			// int count = metaData.getColumnCount();

			// System.out.println();
			// System.out.println(rs.getString("ModuleName"));
			while (rs.next()) {
				projectId = rs.getString("ProjectId");
				// System.out.println(rs.getString("ModuleName"));
			}

			String sql = "SELECT ModuleName FROM ModuleDetail WHERE ProjectId=? ";

			PreparedStatement st1 = con.prepareStatement(sql);

			st1.setString(1, projectId);

			ResultSet rs1 = st1.executeQuery();
			// ResultSetMetaData metaData = rs.getMetaData();
			// int count = metaData.getColumnCount();

			// System.out.println();
			// System.out.println(rs.getString("ModuleName"));
			while (rs1.next()) {
				list.add(rs1.getString("ModuleName"));
				// System.out.println(rs.getString("ModuleName"));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	public List<ModuleDetailsFlatDTO> viewModule(){
		
		List<ModuleDetailsFlatDTO> moduleList = new ArrayList<ModuleDetailsFlatDTO>();
		
		try {
			ModuleDetailsFlatDTO details = null;
			
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			
			String querry = "select * from ModuleDetail";
			ResultSet rs = st.executeQuery(querry);

		while(rs.next())
		{
			details =  new ModuleDetailsFlatDTO();
			details.setModuleId(rs.getString("ModuleId"));
			details.setModuleName(rs.getString("ModuleName"));
			details.setProjectId(rs.getString("ProjectId"));
			details.setModuleDescription(rs.getString("ModuleDescription"));
			
			moduleList.add(details);
		}
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return moduleList;
		
	}

	    public int deleteModule(String moduleId) throws SQLException, ClassNotFoundException {
		List<String> teamlist= new ArrayList<String>();
		Connection con = DBConnection.getConnection();
		int status=0;
		try{
			String sqlemp = "UPDATE Employee SET TeamId = 'FREE' WHERE TeamId =?";
			String sqlteam = "UPDATE Team SET Status = 'N' WHERE TeamId =?";
			String sqlmodule = "UPDATE ModuleDetail SET Status = 'N' WHERE ModuleName =?";
			PreparedStatement steam=con.prepareStatement("Select Team.TeamId from Team Inner Join ModuleDetail on Team.ModuleID=ModuleDetail.ModuleId where ModuleDetail.ModuleId=?");
			steam.setString(1, moduleId);
			ResultSet rsteam=steam.executeQuery();
		    while(rsteam.next()){
		    	teamlist.add(rsteam.getString("TeamId"));
		    }
		    for(int i=0;i<teamlist.size();i++){
		    	PreparedStatement stemp=con.prepareStatement(sqlemp);
		    	PreparedStatement steam1=con.prepareStatement(sqlteam);
		    	stemp.setString(1, teamlist.get(i));
		    	steam1.setString(1, teamlist.get(i));
		    	stemp.executeUpdate();
		    	steam1.executeUpdate();
		    	}
		    PreparedStatement st = con.prepareStatement(sqlmodule);
			st.setString(1, moduleId);
			st.executeUpdate();
			status=st.executeUpdate();
		}
		finally{
			con.commit();
			con.close();
			
		}
		return status;
		
	
	}

	public int insertModule(ModuleDetailsDTO moduledetailsdto) {

		ResultSet rs = null;
		String projectId = null;
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con
					.prepareStatement(CONSTANTS.Get_ProjectId_QUERY);
			st.setString(1, moduledetailsdto.getProject());
			rs = st.executeQuery();
			while (rs.next()) {
				projectId = rs.getString("ProjectId");
			}
			PreparedStatement st1 = con
					.prepareStatement(CONSTANTS.INSERTMODULE_QUERY);

			st1.setString(1, moduledetailsdto.getModuleName());
			st1.setString(2, projectId);
			st1.setString(3, moduledetailsdto.getModuleId());
			st1.setString(4, moduledetailsdto.getModuleDescription());
			st1.setString(5, "Y");

			status = st1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
		}			
	
	
	
	
	
	}



